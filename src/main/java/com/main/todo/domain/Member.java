package com.main.todo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB에 위임
    private Long id; //id

    @Column(nullable = false)
    private String name; //사용자 이름

    @OneToMany(mappedBy = "member")
    private List<Order> orderList;

    @Embedded
    private Address address;


//    private String city;
//
//    private String street;
//
//    private String zipCode;


}
