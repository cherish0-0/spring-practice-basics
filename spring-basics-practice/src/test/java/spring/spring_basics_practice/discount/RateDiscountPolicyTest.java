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
    //@DisplayName annotation explicitly expresses the purpose of the test
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
        //assertThat(): Intuitive test verification using AssertJ library
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("Non-VIP members should not receive a discount")
    void vip_x() {
        //given
        //Create a new member
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        //when
        //Calculate the discount for the member with a price of 10000
        int discount = discountPolicy.discount(member, 10000);

        //then
        //Assertions to check if the discount is equal to 0 (no discount for non-VIP members)
        assertThat(discount).isEqualTo(0);
    }
}
