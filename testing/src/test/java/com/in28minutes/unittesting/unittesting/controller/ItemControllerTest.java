package com.in28minutes.unittesting.unittesting.controller;

import com.in28minutes.unittesting.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@WebMvcTest(value= ItemController.class)
public class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public void dummyitem_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON );
        // call "/hello-world"
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                //.andExpect(content().string("{\"id\":1,\"name\":\"ball\",\"price\":100,\"qty\":100}")) // this must be exact char by char
                .andExpect(content().json("{\"id\":  1,\"name\":   \"ball\",\"price\":100,\"qty\":100}")) // this not at all
                .andExpect(content().json("{\"id\":  1,\"price\":100,\"qty\":100}")) // this still succeeds
                .andReturn();

    }

    @Test
    public void itemFromBusinessService_basic() throws Exception {

        // this make the UT independendent of the service
        when(businessService.retrieveHardcodedItem()).thenReturn(
                new Item(1,"ball",100,100)
        );
        /*
        THIS FAILS BC THE BUSINESS SERVICE IS NOT LOADED BC ITS AN UNIT TEST
        AS WE ONLY WANT TO TEST THE LOGIC AND NOT THE SERVICE, WE USE MOCKBEAN
         */
        RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service").accept(MediaType.APPLICATION_JSON );
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":  1,\"price\":100,\"qty\":100}")) // this still succeeds
                .andReturn();
    }
    @Test
    public void retrieveAllItems_basic() throws Exception {

        // this make the UT independendent of the service
        when(businessService.retrieveAllItems()).thenReturn(
                Arrays.asList(new Item(2,"item2",100,100),new Item(3,"item2",100,100))
        );

        RequestBuilder request = MockMvcRequestBuilders.get("/all-items-from-database").accept(MediaType.APPLICATION_JSON );
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:2,price:100,qty:100},{id:3,price:100,qty:100}]")) // this still succeeds
                .andReturn();
    }
}
