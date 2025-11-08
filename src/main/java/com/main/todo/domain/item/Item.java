package com.main.todo.domain.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.main.todo.DeliveryType;
import com.main.todo.domain.Category;
import com.main.todo.domain.DeliveryStatus;
import com.main.todo.exception.NotEnoughStockException;
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
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private Integer price;

    private Integer stockQuantity;

    @ManyToMany(mappedBy = "itemList")
    private List<Category> categoryList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    /**
     * 재고 증가
     *
     * @param stockQuantity
     */
    public void addStockQuantity(int stockQuantity) {
        this.stockQuantity += stockQuantity;

    }

    /**
     * 재고 감소
     */
    public void removeStockQuantity(int stockQuantity) {
        int leftStockQuantity = this.stockQuantity - stockQuantity;
        if (leftStockQuantity < 0) {
            throw new NotEnoughStockException("Need More Stock");
        }
        this.stockQuantity = leftStockQuantity;

    }

}
