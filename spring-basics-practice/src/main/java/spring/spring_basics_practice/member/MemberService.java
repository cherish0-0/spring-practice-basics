package spring.spring_basics_practice.member;

import spring.spring_basics_practice.Member;

public interface MemberService {

    // Methods
    void join(Member member);

    Member findMember(Long memberId);
}
