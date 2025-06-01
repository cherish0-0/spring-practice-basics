package spring.spring_basics_practice;

import spring.spring_basics_practice.member.Grade;
import spring.spring_basics_practice.member.MemberService;
import spring.spring_basics_practice.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        //Create a new memberService
        MemberService memberService = new MemberServiceImpl();
        //Create a new member
        Member member = new Member(1L, "memberA", Grade.VIP);

        //Join the member
        memberService.join(member);

        //Find the member by ID
        Member findMember = memberService.findMember(1L);

        //Print the member names
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
