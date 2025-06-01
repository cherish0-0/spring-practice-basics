package spring.spring_basics_practice.discount;

import spring.spring_basics_practice.Member;
import spring.spring_basics_practice.member.Grade;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // Fixed discount amount for VIP members

    //implementation of discount method
    @Override
    public int discount(Member member, int price) {
        // Check if the member is a VIP
        if (member.getGrade() == Grade.VIP) {
            // If VIP, return the fixed discount amount
            return discountFixAmount;
        } else {
            // If not VIP, no discount is applied
            return 0;
        }
    }
}
