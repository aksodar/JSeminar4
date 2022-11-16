package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class HomeworkTest {
    Homework hw = new Homework();
    Deque<Integer> actual;
    Deque<Integer> expected;

    @Test
    void mul() {
        //Test 1
        actual = hw.mul(new ArrayDeque<>(Arrays.asList(5, 2)), new ArrayDeque<>(Arrays.asList(4)));
        expected = new ArrayDeque<>(Arrays.asList(0,0,1));
        Assertions.assertIterableEquals(expected,actual);
        //Test 2
        actual = hw.mul(new ArrayDeque<>(Arrays.asList(5, 2,1)), new ArrayDeque<>(Arrays.asList(4)));
        expected = new ArrayDeque<>(Arrays.asList(0,0,5));
        Assertions.assertIterableEquals(expected,actual);
        //Test 3
        actual = hw.mul(new ArrayDeque<>(Arrays.asList(5)), new ArrayDeque<>(Arrays.asList(0,4)));
        expected = new ArrayDeque<>(Arrays.asList(0,0,2));
        Assertions.assertIterableEquals(expected,actual);
    }


    @Test
    void sum() {
        //Test 1
        actual = hw.sum(new ArrayDeque<>(Arrays.asList(5)), new ArrayDeque<>(Arrays.asList(5)));
        expected = new ArrayDeque<>(Arrays.asList(0,1));
        Assertions.assertIterableEquals(expected,actual);
        //Test 2
        actual = hw.sum(new ArrayDeque<>(Arrays.asList(9,9)), new ArrayDeque<>(Arrays.asList(1)));
        expected = new ArrayDeque<>(Arrays.asList(0,0,1));
        Assertions.assertIterableEquals(expected,actual);
        //Test 3
        actual = hw.sum(new ArrayDeque<>(Arrays.asList(0,-1)), new ArrayDeque<>(Arrays.asList(1)));
        expected = new ArrayDeque<>(Arrays.asList(-9));
        Assertions.assertIterableEquals(expected,actual);
    }
}