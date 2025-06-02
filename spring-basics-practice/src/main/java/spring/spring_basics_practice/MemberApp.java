package spring.spring_basics_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.spring_basics_practice.member.Grade;
import spring.spring_basics_practice.member.MemberService;
import spring.spring_basics_practice.member.MemberServiceImpl;

/**
 * Application class to demonstrate member registration functionality
 * This class serves as a simple client for testing the member service using Spring Container
 */
public class MemberApp {
    public static void main(String[] args) {
        //Create a new memberService
        //MemberService memberService = new MemberServiceImpl();

        //Create AppConfig instance to get configured beans
//        AppConfig appConfig = new AppConfig();
        //Get MemberService from AppConfig (uses dependency injection)
//        MemberService memberService = appConfig.memberService();

        // Using Spring Container with AppConfig
        // ApplicationContext is the Spring container that manages all beans
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // Get the memberService bean from the Spring container
        MemberService memberService = ac.getBean("memberService", MemberService.class);

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
