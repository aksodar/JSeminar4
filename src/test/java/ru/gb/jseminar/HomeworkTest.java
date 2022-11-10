package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {

    @Test
    void sumSuccessful() {
        ArrayDeque arr1 = new ArrayDeque<>(Arrays.asList(5,2));
        ArrayDeque arr2 = new ArrayDeque<>(Arrays.asList(4));
        LinkedList<Integer> expected = new LinkedList<>(Arrays.asList(9,2));

        Homework HW4 = new Homework();
        LinkedList<Integer> actual = new LinkedList<>(HW4.sum(arr1,arr2));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multipleSuccessful() {
        ArrayDeque arr1 = new ArrayDeque<>(Arrays.asList(5,2));
        ArrayDeque arr2 = new ArrayDeque<>(Arrays.asList(4));
        LinkedList<Integer> expected = new LinkedList<>(Arrays.asList(0,0,1));

        Homework HW4 = new Homework();
        LinkedList<Integer> actual = new LinkedList<>(HW4.multiple(arr1,arr2));

        Assertions.assertEquals(expected, actual);
    }
}