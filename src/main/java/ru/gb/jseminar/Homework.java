package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.logging.Logger;

public class Homework {

    // Даны два Deque представляющие два целых числа. Цифры хранятся в обратном
    // порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Homework hw = new Homework();
        Logger log = Logger.getLogger(Homework.class.getName());
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(5, -2));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5));
        Deque<Integer> mult = hw.multiple(d1, d2);
        Deque<Integer> sum = hw.sum(d1, d2);
        log.info("\nDeque d1:\t" + d1.toString() + "\nDeque d2:\t" + d2.toString() + "\nMult d1 * d2:\t"
                + mult.toString() + "\nSum d1 + d2:\t"
                + sum.toString());
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> deque1, Deque<Integer> deque2) {
        Deque<Integer> d1 = new ArrayDeque<>(deque1);
        Deque<Integer> d2 = new ArrayDeque<>(deque2);
        String s1 = "";
        String s2 = "";
        String mult = "";
        int sign = 1;
        Deque<Integer> result = new ArrayDeque<Integer>();
        while (!d1.isEmpty()) {
            s1 += d1.pollLast();
        }
        while (!d2.isEmpty()) {
            s2 += d2.pollLast();
        }
        mult += Integer.parseInt(s1) * Integer.parseInt(s2);
        for (char c : mult.toCharArray()) {
            if (c == '-') {
                sign = -1;
            } else {
                result.addFirst(Integer.parseInt(String.valueOf(c)) * sign);
                sign = 1;
            }
        }
        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два
    // числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> deque1, Deque<Integer> deque2) {
        Deque<Integer> d1 = new ArrayDeque<>(deque1);
        Deque<Integer> d2 = new ArrayDeque<>(deque2);
        String s1 = "";
        String s2 = "";
        String sum = "";
        int sign = 1;
        Deque<Integer> result = new ArrayDeque<Integer>();
        while (!d1.isEmpty()) {
            s1 += d1.pollLast();
        }
        while (!d2.isEmpty()) {
            s2 += d2.pollLast();
        }
        sum += Integer.parseInt(s1) + Integer.parseInt(s2);
        for (char c : sum.toCharArray()) {
            if (c == '-') {
                sign = -1;
            } else {
                result.addFirst(Integer.parseInt(String.valueOf(c)) * sign);
                sign = 1;
            }
        }
        return result;
    }
}
