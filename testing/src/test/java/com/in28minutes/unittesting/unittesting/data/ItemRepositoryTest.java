package com.in28minutes.unittesting.unittesting.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.in28minutes.unittesting.unittesting.controller.HelloWorldController;
import com.in28minutes.unittesting.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {
    // this work the most with hibernate and stuff...
    @Autowired
    private ItemRepository repository;

    @Test
    public void testFindAll(){
        List<Item> items =  repository.findAll();
        assertEquals(3,items.size());
    }
}
