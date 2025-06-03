package spring.spring_basics_practice.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

    @Test
    public void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);

        // Assert that the two beans are different instances
        // Prototype scope creates a new bean instance for each request
        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        // Close the container
        // Note: destroy method won't be called for prototype beans
        ac.close();
    }

    @Scope("prototype")
    static class PrototypeBean {

        /**
         * Initialization callback method
         * Called after the bean is instantiated
         */
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        /**
         * Destruction callback method
         * Note: This method is not called automatically for prototype beans
         * Spring does not manage the prototype beans
         * after they are created, Dependency Injection is done, initialization is complete
         */
        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
