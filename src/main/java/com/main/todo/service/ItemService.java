package com.main.todo.service;

import com.main.todo.domain.item.Book;
import com.main.todo.domain.item.Item;
import com.main.todo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Transactional //트랜잭션 커밋 시 플러시 할 때, 영속 상태에 있는 것의 변경 상태를 감지 후 update 시행 (dirty checking)
    public void update(Long itemId, Book book) {
        Item findItem = itemRepository.findOne(itemId); //영속 상태
        findItem.setPrice(book.getPrice());
        findItem.setName(book.getName());
        findItem.setStockQuantity(book.getStockQuantity());
    }


    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }


}
