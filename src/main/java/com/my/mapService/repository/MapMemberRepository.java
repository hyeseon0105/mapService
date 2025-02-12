package com.my.mapService.repository;

import com.my.mapService.dto.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Repository
public class MapMemberRepository implements MemberRepository{
    //    전체 맴버를 저장할 맵을 선언
    public static Map<Long, Member> store = new HashMap<>();
//    맵에 저장할때 사용할 아이디(키값)선언
    private static Long sequence =1L;

    @Override
    public Member save(Member member) {
        member.setId(sequence);
        sequence++;
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
       return Optional.ofNullable(store.get(id));
//Optional은 결과가 있으면 돌려주고, 없으면 null값을 돌려준다.
    }

    @Override
    public List<Member> findAll() {
        return List.of();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Member updateById(Long memberId, Member member) {
        return null;
    }

    void clearStore() {
        store.clear();
        sequence = 1L;
    }
}
