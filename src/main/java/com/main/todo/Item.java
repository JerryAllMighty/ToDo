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
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

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
