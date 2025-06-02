package spring.spring_basics_practice.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.spring_basics_practice.AppConfig;
import spring.spring_basics_practice.member.MemberService;
import spring.spring_basics_practice.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;

/**
 * Test class to demonstrate basic Spring bean lookup methods
 * Shows different ways to find beans in the Spring container
 */
public class ApplicationContextBasicFindTest {
    // Create Spring container with AppConfig class
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    /**
     * Test looking up a bean by its name and type
     * This is the most common and specific way to get a bean
     */
    @Test
    @DisplayName("find by bean name")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    /**
     * Test looking up a bean by its type only
     * Works well when there's only one bean of that type
     * Can cause conflicts if multiple beans of the same type exist
     * How to avoid conflicts: refer to the file 'ApplicationContextSameBeanFindTest.java'
     */
    @Test
    @DisplayName("find only by type without bean name")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    /**
     * Test looking up a bean by name and implementation type
     * Not recommended as it couples client code with implementation
     * Violates the dependency inversion principle
     */
    @Test
    @DisplayName("find by concrete type")
    void findBeanByName2() {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    /**
     * Test the exception case when a bean is not found
     * Verifies that the correct exception is thrown when requesting a non-existent bean
     */
    @Test
    @DisplayName("fail to find bean by name")
    void findBeanByNameX() {
        // ac.getBean("xxxx", MemberService.class); // This will throw an exception
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class, () ->
                ac.getBean("xxxx", MemberService.class));
    }
}
