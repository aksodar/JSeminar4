package ru.gb.jseminar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import org.junit.jupiter.api.Test;




class HomeworkTest {
    
    @Test
    void multipleSuccessful (){
    
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(5,2));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(4));
        Deque<Integer>  expected = new ArrayDeque<>();
        expected.addFirst(1);
        expected.addFirst(0);
        expected.addFirst(0);

        Homework homework = new Homework();
        Deque<Integer> actual = homework.multiple(d1, d2);

        Assertions.assertEquals(expected, actual);
    }

    void sumSuccessful (){
    
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(5,-2));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5));
        Deque<Integer>  expected = Arrays.asList(0,-2);

        Homework homework = new Homework();
        Deque<Integer> actual = homework.sum(d1, d2);

        Assertions.assertEquals(expect, actual);
    }
    
}

