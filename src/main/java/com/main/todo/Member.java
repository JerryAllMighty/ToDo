package com.main.todo;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //id

    @Column(nullable = false)
    private String username; //사용자 이름

    private int age; //나이

    @Column(precision = 5, scale = 2)
    private BigDecimal gogo2; //임시 변수 (테스트용)

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

}
