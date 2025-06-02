package spring.spring_basics_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.spring_basics_practice.discount.DiscountPolicy;
import spring.spring_basics_practice.discount.FixDiscountPolicy;
import spring.spring_basics_practice.discount.RateDiscountPolicy;
import spring.spring_basics_practice.member.MemberRepository;
import spring.spring_basics_practice.member.MemberService;
import spring.spring_basics_practice.member.MemberServiceImpl;
import spring.spring_basics_practice.member.MemoryMemberRepository;
import spring.spring_basics_practice.order.OrderService;
import spring.spring_basics_practice.order.OrderServiceImpl;

/**
 * AppConfig class that serves as a configuration for the application
 * Acts as a factory for creating and connecting application components
 * Centralizes all object creation and dependency injection
 *
 * {@code @Configuration} annotation marks this class as a Spring configuration class
 * This enables Spring to process the class and generate Spring beans from methods annotated with @Bean
 */
@Configuration
public class AppConfig {

    /**
     * Creates and returns a MemberService instance
     * Injects MemberRepository obtained from memberRepository() method
     * 
     * @Bean annotation registers the returned object as a Spring bean
     * @return Configured MemberService implementation managed by Spring
     */
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    /**
     * Creates and returns an OrderService instance
     * Injects dependencies from other @Bean methods: memberRepository() and discountPolicy()
     * This demonstrates method-call reuse for bean dependencies
     * 
     * @return Configured OrderService implementation managed by Spring
     */
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    /**
     * Creates and returns a MemberRepository instance
     * Provides a centralized way to get the repository implementation
     *
     * @return Configured MemberRepository implementation
     */
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    /**
     * Creates and returns a DiscountPolicy instance
     * Enables easy switching between different discount policies
     *
     * @return Configured DiscountPolicy implementation
     */
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
