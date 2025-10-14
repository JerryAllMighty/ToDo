package com.main.todo;

import com.main.todo.domain.Member;
import com.main.todo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public void save(){
        //TODO : 바뀐 member 엔티티에 맞추어서 메서드 완성 필요
        memberRepository.save(Member.builder()
                .build());
    }
}
