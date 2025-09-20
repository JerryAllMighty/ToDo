package com.main.todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // findByName, findByAge 등 메서드 네이밍으로 자동 쿼리 생성 가능
}
