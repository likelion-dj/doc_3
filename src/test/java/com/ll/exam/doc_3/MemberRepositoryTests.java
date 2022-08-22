package com.ll.exam.doc_3;

import com.ll.exam.doc_3.member.entity.Member;
import com.ll.exam.doc_3.member.repository.MemberRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@SpringBootTest
@Transactional
@TestInstance(PER_CLASS)
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @BeforeAll
    void beforeAll() {
        Member m1 = Member
                .builder()
                .username("admin")
                .email("admin@test.com")
                .password("{noop}1234")
                .name("관리자1")
                .build();

        Member m2 = Member
                .builder()
                .username("user1")
                .email("user1@test.com")
                .password("{noop}1234")
                .name("유저1")
                .build();

        memberRepository.saveAll(Arrays.asList(m1, m2));
    }

    @Test
    @DisplayName("등록")
    void t1() {
        Member m = Member
                .builder()
                .username("user2")
                .email("user2@test.com")
                .password("{noop}1234")
                .name("유저2")
                .build();
        memberRepository.save(m);

        memberRepository.findByUsername("user2").get();
    }

    @Test
    @DisplayName("수정")
    @Rollback(false)
    void t2() {
        Member m = memberRepository.findByUsername("user1").get();
        m.setName("유저1!!");
    }
}
