package ru.gb.jseminar;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {

    @org.junit.jupiter.api.Test
    void multiplyTest() {
        Homework hw = new Homework();

        Deque<Integer> incomed1 = new ArrayDeque<>(Arrays.asList(8,6));
        Deque<Integer> incomed2 = new ArrayDeque<>(Arrays.asList(1,1,-1));

        LinkedList <Integer> expectedList = new LinkedList<>(Arrays.asList(-7, 5,4,8));

        LinkedList <Integer> actual = hw.multiply(incomed1, incomed2);

        Assertions.assertEquals(expectedList, actual);
    }

    @Test
    void sumTest() {
        Homework hw = new Homework();

        Deque<Integer> incomed3 = new ArrayDeque<>(Arrays.asList(8,6, -4));
        Deque<Integer> incomed4 = new ArrayDeque<>(Arrays.asList(1,1,-1));

        LinkedList <Integer> expectedList1 = new LinkedList<>(Arrays.asList(-5, 7,9));

        LinkedList <Integer> actual1 = hw.sum(incomed3, incomed4);

        Assertions.assertEquals(expectedList1, actual1);


        Deque<Integer> incomed5 = new ArrayDeque<>(Arrays.asList(8,6, 4));
        Deque<Integer> incomed6 = new ArrayDeque<>(Arrays.asList(1,1,-1));

        LinkedList <Integer> expectedList2 = new LinkedList<>(Arrays.asList(3, 5,7));

        LinkedList <Integer> actual2 = hw.sum(incomed5, incomed6);

        Assertions.assertEquals(expectedList2, actual2);


        Deque<Integer> incomed7 = new ArrayDeque<>(Arrays.asList(8,6));
        Deque<Integer> incomed8 = new ArrayDeque<>(Arrays.asList(1,1,-1));

        LinkedList <Integer> expectedList3 = new LinkedList<>(Arrays.asList(-4, 3));

        LinkedList <Integer> actual3 = hw.sum(incomed7, incomed8);

        Assertions.assertEquals(expectedList3, actual3);
    }
}