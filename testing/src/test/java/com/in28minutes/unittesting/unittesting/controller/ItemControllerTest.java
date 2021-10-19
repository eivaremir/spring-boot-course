package com.in28minutes.unittesting.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@WebMvcTest(value= ItemController.class)
public class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;
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
}
