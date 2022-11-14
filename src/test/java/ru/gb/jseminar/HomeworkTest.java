package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;



class HomeworkTest {
    @Test
    void multiple(){
        Deque<Integer> expectedDeque1 = new ArrayDeque<>(Arrays.asList(3,2));
        Deque<Integer> expectedDeque2 = new ArrayDeque<>(Arrays.asList(7,4));
        int expected = 1081;
        
        Homework hmw = new Homework();
        int actual = hmw.multiple(expectedDeque1, expectedDeque2);
        
        Assertions.assertEquals(expected, actual);;
    }


    @Test
    void sum(){
        Deque<Integer> expectedDeque1 = new ArrayDeque<>(Arrays.asList(3,2));
        Deque<Integer> expectedDeque2 = new ArrayDeque<>(Arrays.asList(7,-4));
        int expected = -24;
        
        Homework hmw = new Homework();
        int actual = hmw.multiple(expectedDeque1, expectedDeque2);
        
        Assertions.assertEquals(expected, actual);;
    }  
}
