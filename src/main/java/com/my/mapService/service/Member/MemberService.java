package com.my.mapService.service.Member;

import com.my.mapService.dto.Member;
import com.my.mapService.repository.MapMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@RequiredArgsConstructor
@Service
public class MemberService {
    //1.필드주입방법

    @Autowired
//    MapMemberRepository memberRepository;
    //2.필즈 주입방법
//    private final MapMemberRepository repository;
//    3.생성자 주입방법
    private final MapMemberRepository memberRepository;


    public MemberService(MapMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입 기능
    public Long join(Member member) {
        //같은 이름이 있는 중복회원 x
        Optional<Member> result = memberRepository.findByName(member.getName());
        if (result.isPresent()&&
            result.get().getAddress().equals(member.getAddress())) {
                return -1L;
            } else {
//    입력가능
                Member save = memberRepository.save(member);
                return save.getId();
            }

    }

    //    아이디 검색해서 1개 찾기
    public Optional<Member> findOne(Long id) {
        return memberRepository.findById(id);

    }

    //    전체리스트 출력
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    //    삭제처리
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    //수정처리
    public void update(Member member){
        memberRepository.updateById(member.getId(),member);
    }
}
