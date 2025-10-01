package com.main.todo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public void save(){
        memberRepository.save(Member.builder()
                        .age(5)
                        .username("test")
                .build());
    }
}
