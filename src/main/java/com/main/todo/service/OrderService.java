package com.main.todo.service;

import com.main.todo.domain.Delivery;
import com.main.todo.domain.Member;
import com.main.todo.domain.Order;
import com.main.todo.domain.OrderItem;
import com.main.todo.domain.item.Item;
import com.main.todo.repository.ItemRepository;
import com.main.todo.repository.MemberRepository;
import com.main.todo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final MemberRepository memberRepository;

    private final ItemRepository itemRepository;

    /**
     * 주문
     */
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.save(order);
        return order.getId();
    }

    /**
     * 취소
     */

    /**
     * 검색
     */
}
