package com.percipio.mockito.demo.app;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArrayListMockTest {

    /**
     * Mocking Objects with the Static mock() Method
     */
    @Test
    public void mockArrayListFirst(){

        ArrayList someArrayList = mock(ArrayList.class);

        System.out.println("toString() of mock: " + someArrayList);
        System.out.println("getClass() of mock: " + someArrayList.getClass());
        System.out.println("getClass().getSuperclass() of mock: " + someArrayList.getClass().getSuperclass());

        System.out.println("someArrayList instanceof ArrayList: " + (someArrayList instanceof ArrayList));
        System.out.println("someArrayList instanceof List: " + (someArrayList instanceof List));
        System.out.println("someArrayList instanceof Collection: " + (someArrayList instanceof Collection));
        System.out.println("someArrayList instanceof Iterable: " + (someArrayList instanceof Iterable));
        System.out.println("someArrayList instanceof Object: " + (someArrayList instanceof Object));

    }

    /**
     * Stubbing Methods Using when().thenReturn()
     */
//  The object that we're mocking is not the object under test,
//  rather it is some object which the object under test relies on or depends on
    @Test
    public void mockArrayListSecond(){
        //Mockito
        ArrayList someArrayList = mock(ArrayList.class);
        // stub methods
        when(someArrayList.isEmpty()).thenReturn(true);
        when(someArrayList.size()).thenReturn(23);
        when(someArrayList.toArray()).thenReturn(new Object[]{1,2,3});

        //Junit: We make use of the asserts True/Equals/ArrayEquals
        // to verify the return values from the stub methods.
        assertTrue(someArrayList.isEmpty());
        assertEquals(23, someArrayList.size());
        assertArrayEquals(new Object[]{1,2,3}, someArrayList.toArray());

    }

    /**
     * Using Assertions in Test Cases
     */
    @Test
    public void mockArrayListThird(){

        ArrayList someArrayList = mock(ArrayList.class);

        when(someArrayList.isEmpty()).thenReturn(true);
        when(someArrayList.size()).thenReturn(23);
        when(someArrayList.toArray()).thenReturn(new Object[]{1,2,3});

        assertFalse(someArrayList.isEmpty());
        assertEquals(25, someArrayList.size());
        assertArrayEquals(new Object[]{1,2,4}, someArrayList.toArray());

    }

    /**
     * Stubbing Methods with Specific Input Arguments
     */
    @Test
    public void mockArrayListFourth(){

        ArrayList someArrayList = mock(ArrayList.class);

        when(someArrayList.contains("Alice")).thenReturn(true);
        when(someArrayList.contains("Bob")).thenReturn(false);

        assertTrue(someArrayList.contains("Alice"));
        assertFalse(someArrayList.contains("Bob"));
//        assertTrue(someArrayList.contains("Charles"));

        /************************************************/

        when(someArrayList.get(0)).thenReturn("Alice");
        when(someArrayList.get(1)).thenReturn("Bob");
        when(someArrayList.get(2)).thenReturn("Charles");

        assertEquals("Alice", someArrayList.get(0));
        assertEquals("Bob", someArrayList.get(1));
        assertEquals("Charles", someArrayList.get(2));

        /************************************************/

        when(someArrayList.indexOf("Alice")).thenReturn(100);
        when(someArrayList.indexOf("Bob")).thenReturn(101);
        when(someArrayList.indexOf("Charles")).thenReturn(102);

        assertEquals(100, someArrayList.indexOf("Alice"));
        assertEquals(101, someArrayList.indexOf("Bob"));
        assertEquals(102, someArrayList.indexOf("Charles"));

        /************************************************/

        //subList takes in a pair of index values and returns the subList
        when(someArrayList.subList(100, 103)).thenReturn(Arrays.asList("Alice", "Bob", "Charles"));
        when(someArrayList.subList(1000, 1003)).thenReturn(Arrays.asList("Xavier", "Yasmin", "Zoe"));
        //assertLinesMatch used in order to compare two iterable objects
        //The comparison are going to be performed element wise.
        assertLinesMatch(Arrays.asList("Alice", "Bob", "Charles"), someArrayList.subList(100, 103));
        assertLinesMatch(Arrays.asList("Xavier", "Yasmin", "Zoe"), someArrayList.subList(1000, 1003));

//        assertLinesMatch(Arrays.asList("alice", "Bob", "Charles"), someArrayList.subList(100, 103));
    }


    /**
     * Mocking interface
     */
    @Test
    public void mockArrayListFifth(){

    }
}
