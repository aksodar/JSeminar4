package ru.gb.jseminar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class HomeworkTest {
    @Test
    void multipleSuccessful(){
        Deque<Integer> d1= new ArrayDeque<>(Arrays.asList(5,2));
        Deque<Integer> d2= new ArrayDeque<>(Arrays.asList(4));
        Deque<Integer> expected = new ArrayDeque<>(Arrays.asList(0,0,1));
        Homework homework = new Homework();
        Deque<Integer> actual= homework.multiple(d1, d2);
        Assertions.assertEquals(expected, actual);

    }
}