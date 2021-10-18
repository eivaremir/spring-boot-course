package com.in28minutes.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class ListMockTest {
    List<String> mock = mock(List.class);

    @Test
    public void size_basic(){
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }

    @Test
    public void returnDifferentValues(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }
    @Test
    public void returnWithParams(){
        when(mock.get(0)).thenReturn("a string");
        assertEquals("a string",mock.get(0));
        assertEquals(null,mock.get(1));
    }
    @Test
    public void returnWithGenericParams(){
        when(mock.get(anyInt())).thenReturn("a string");
        assertEquals("a string",mock.get(0));
        assertEquals("a string",mock.get(1));
    }
    @Test
    public void verificationBasics(){
        String value = mock.get(0);
        String value2 = mock.get(1);
        //verify if the get method is being called
        verify(mock).get(0);


        // verify if the method was called once
        verify(mock,times(2)).get(anyInt());

        verify(mock,atLeast(1)).get(anyInt());

        verify(mock,never()).get(2);
    }
}
