package com.in28minutes.unittesting.unittesting.business;

import org.junit.Test;

import static org.junit.Assert.*;

public class BusinessTest {
    @Test
    public void test_basic(){
        BusinessImpl business = new BusinessImpl();
        int s = business.calculateSum(new int[]{1,2,3});
        int expectedResult = 6;

        assertEquals(expectedResult,s);
    }
    @Test
    public void test_empty(){
        BusinessImpl business = new BusinessImpl();
        int s = business.calculateSum(new int[]{});
        int expectedResult = 0;

        assertEquals(expectedResult,s);
    }
    @Test
    public void test_one(){
        BusinessImpl business = new BusinessImpl();
        int s = business.calculateSum(new int[]{1});
        int expectedResult = 1;

        assertEquals(expectedResult,s);
    }
}
