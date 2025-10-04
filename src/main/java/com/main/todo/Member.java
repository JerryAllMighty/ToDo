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
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB에 위임
    private Long id; //id

    @Column(nullable = false)
    private String name; //사용자 이름

    private String city;

    private String street;

    private String zipCode;


}
