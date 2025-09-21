package com.main.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MainService {

    @Autowired
    MemberRepository memberRepository;

//    private Member getMember(Long id) {
//        Optional<Member> member = Optional.of(memberRepository.findById(id).orElseThrow());
//        return member;
//    }

}
