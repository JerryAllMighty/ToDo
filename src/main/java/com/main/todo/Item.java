package com.main.todo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    //TODO : int 형으로 선언이 뭐가 다른지
    private Integer price;

    private Integer stockQuantity;

    @Enumerated(EnumType.STRING)
    private DeliveryType dType;

    private String artist;

    private String etc;

    private String author;

    private String isbn;

    private String director;

    private String actor;

}
