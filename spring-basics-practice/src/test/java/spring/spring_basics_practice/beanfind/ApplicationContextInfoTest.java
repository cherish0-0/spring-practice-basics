package spring.spring_basics_practice.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.spring_basics_practice.AppConfig;

import java.util.Arrays;

public class ApplicationContextInfoTest {
    // Create Spring container with AppConfig class
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    /**
     * Test method to display all beans in the Spring container
     * Lists every bean regardless of its origin (application or infrastructure)
     */
    @Test
    @DisplayName("display all beans")
    void findAllBean() {
        Arrays.stream(ac.getBeanDefinitionNames())
                .forEach(beanDefinitionName -> {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.printf("name = %s, object = %s%n", beanDefinitionName, bean);
        });
    }

    /**
     * Test method to display only application beans
     * Filters out infrastructure beans that are created by Spring internally
     * Only shows beans defined by the application developer
     */
    @Test
    @DisplayName("display application beans")
    void findApplicationBean() {
        Arrays.stream(ac.getBeanDefinitionNames())
                .filter(name -> ac.getBeanDefinition(name).getRole() == BeanDefinition.ROLE_APPLICATION)
                .forEach(name -> {
                    Object bean = ac.getBean(name);
                    System.out.printf("name = %s, object = %s%n", name, bean);
                });
    }
}
