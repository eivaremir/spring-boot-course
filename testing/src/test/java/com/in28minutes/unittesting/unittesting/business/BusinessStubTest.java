package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class DataServiceStub implements SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3};
    }
}

public class BusinessStubTest {
    @Test
    public void testUsingDataService_basic(){
        BusinessImpl business = new BusinessImpl();

        // UNIT TESTS SHOULD NOT BE DEPENDING ON ANYTHING OUTSIDE
        // IF SO, STH IS WRONG
        // LETS CREATE A STUB IMPLEMENTING THE INTERFACE
        business.setDs(new DataServiceStub());
        int s = business.calculateSumFromDs();
        int expectedResult = 6;

        assertEquals(expectedResult,s);
    }
}
