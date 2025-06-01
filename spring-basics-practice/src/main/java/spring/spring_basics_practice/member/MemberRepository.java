package spring.spring_basics_practice.member;

import spring.spring_basics_practice.Member;

public interface MemberRepository {

    //Methods
    void save(Member member);

    Member findById(String id);
}
