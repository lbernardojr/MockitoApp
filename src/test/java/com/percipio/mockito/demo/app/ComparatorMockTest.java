/*
 * Copyright (c) 2022. DXC
 * Author: lbernardojr
 */

package com.percipio.mockito.demo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Comparator;
import org.junit.jupiter.api.Test;

public class ComparatorMockTest {

    @Test
    public void mockComparatorFirst(){

        Comparator<String> comparatorMock = mock(Comparator.class);

        System.out.println("toString() of Comparator: " + comparatorMock);
        System.out.println("getClass() of Comparator: " + comparatorMock.getClass());
        System.out.println("getClass().getSuperclass() of Comparator: " + comparatorMock.getClass().getSuperclass());
        System.out.println("comparatorMock instanceof Comparator: " + (comparatorMock instanceof Comparator));
    }

    @Test
    public void mockComparatorSecond(){

        Comparator<String> comparatorMock = mock(Comparator.class);

        //Alphabetical/lexicographical order compare
        when(comparatorMock.compare("Alice", "Bob")).thenReturn(1);
        when(comparatorMock.compare("Bob", "Charles")).thenReturn(1);
        when(comparatorMock.compare("Alice", "Charles")).thenReturn(1);

        when(comparatorMock.compare("Bob", "Alice")).thenReturn(-1);
        when(comparatorMock.compare("Charles", "Bob")).thenReturn(-1);
        when(comparatorMock.compare("Charles", "Alice")).thenReturn(-1);

        when(comparatorMock.compare("Alice", "Alice")).thenReturn(0);
        when(comparatorMock.compare("Bob", "Bob")).thenReturn(0);
        when(comparatorMock.compare("Charles", "Charles")).thenReturn(0);

        assertTrue(comparatorMock.compare("Alice", "Charles") > 0);
        assertTrue(comparatorMock.compare("Charles", "Bob") < 0);
        assertEquals(0, comparatorMock.compare("Bob", "Bob"));

    }

}
