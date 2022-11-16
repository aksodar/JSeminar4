package ru.gb.jseminar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class HomeworkTest {

    @Test
    void multiple() {
        Homework homework = new Homework();
        Deque<Integer> finput = new ArrayDeque<>(Arrays.asList(1,2));
        Deque<Integer> sinput = new ArrayDeque<>((Arrays.asList(2,4)));
        Deque<Integer> mnum = new ArrayDeque<>(Arrays.asList(2,8,8));

        Deque<Integer> cur = homework.multiple(finput, sinput);

        Assertions.assertEquals(mnum, cur);
    }

    @Test
    void sum() {
        Homework homework = new Homework();
        Deque<Integer> finput = new ArrayDeque<>(Arrays.asList(1,2));
        Deque<Integer> sinput = new ArrayDeque<>((Arrays.asList(2,4)));
        Deque<Integer> sum = new ArrayDeque<>(Arrays.asList(3,6));

        Deque<Integer> cur = homework.sum(finput, sinput);

        Assertions.assertEquals(sum, cur);
    }
}