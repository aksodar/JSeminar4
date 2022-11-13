package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class HomeworkTest {

    @Test
    void MultipleSuccessful() {
        // что-то исходное
        Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(2, 1));
        Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(2, 1));

        Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(4, 4, 1));

        // что-то делаем
        Deque<Integer> actualDeque = (new ru.gb.jseminar.Homework()).multiple(inputDeque1, inputDeque2);

        // проверяем
        Assertions.assertIterableEquals(expectedDeque, actualDeque);
    }

    @Test
    void sumSuccessful() {
        // что-то исходное
        Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(2, -1));
        Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(4, 2));

        Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(2, 1));

        // что-то делаем
        Deque<Integer> actualDeque = (new ru.gb.jseminar.Homework()).sum(inputDeque1, inputDeque2);

        // проверяем
        Assertions.assertIterableEquals(expectedDeque, actualDeque);
    }


}