package com.main.todo.repository;

import com.main.todo.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext //해당 Bean이 있다면 스프링이 생성한 엔티티 매니저를 주입해준다
    private EntityManager em;


//    @PersistenceUnit //해당 Bean이 있다면 스프링이 생성한 엔티티 매니저 팩토리를 주입해준다
//    private EntityManagerFactory emf;


    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        //SQL 이랑 다른 건, jpql은 객체에 대한 조회
        List<Member> result = em.createQuery("select m from Member m", Member.class)
                .getResultList();
        return result;
    }

    public List<Member> findByName(String name){
        List<Member> result = em.createQuery("select  m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result;

    }
}
