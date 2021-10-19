package com.in28minutes.unittesting.unittesting.controller;

import com.in28minutes.unittesting.unittesting.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1,"ball",100,100);
    }
}
