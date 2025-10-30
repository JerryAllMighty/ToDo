package com.main.todo.domain;

import com.main.todo.domain.item.Item;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private int orderPrice;

    private int count;

    protected OrderItem(){

    }

    /**
     * 생성 메서드
     *
     * @param item
     * @param orderPrice
     * @param count
     * @return
     */
    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        item.removeStockQuantity(count);
        return orderItem;
    }

    /**
     * 주문 상품 취소
     */
    public void cancel() {
        getItem().addStockQuantity(count);
    }

    /**
     * 전체 주문상품 가격 조회
     * @return
     */
    public int getTotalPrice() {
        return orderPrice * count;
    }
}
