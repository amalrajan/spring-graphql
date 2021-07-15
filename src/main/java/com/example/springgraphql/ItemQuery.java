package com.example.springgraphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ItemQuery implements GraphQLQueryResolver {

    @Autowired
    private ItemService itemService;

    public List<Item> getItems() {
        return this.itemService.getAllItems();
    }

    public Optional<Item> getItem(final int id) {
        return this.itemService.getItem(id);
    }
}