package spring.spring_basics_practice.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.spring_basics_practice.Member;
import spring.spring_basics_practice.member.Grade;

import static org.assertj.core.api.Assertions.*;

public class RateDiscountPolicyTest {

    //Create a new RateDiscountPolicy instance
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    //Test method
    @Test
    @DisplayName("VIP members should receive a 10% discount")
    void vip_o() {
        //given
        //Create a new member
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        //Calculate the discount for the member with a price of 10000
        int discount = discountPolicy.discount(member, 10000);

        //then
        //Assertions to check if the discount is equal to 1000 (10% of 10000)
        assertThat(discount).isEqualTo(1000);
    }
}
