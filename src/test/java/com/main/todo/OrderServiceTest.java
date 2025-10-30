package com.main.todo;

import com.main.todo.domain.Address;
import com.main.todo.domain.Member;
import com.main.todo.domain.Order;
import com.main.todo.domain.OrderStatus;
import com.main.todo.domain.item.Book;
import com.main.todo.exception.NotEnoughStockException;
import com.main.todo.repository.OrderRepository;
import com.main.todo.service.OrderService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.util.AssertionErrors.assertEquals;


@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired
    private EntityManager em;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void 상품주문() {
        //given
        Member member = createMember();
        Book book = createBook();
        int orderCount = 2;

        //when
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        //then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals("상품 주문시 상태는 ORDER", OrderStatus.ORDER, getOrder.getStatus());
        assertEquals("상품 주문시 종류 수가 정확", 1, getOrder.getOrderItemList().size());
        assertEquals("상품 주문시 가격은 가격 * 수량", 10000 * orderCount, getOrder.getTotalPrice());
        assertEquals("상품 주문시 주문 수량만큼 재고가 줄어야한다", 8, book.getStockQuantity());
    }

    private Member createMember() {
        Member member = new Member();
        member.setName("Kim");
        member.setAddress(new Address("서울", "river side", "123-123"));
        em.persist(member);
        return member;
    }

    private Book createBook() {
        Book book = new Book();
        book.setName("시골 JPA");
        book.setPrice(10000);
        book.setStockQuantity(10);
        em.persist(book);
        return book;
    }

    @Test
    public void 주문취소() {
        //given
        Member member = createMember();
        Book book = createBook();
        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        //when
        orderService.cancelOrder(orderId);

        //then
        Order getOrder = orderRepository.findOne(orderId);
        assertEquals("주문 취소시 상태는 CANCEL", OrderStatus.CANCEL, getOrder.getStatus());
        assertEquals("주문 취소된 상품은 그만큼 재고가 증가해야한다.", 10, book.getStockQuantity());

    }

    @Test
    public void 재고수량초과() {
        //given
        Member member = createMember();
        Book book = createBook();
        int orderCount = 1;

        //when
        orderService.order(member.getId(), book.getId(), orderCount);

        //then
        Assertions.assertThrows(NotEnoughStockException.class, () -> {
            throw new NotEnoughStockException("Need More Stock");
        });
    }

}