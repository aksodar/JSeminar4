package ru.gb.jseminar;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class HomeworkTest {

    @Test
    void MultipleSuccessful() {
        Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(2, 1));
        Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(2, 1));

        Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(4, 4, 1));

        Deque<Integer> actualDeque = (new Homework()).multiple(inputDeque1, inputDeque2);

        Assertions.assertIterableEquals(expectedDeque, actualDeque);
    }
    @Test
    void MultipleSuccessful2() {
        Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(5, 2));
        Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(4));

        Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(0,0,1));

        Deque<Integer> actualDeque = (new Homework()).multiple(inputDeque1, inputDeque2);

        Assertions.assertIterableEquals(expectedDeque, actualDeque);
    }
    @Test
    void MultipleSuccessful3() {
        Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(2, 1, 2, 5, 6));
        Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(2, 1, 3, 5));

        Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(4, 4, 1, 6, 0, 4, 6,4,3));

        Deque<Integer> actualDeque = (new Homework()).multiple(inputDeque1, inputDeque2);

        Assertions.assertIterableEquals(expectedDeque, actualDeque);
    }
    @Test
    void MultipleSuccessful4() {
        Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(2,1));
        Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(2));

        Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(4,2));

        Deque<Integer> actualDeque = (new Homework()).multiple(inputDeque1, inputDeque2);

        Assertions.assertIterableEquals(expectedDeque, actualDeque);
    }
    @Test
    void MultipleSuccessful5() {
        Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(2, 1, 5, 3));
        Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(2, 1));

        Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(4, 4, 1, 2, 4));

        Deque<Integer> actualDeque = (new Homework()).multiple(inputDeque1, inputDeque2);

        Assertions.assertIterableEquals(expectedDeque, actualDeque);
    }
    @Test
    void sumSuccessful() {
        Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(2, -1));
        Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(4, 2));

        Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(2, 1));

        Deque<Integer> actualDeque = (new Homework()).sum(inputDeque1, inputDeque2);

        Assertions.assertIterableEquals(expectedDeque, actualDeque);
    }
    @Test
    void sumSuccessful2() {
        Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(1 ,2, -1));
        Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(4, -2));

        Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(5, 4, -1));

        Deque<Integer> actualDeque = (new Homework()).sum(inputDeque1, inputDeque2);

        Assertions.assertIterableEquals(expectedDeque, actualDeque);
    }
    @Test
    void sumSuccessful3() {
        Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(5, 1, 2, -1));
        Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(4, 2, 3, 5));

        Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(9,0,1,4));

        Deque<Integer> actualDeque = (new Homework()).sum(inputDeque1, inputDeque2);

        Assertions.assertIterableEquals(expectedDeque, actualDeque);
    }
    @Test
    void sumSuccessful4() {
        Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(2, -9));
        Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(1 ,4, 2));

        Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(9 ,4, 1));

        Deque<Integer> actualDeque = (new Homework()).sum(inputDeque1, inputDeque2);

        Assertions.assertIterableEquals(expectedDeque, actualDeque);
    }

}