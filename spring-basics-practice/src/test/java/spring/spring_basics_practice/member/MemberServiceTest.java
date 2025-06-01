package spring.spring_basics_practice.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.spring_basics_practice.Member;

public class MemberServiceTest {

    //Create a new memberService instance
    MemberService memberService = new MemberServiceImpl();

    //Test method
    @Test
    void join() {
        //given
        //Create a new member instance
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        //Join the member
        memberService.join(member);
        //Find the member by ID
        Member findMember = memberService.findMember(1L);

        //then
        //Assertions to check if the member is equal to the found member
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
