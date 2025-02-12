package com.my.mapService.repository;

import com.my.mapService.dto.Member;
import org.junit.jupiter.api.*;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MapMemberRepositoryTest {
    MapMemberRepository repository = new
             MapMemberRepository();
@AfterEach

    public void afterEach() {
    repository.clearStore();
    }
    @Test
    void save() {
//Given
        Member member = new Member();
        member.setName("장원영");
        member.setAddress("서울");
//        When
        Member result =repository.save(member);
//        Then
        Member saveMember = new Member();
        Long saveId = 1L;
//        org.junit/jupiter
        Assertions.assertEquals(member.getId(),saveId);
//        org.assertj.core.api -- static import
        assertThat(result.getId()).isEqualTo(saveId);
    }

    @Test
    @DisplayName("id로 검색하기")
    void findById() {
//        Given
        Member member = new Member();
        member.setName("안유진");
        member.setAddress("제주도");
        repository.save(member);

//        When
        Long id = 1L;
        Member findMember = repository.findById(id).get();
//        Then
        assertThat(findMember.getName()).isEqualTo("안유진");
    }
    @Test
    @DisplayName("id로 검색 실패")
    void findById_Fail() {
//        Given
        Member member = new Member();
        member.setName("안유진");
        member.setAddress("제주도");
        repository.save(member);

//        When
        Long id = 2L;
        Member findMember = repository.findById(id).orElse(null);
//        Then
        assertThat(findMember).isEqualTo(null);
    }

}