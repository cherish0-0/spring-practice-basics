package spring.spring_basics_practice.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Test class demonstrating the interaction between singleton and prototype scoped beans
 */
@Configuration
public class SingletonWithPrototypeTest {

    /**
     * Test to verify behavior when a singleton bean uses a prototype bean
     * Expected behavior: The prototype bean is created once and reused
     * because it's just injected into the singleton bean once at creation time
     */
    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        // First client request
        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        Assertions.assertThat(count1).isEqualTo(1);

        // Second client request - using the same singleton bean
        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        Assertions.assertThat(count2).isEqualTo(2);
    }

    /**
     * Singleton scoped client bean that depends on a prototype bean
     * The prototype bean is injected only once during initialization
     */
    static class ClientBean {
        private final PrototypeBean prototypeBean;

        @Autowired
        public ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public int logic() {
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        /**
         * Initialization callback method
         * Prints the bean instance when created
         */
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);
        }

        /**
         * Destruction callback method
         * Note: Not automatically called for prototype beans
         */
        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
