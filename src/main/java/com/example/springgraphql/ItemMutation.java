package com.example.springgraphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemMutation implements GraphQLMutationResolver {

    @Autowired
    private ItemService itemService;

    public Item createItem(final String content) {
        return this.itemService.createItem(content);
    }
}
