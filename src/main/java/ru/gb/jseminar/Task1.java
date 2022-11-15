package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.logging.Logger;

public class Task1 {

    //Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    // Сложите два числа и верните сумму в виде связанного списка.
    public static void main(String[] args) {
        Task1 t1 = new Task1();
        Logger log = Logger.getLogger(Task1.class.getName());
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(3, 2, 1));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(7, 4, 5));
        // result [1,0,6,6]
        log.info(String.valueOf(t1.sum(d1, d2)));

    }


    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        int intResult = 0;
        int temp = 0;
        while (d1.peekFirst() != null) {
            num1.append(d1.poll().toString());
        }
        while (d2.peekFirst() != null) {
            num2.append(d2.poll().toString());
        }
        intResult = Integer.parseInt(String.valueOf(num1)) + Integer.parseInt(String.valueOf(num2));
        System.out.println(intResult);
        while (intResult != 0) {
                temp = intResult % 10;
                intResult /= 10;
                result.addFirst(temp);
        }
        return result;
    }
}
