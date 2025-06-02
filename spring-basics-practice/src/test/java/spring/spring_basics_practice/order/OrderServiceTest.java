package spring.spring_basics_practice.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.spring_basics_practice.AppConfig;
import spring.spring_basics_practice.Member;
import spring.spring_basics_practice.member.*;

public class OrderServiceTest {

    //Create a new memberService and orderService instances
//    MemberService memberService = new MemberServiceImpl();
//    OrderService orderService = new OrderServiceImpl();

    MemberService memberService;
    OrderService orderService;

    /**
     * Setup method that runs before each test
     * Creates a new AppConfig and gets the memberService and orderService
     * This ensures each test starts with a fresh instance
     */
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }



    //test method
    @Test
    void createOrder() {
        //given
        //Create a new member ID and member instance
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        //when
        //Register the member and create an order
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //then
        //Assertions to check if the order is created correctly
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
