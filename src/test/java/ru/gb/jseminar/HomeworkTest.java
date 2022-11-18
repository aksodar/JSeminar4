package ru.gb.jseminar;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Deque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class HomeworkTest extends Homework{
    @Test
    void sumTest(){
        //Исходные значения
        //
        LinkedList<Integer> expectedList = new LinkedList<>();
        expectedList.add(0);
        expectedList.add(3);
        Deque<Integer> testingDeque1 = new ArrayDeque<Integer>();
        testingDeque1.addFirst(2);
        testingDeque1.addFirst(5);
        Deque<Integer> testingDeque2 = new ArrayDeque<>();
        testingDeque2.addFirst(5);


        //assertion
        Assertions.assertEquals(expectedList, sum(testingDeque1, testingDeque2));
    }

    @Test
    void mulTest(){
        //Исходные значения
        LinkedList<Integer> expectedList = new LinkedList<>();
        expectedList.add(5);
        expectedList.add(2);
        expectedList.add(1);
        Deque<Integer> testingDeque1 = new ArrayDeque<Integer>();
        testingDeque1.addFirst(2);
        testingDeque1.addFirst(5);
        Deque<Integer> testingDeque2 = new ArrayDeque<Integer>();
        testingDeque2.addFirst(5);

        //assertion
        Assertions.assertEquals(multiple(testingDeque1, testingDeque2), expectedList);
    }
}
