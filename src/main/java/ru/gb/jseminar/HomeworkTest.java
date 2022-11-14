package ru.gb.jseminar;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {

    @org.junit.jupiter.api.Test
    void multipleSucces() {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(5, 2));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(8));

        Deque<Integer> expect = new ArrayDeque<>(Arrays.asList(0, 0, 2));

        Homework hw = new Homework();
        Deque<Integer> actual = hw.multiple(d1, d2);

        Assertions.assertArrayEquals(expect.toArray(), actual.toArray());
    }


    @org.junit.jupiter.api.Test
    void sumSucess() {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(0, 2));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(0,-2));

        Deque<Integer> expect = new ArrayDeque<>(Arrays.asList(0));

        Homework hw = new Homework();
        Deque<Integer> actual = hw.sum(d1, d2);

        Assertions.assertArrayEquals(expect.toArray(), actual.toArray());
    }
}