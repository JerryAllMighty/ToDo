package com.main.todo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Transactional
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public void save(){
        memberRepository.save(Member.builder()
                        .gogo2(BigDecimal.valueOf(1.2345678940))
                        .roleType(RoleType.GUEST)
                        .age(5)
                        .username("test")
                .build());
    }
}
