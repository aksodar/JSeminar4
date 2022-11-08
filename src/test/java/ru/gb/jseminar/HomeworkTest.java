package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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

        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}