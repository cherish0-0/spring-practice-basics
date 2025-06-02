package spring.spring_basics_practice.member;

import spring.spring_basics_practice.Member;

public class MemberServiceImpl implements MemberService {

    //field
    //initialization of the memberRepository

//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // Using constructor injection for better testability and flexibility
    private final MemberRepository memberRepository;

    //constructor for dependency injection
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //implementation of join method
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    //implementation of findMember method
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
