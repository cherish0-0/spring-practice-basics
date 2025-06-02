package spring.spring_basics_practice.beanfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.spring_basics_practice.member.MemberRepository;
import spring.spring_basics_practice.member.MemoryMemberRepository;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class to demonstrate how to handle multiple beans of the same type
 * Shows different ways to differentiate between beans with the same type
 */
public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    /**
     * Test to demonstrate the exception when looking up a bean by type only
     * When multiple beans of the same type exist, Spring cannot determine which one to return
     */
    @Test
    @DisplayName("fail to find bean by type: expect exception when multiple beans of same type exist")
    void findBeanByTypeDuplicate() {
        //MemberRepository bean = ac.getBean(MemberRepository.class);
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(MemberRepository.class));
    }

    /**
     * Test finding a specific bean by name when multiple beans of same type exist
     * Using the bean name resolves the ambiguity between multiple beans of same type
     */
    @Test
    @DisplayName("find bean by name: specify bean name to avoid exception")
    void findBeanByName() {
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    /**
     * Test retrieving all beans of a specific type
     * Demonstrates how to work with multiple beans of the same type at once
     */
    @Test
    @DisplayName("find all beans of specific type")
    void findAllBeanByType() {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        beansOfType.entrySet().stream()
                .forEach(entry -> {
                    System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
                });
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    //Inner configuration class that defines multiple beans of the same type
    @Configuration
    static class SameBeanConfig {

        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
