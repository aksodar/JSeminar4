package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class HomeworkTest {

    @Test
    void getNumberSuccessfully() {
        int expected = 25;

        int actual = new Homework().getNumber(new ArrayDeque<>(Arrays.asList(5,2)));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void resultDequeSuccessfully() {
        Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(0, 0, 1));

        Deque<Integer> actual = new Homework().resultDeque(100);

        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void multipleSuccessfully() {
        Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(0, 0, 1));

        Deque<Integer> actual = new Homework().multiple(new ArrayDeque<>(Arrays.asList(5, 2)),
                new ArrayDeque<>(List.of(4)));

        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void sumSuccessfully() {
        Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(0, -2));

        Deque<Integer> actual = new Homework().sum(new ArrayDeque<>(Arrays.asList(5, -2)),
                new ArrayDeque<>(List.of(5)));

        Assertions.assertIterableEquals(expected, actual);
    }
}