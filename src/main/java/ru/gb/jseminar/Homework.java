package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.logging.Logger;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Homework hw = new Homework();
        Logger log = Logger.getLogger(Homework.class.getName());
        log.info(String.valueOf(hw.multiple(new ArrayDeque<>(Arrays.asList(5, 2)), new ArrayDeque<>(Arrays.asList(4)))));
        log.info(String.valueOf(hw.sum(new ArrayDeque<>(Arrays.asList(5, -2)), new ArrayDeque<>(Arrays.asList(5)))));
    }

    // Умножьте два числа и верните произведение в виде связанного списка.

    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        int intResult = 0;
        int temp = 0;
        while (d1.peekFirst() != null) {
            num1.append(d1.pollLast().toString());
        }
        while (d2.peekFirst() != null) {
            num2.append(d2.pollLast().toString());
        }
        intResult = Integer.parseInt(String.valueOf(num1)) * Integer.parseInt(String.valueOf(num2));
        while (intResult != 0) {
            temp = intResult % 10;
            intResult /= 10;
            result.addLast(temp);
        }
        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        int intResult = 0;
        int temp = 0;
        while (d1.peekFirst() != null) {
            num1.append(d1.pollLast().toString());
        }
        while (d2.peekFirst() != null) {
            num2.append(d2.pollLast().toString());
        }
        intResult = Integer.parseInt(String.valueOf(num1)) + Integer.parseInt(String.valueOf(num2));
        while (intResult != 0) {
            temp = intResult % 10;
            intResult /= 10;
            result.addLast(temp);
        }
        return result;
    }
}