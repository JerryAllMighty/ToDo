package com.main.todo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = {@UniqueConstraint(name = "pk_user_id", columnNames = {"id"}), @UniqueConstraint(name = "pk_user_username", columnNames = {"name"})})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //id

    @Column(name = "name", nullable = false)
    private String username; //사용자 이름

    private int age; //나이

    private int gogo2; //임시 변수 (테스트용)

}
