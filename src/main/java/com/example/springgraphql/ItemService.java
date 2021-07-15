package com.example.springgraphql;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(final ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public Item createItem(final String content) {
        final Item item = new Item();
        item.setContent(content);

        return this.itemRepository.save(item);
    }

    @Transactional(readOnly = true)
    public List<Item> getAllItems() {
        return this.itemRepository.findAll().stream().collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Item> getItem(final int id) {
        return this.itemRepository.findById(id);
    }

    @Transactional
    public void deleteItem(final int id) {
        this.itemRepository.deleteById(id);
    }

    @Transactional
    public Item updateItem(final int id, final String content) {
        Item itemToUpdate = this.itemRepository.getOne(id);
        itemToUpdate.setContent(content);
        return this.itemRepository.save(itemToUpdate);
    }
}