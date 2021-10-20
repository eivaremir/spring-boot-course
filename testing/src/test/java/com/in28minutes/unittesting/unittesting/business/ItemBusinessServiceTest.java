package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import com.in28minutes.unittesting.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {


    @InjectMocks
    private ItemBusinessService business;

    @Mock
    ItemRepository repository ;

    @Test
    public void testUsingDataService_basic(){
        // here we test the business logic applied to an element
        when(repository.findAll()).thenReturn(
                Arrays.asList(new Item(2,"item2",100,100),new Item(3,"item2",100,100))
        );
        List<Item> items = business.retrieveAllItems();

        assertEquals(10000,items.get(0).getValue());
        assertEquals(10000,items.get(1).getValue());
    }
    /*
    @Test
    public void testUsingDataService_empty(){
        when(repository.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, business.calculateSumFromDs());
    }
    @Test
    public void testUsingDataService_one(){
        when(repository.retrieveAllData()).thenReturn(new int[]{1});
        assertEquals(1, business.calculateSumFromDs());
    }*/
}
