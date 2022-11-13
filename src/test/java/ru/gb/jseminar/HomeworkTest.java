package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {

    @org.junit.jupiter.api.Test
    void multipleText() {
        Deque<Integer> expectedList1 = new ArrayDeque<>(Arrays.asList(5,2));
        Deque<Integer>expectedList2 = new ArrayDeque<>(Arrays.asList(5,2));
        Deque<Integer>expected = new ArrayDeque<>(Arrays.asList(5,2,6));

        Homework homework = new Homework();
        Deque<Integer>actual = homework.multiple(expectedList1,expectedList2);

        Assertions.assertIterableEquals(expected,actual);
    }

    @Test
    void sum() {
        Deque<Integer> expectedList1 = new ArrayDeque<>(Arrays.asList(5,-5));
        Deque<Integer>expectedList2 = new ArrayDeque<>(Arrays.asList(5,2));
        Deque<Integer>expected = new ArrayDeque<>(Arrays.asList(0,-3));

        Homework homework = new Homework();
        Deque<Integer>actual = homework.sum(expectedList1,expectedList2);

        Assertions.assertIterableEquals(expected,actual);
    }
}