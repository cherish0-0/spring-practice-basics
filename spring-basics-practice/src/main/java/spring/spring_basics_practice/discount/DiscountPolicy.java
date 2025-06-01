package spring.spring_basics_practice.discount;

import spring.spring_basics_practice.Member;

public interface DiscountPolicy {

    //Methods
    int discount(Member member, int price);
}
