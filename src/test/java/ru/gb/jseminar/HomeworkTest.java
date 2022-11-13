package ru.gb.jseminar;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HomeworkTest {    
    
    @Test
    void getSucsessfullSum() {
        //что-то исходное               
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(0,1,7));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(1,-3));
        Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(9,7,6));
        // что-то делаем
        Homework hm = new Homework();
        Deque<Integer> actual = hm.sum(d1,d2);
        //проверяем
        Assertions.assertIterableEquals(expected, actual);

    }
    @Test
    void getSucsessfullmultiple() {
        //что-то исходное               
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(5,2,9));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(6,2));
        Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(0,5,0,4,2));
        // что-то делаем
        Homework hm = new Homework();
        Deque<Integer> actual = hm.multiple(d1,d2);
        //проверяем
        Assertions.assertIterableEquals(expected, actual);
    }
 

}