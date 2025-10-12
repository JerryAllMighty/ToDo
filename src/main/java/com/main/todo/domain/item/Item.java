package com.main.todo.domain.item;

import com.main.todo.DeliveryType;
import com.main.todo.domain.Category;
import com.main.todo.domain.DeliveryStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    //TODO : int 형으로 선언이 뭐가 다른지
    private Integer price;

    private Integer stockQuantity;

    @ManyToMany(mappedBy = "itemList")
    private List<Category> categoryList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

}
