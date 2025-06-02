package spring.spring_basics_practice.discount;

import org.springframework.stereotype.Component;
import spring.spring_basics_practice.Member;
import spring.spring_basics_practice.member.Grade;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    //field
    private int discountPercent = 10;

    //implemention of the discount method
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            // 10% discount for VIP members
            return price * discountPercent / 100;
        } else {
            // No discount for non-VIP members
            return 0;
        }
    }
}
