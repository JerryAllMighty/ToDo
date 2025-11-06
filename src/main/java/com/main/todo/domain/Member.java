package com.main.todo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB에 위임
    private Long id; //id

    @Column(nullable = false)
    private String name; //사용자 이름

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Order> orderList = new ArrayList<>();

    @Embedded
    private Address address;
}
