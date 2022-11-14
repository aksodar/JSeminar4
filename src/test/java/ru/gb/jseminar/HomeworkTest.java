package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HomeworkTest {
    @Test
    void multipleSuccessfull() {
        Deque<Integer> expectedList1 = new ArrayDeque<>(Arrays.asList(3, 0, 5, -2));
        Deque<Integer> expectedList2 = new ArrayDeque<>(Arrays.asList(4, 5, 6, 1));
        Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(2, 6, 9, 9, 3, 1, -4));

        Homework hw = new Homework();
        Deque<Integer> actual = hw.multiple(expectedList1, expectedList2);

        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void sumSuccessfull() {
        Deque<Integer> expectedList1 = new ArrayDeque<>(Arrays.asList(9, 7, 0, 5, -2));
        Deque<Integer> expectedList2 = new ArrayDeque<>(Arrays.asList(7, 1, 0, -5));
        Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(6, 9, 0, 0, -3));

        Homework hw = new Homework();
        Deque<Integer> actual = hw.sum(expectedList1, expectedList2);

        Assertions.assertIterableEquals(expected, actual);
    }
}
