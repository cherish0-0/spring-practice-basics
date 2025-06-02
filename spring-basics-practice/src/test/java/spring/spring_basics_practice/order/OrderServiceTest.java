package spring.spring_basics_practice.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.spring_basics_practice.Member;
import spring.spring_basics_practice.member.*;

public class OrderServiceTest {

    //Create a new memberService and orderService instances
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    //test method
    @Test
    void createOrder() {
        //given
        //Create a new member ID and member instance
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        //when
        //Create an order for the member
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //then
        //Assertions to check if the order is created correctly
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
