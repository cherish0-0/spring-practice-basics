package spring.spring_basics_practice.order;

import spring.spring_basics_practice.Member;
import spring.spring_basics_practice.discount.DiscountPolicy;
import spring.spring_basics_practice.discount.FixDiscountPolicy;
import spring.spring_basics_practice.member.MemberRepository;
import spring.spring_basics_practice.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    //fields
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    //implementation of createOrder method
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // Find the member by ID
        Member member = memberRepository.findById(memberId);

        // Calculate the discount amount using the discount policy
        int discountAmount = discountPolicy.discount(member, itemPrice);

        // Create and return a new Order object
        return new Order(memberId, itemName, itemPrice, discountAmount);
    }
}
