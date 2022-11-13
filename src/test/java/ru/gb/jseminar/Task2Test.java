package ru.gb.jseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void validateText() {
        Deque<String> expectedList = new ArrayDeque<>(Arrays.asList("{","[","(",")","]","}"));
        boolean expected=true;

        Task2 task2 = new Task2();
        boolean actual = task2.validate(expectedList);

        Assertions.assertEquals(actual,expected);

    }
}