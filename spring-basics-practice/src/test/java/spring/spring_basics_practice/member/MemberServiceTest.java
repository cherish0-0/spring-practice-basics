package spring.spring_basics_practice.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.spring_basics_practice.AppConfig;
import spring.spring_basics_practice.Member;

public class MemberServiceTest {

    //Create a new memberService instance
//    MemberService memberService = new MemberServiceImpl();

    MemberService memberService;

    /**
     * Setup method that runs before each test
     * Creates a new AppConfig and gets the memberService
     * This ensures each test starts with a fresh instance
     */
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    //Test method
    @Test
    void join() {
        //given
        //Create a new member instance for testing
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        //Register the member in the system
        memberService.join(member);
        //Find the member by ID
        Member findMember = memberService.findMember(1L);

        //then
        //Assertions to check if the member is equal to the found member
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
