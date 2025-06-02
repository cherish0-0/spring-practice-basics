package spring.spring_basics_practice;

import spring.spring_basics_practice.member.Grade;
import spring.spring_basics_practice.member.MemberService;
import spring.spring_basics_practice.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        //Create a new memberService
        //MemberService memberService = new MemberServiceImpl();

        //Create AppConfig instance to get configured beans
        AppConfig appConfig = new AppConfig();
        //Get MemberService from AppConfig (uses dependency injection)
        MemberService memberService = appConfig.memberService();

        //Create a new test member
        Member member = new Member(1L, "memberA", Grade.VIP);

        //Register the newly created member using the service
        memberService.join(member);

        //Find the member by ID
        Member findMember = memberService.findMember(1L);

        //Print the member names
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
