package com.main.todo.controller;

import com.main.todo.domain.Order;
import com.main.todo.domain.OrderItem;
import com.main.todo.domain.OrderSearch;
import com.main.todo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderRepository orderRepository;

    @GetMapping("api/v1/orders")
    public List<Order> ordersV1() {
        List<Order> all = orderRepository.findAll(new OrderSearch());
//        for (Order order : all) {
//            order.getMember().getName();
//            order.getDelivery().getAddress();
//            List<OrderItem> orderItems = order.getOrderItems();
//            for (OrderItem orderItem : orderItems) {
//                orderItem.getItem().getName();
//
//            }
//
//        }
        return all;
    }
}
