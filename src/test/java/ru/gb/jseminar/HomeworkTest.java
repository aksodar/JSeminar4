package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


class HomeworkTest {

    @Test
    void multipleSuccessful() {

        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1, 3));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(1, 2));
        Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(1, 5, 6));

        Homework hw = new Homework();
        Deque<Integer> actual = hw.multiple(d1, d2);

        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void sumSuccessful() {

        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(5, -2));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5));
        Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(0, -2));

        Homework hw = new Homework();
        Deque<Integer> actual = hw.sum(d1, d2);

        Assertions.assertIterableEquals(expected, actual);
    }

}
