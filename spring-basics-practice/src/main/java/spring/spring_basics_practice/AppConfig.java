package spring.spring_basics_practice;

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
 */
public class AppConfig {

    /**
     * Creates and returns a MemberService instance
     * Injects MemoryMemberRepository as a dependency
     * 
     * @return Configured MemberService implementation
     */
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    /**
     * Creates and returns an OrderService instance
     * Injects MemoryMemberRepository and FixDiscountPolicy as dependencies
     * 
     * @return Configured OrderService implementation
     */
    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy());
    }

    /**
     * Creates and returns a MemberRepository instance
     * Provides a centralized way to get the repository implementation
     *
     * @return Configured MemberRepository implementation
     */
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    /**
     * Creates and returns a DiscountPolicy instance
     * Enables easy switching between different discount policies
     *
     * @return Configured DiscountPolicy implementation
     */
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
