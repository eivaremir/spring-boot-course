package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class BusinessMockTest {
    BusinessImpl business = new BusinessImpl();
    SomeDataService dsMock = mock(SomeDataService.class);
    @Before
    public void before(){
        business.setDs(dsMock);
    }

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
