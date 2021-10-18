package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.Before;
//import org.junit.Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BusinessMockTest {


    @InjectMocks
    BusinessImpl business;

    @Mock
    SomeDataService dsMock ;

    @Test
    public void testUsingDataService_basic(){
        when(dsMock.retrieveAllData()).thenReturn(new int[]{1,2,3});
        assertEquals(6, business.calculateSumFromDs());
    }
    @Test
    public void testUsingDataService_empty(){
        when(dsMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, business.calculateSumFromDs());
    }
    @Test
    public void testUsingDataService_one(){
        when(dsMock.retrieveAllData()).thenReturn(new int[]{1});
        assertEquals(1, business.calculateSumFromDs());
    }
}
