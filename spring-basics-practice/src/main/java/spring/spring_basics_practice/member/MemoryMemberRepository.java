package spring.spring_basics_practice.member;

import spring.spring_basics_practice.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository {

    //storage for members
    private static Map<Long, Member> store = new HashMap<>();

    //Save member to the storage
    //implementation of save method
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    //Find member by id
    //implementation of findById method
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
