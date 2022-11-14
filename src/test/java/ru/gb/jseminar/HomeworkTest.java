package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class HomeworkTest {

    @Test
    void sumTest() {
        Deque<Integer> ExpectedList1 = new ArrayDeque<>(Arrays.asList(5, 6, -2));
        Deque<Integer> ExpectedList2 = new ArrayDeque<>(Arrays.asList(5, 0, 2));
        Deque<Integer> ExpectedSumList = new ArrayDeque<>(Arrays.asList(0, -6));

        Deque<Integer> ExpList1 = new ArrayDeque<>(Arrays.asList(5, 6, -2));
        Deque<Integer> ExpList2 = new ArrayDeque<>(Arrays.asList(5, 6, 2));
        Deque<Integer> ExpSumList = new ArrayDeque<>(Arrays.asList(0));

        Homework hw = new Homework();
        Deque<Integer> ActualSumList = new ArrayDeque<>(hw.sum(ExpectedList1, ExpectedList2));
        Assertions.assertIterableEquals(ExpectedSumList, ActualSumList);

        Deque<Integer> ActSumList = new ArrayDeque<>(hw.sum(ExpList1, ExpList2));
        Assertions.assertIterableEquals(ExpSumList, ActSumList);
    }

    @Test
    void multipleTest() {
        Deque<Integer> ExpectedList1 = new ArrayDeque<>(Arrays.asList(2, 3, 4, 5));
        Deque<Integer> ExpectedList2 = new ArrayDeque<>(Arrays.asList(1, 3, 2, 1));
        Deque<Integer> ExpectedSumList = new ArrayDeque<>(Arrays.asList(2, 9, 7, 6, 8, 6, 6));

        Deque<Integer> ExpList1 = new ArrayDeque<>(Arrays.asList(0));
        Deque<Integer> ExpList2 = new ArrayDeque<>(Arrays.asList(1, 3, 2, 1));
        Deque<Integer> ExpSumList = new ArrayDeque<>(Arrays.asList(0));

        Homework hw = new Homework();
        Deque<Integer> ActualSumList = new ArrayDeque<>(hw.multiple(ExpectedList1, ExpectedList2));
        Assertions.assertIterableEquals(ExpectedSumList, ActualSumList);

        Deque<Integer> ActSumList = new ArrayDeque<>(hw.multiple(ExpList1, ExpList2));
        Assertions.assertIterableEquals(ExpSumList, ActSumList);
    }
}
