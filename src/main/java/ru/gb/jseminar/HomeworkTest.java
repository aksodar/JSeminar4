package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class HomeworkTest {
    @Test
    void multipleSuccessfully() {

        Deque<Integer> actual = new Homework().multiple(new ArrayDeque<>(Arrays.asList(5, 2)),
                                                        new ArrayDeque<>(List.of(5,2)));
        Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(5, 2, 6));
        Assertions.assertIterableEquals(expected, actual);
    }
    @Test
    void sumSuccessfully() {
       Deque<Integer> actual = new Homework().sum(new ArrayDeque<>(Arrays.asList(5, -2)),
                                                  new ArrayDeque<>(List.of(5)));
        Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(0, -2));
        Assertions.assertIterableEquals(expected, actual);
    }
}