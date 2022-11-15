package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HomeworkTest {

    @Test
    void multipleSuccessful() {
        ArrayDeque<Integer> expectedDeque1 = new ArrayDeque<>(Arrays.asList(5, 1));
        ArrayDeque<Integer> expectedDeque2 = new ArrayDeque<>(Arrays.asList(0, 1));
        ArrayDeque<Integer> expected = new ArrayDeque<>(Arrays.asList(0, 5, 1));

        Homework hw = new Homework();
        ArrayDeque<Integer> actual = (ArrayDeque<Integer>) hw.multiple(expectedDeque1, expectedDeque2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sumSuccessful() {
        ArrayDeque<Integer> expectedDeque1 = new ArrayDeque<>(Arrays.asList(0, -1));
        ArrayDeque<Integer> expectedDeque2 = new ArrayDeque<>(Arrays.asList(5));
        ArrayDeque<Integer> expected = new ArrayDeque<>(Arrays.asList(-5));

        Homework hw = new Homework();
        ArrayDeque<Integer> actual = (ArrayDeque<Integer>) hw.sum(expectedDeque1, expectedDeque2);

        Assertions.assertEquals(expected, actual);
    }
}
