package com.main.todo;

import com.main.todo.domain.Member;
import com.main.todo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;


    @Test
    @Transactional
    public void saveTest() {
        //given
        Member member = new Member();
        member.setName("memberA");

        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.findOne(savedId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
        Assertions.assertThat(findMember).isEqualTo(member);
        //같은 영속성 컨텍스트 안에서는 id 값이 같으면 같은 객체라고 간주
        System.out.println("findMember == member" + (findMember == member));

    }

    @Test
    @Transactional
    public void saveTestForTDD() {
        //테스트 작성
        // 실행 가능하게
        //올바르게
        //먼저 작동하게, 그 다음 깔끔하게

        //설계상의 결함을 그 결함으로 인해 실패하는 테스트로 변환
        //스텁 구현
        //올바른 코드 테스트

        //given

        //when

        //then

    }

}