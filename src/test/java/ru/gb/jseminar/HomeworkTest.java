package ru.gb.jseminar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class HomeworkTest {

    @Test
    void multiple() {
        Deque<Integer> entryDeque1 = new ArrayDeque<>(Arrays.asList(2, 1));
        Deque<Integer> entryDeque2 = new ArrayDeque<>(Arrays.asList(2, 1));

        Homework hw = new Homework();
        Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(4, 4, 1));
        Deque<Integer> actualDeque = hw.multiple(entryDeque1, entryDeque2);

        Assertions.assertArrayEquals(expectedDeque.toArray(), actualDeque.toArray());
    }

    @Test
    void sum() {
        Deque<Integer> entryDeque3 = new ArrayDeque<>(Arrays.asList(2, 1));
        Deque<Integer> entryDeque4 = new ArrayDeque<>(Arrays.asList(3, 4));

        Homework hw = new Homework();
        Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(5, 5));
        Deque<Integer> actualDeque = hw.sum(entryDeque3, entryDeque4);

        Assertions.assertArrayEquals(expectedDeque.toArray(), actualDeque.toArray());
    }
}