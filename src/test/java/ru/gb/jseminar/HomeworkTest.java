package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HomeworkTest {

    @Test
    void multipleSuccessful() {
        // что-то исходное
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(5, 2));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(4));
        Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(0, 0, 1));
        // что-то делаем
        Homework homework = new Homework();
        Deque<Integer> actual = homework.multiple(d1, d2);
        // проверяем
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void sumSuccessful() {
        // что-то исходное
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(5, -2));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(4));
        Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(1, -2));
        // что-то делаем
        Homework homework = new Homework();
        Deque<Integer> actual = homework.sum(d1, d2);
        // проверяем
        Assertions.assertIterableEquals(expected, actual);
    }

}