package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {

    @Test
    void multipleSuccessful() {
        Homework homework = new Homework();
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1,2));
        Deque<Integer> d2 = new ArrayDeque<>((Arrays.asList(4)));
        Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(4,8));

        Deque<Integer> actual = homework.multiple(d1, d2);

        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    void sum() {
        Homework homework = new Homework();
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1,2));
        Deque<Integer> d2 = new ArrayDeque<>((Arrays.asList(4)));
        Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(4,8));

        Deque<Integer> actual = homework.multiple(d1, d2);

        Assertions.assertIterableEquals(expected, actual);
    }
}