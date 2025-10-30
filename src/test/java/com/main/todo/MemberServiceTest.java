package com.main.todo;

import com.main.todo.domain.Member;
import com.main.todo.repository.MemberRepository;
import com.main.todo.service.MemberService;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원가입() {
        Member member =  new Member();
        member.setName("Kim");

        long savedId = memberRepository.save(member);

        assertEquals(member, memberRepository.findOne(savedId));

    }

    @Test
    void 중복_회원_예외() {
    }
}