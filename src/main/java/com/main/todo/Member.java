package com.main.todo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //id

    private String username; //사용자 이름

    private int age; //나이

    private int gogo2; //임시 변수 (테스트용)

}
