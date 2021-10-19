package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemBusinessService {
    public Item retrieveHardcodedItem() {
        return new Item(1,"ball",100,100);
    }
}
