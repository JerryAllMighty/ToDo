package com.main.todo;

import com.main.todo.domain.Member;
import com.main.todo.repository.MemberRepository;
import com.main.todo.service.MemberService;
import jakarta.transaction.Transactional;
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
        Member member = new Member();
        member.setName("Kim");

        long savedId = memberRepository.save(member);

        assertEquals(member, memberRepository.findOne(savedId));

    }

    @Test
    void 중복_회원_예외() throws Exception {
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        memberService.join(member1);
        try {
            memberService.join(member2);
        } catch (IllegalStateException e) {
            return;
        }
//        assertThrows(new IllegalStateException, memberService.join(member2));
        fail("예외가 발생해야한다");
    }
}