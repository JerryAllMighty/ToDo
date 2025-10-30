package com.main.todo.service;

import com.main.todo.domain.Member;
import com.main.todo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    //TODO : JPA 실전편 1 , 17강에서 해당하는 생성자 주입까지의 과정, 잘 이해하기
    private final MemberRepository memberRepository;
    //기존의 memberRepository를 바꿀 수 없다. 테스트 등 바꿔야하는 케이스가 생긴다
    // 그래서 setter injection을 쓰기도 한다. Mock 같은 거 주입도 가능
    // 하지만 한 번 애플리케이션이 뜨고 나면 또, 바꿀 일이 없어서, setter injection을 쓰는 것도 또 애매하다.
    // 그래서 생성자 injection을 사용한다

    //생성자 injection
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void save() {

    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        //TODO : 바뀐 member 엔티티에 맞추어서 메서드 완성 필요
        validateDuplicateMember(member);
        memberRepository.save(Member.builder()
                .build());

        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> foundMembers = memberRepository.findByName(member.getName());
        if (!foundMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    @Transactional(readOnly = true)
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);

    }
}
