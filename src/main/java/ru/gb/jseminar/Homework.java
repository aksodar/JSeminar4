package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Homework hw = new Homework();
        System.out.println(hw.multiple(new ArrayDeque<>(Arrays.asList(5, 2)), new ArrayDeque<>(Arrays.asList(4))));
        // result [0,0,1]
        System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5, -2)), new ArrayDeque<>(Arrays.asList(5))));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) {
        String count1 = "";
        String count2 = "";
        while (d1.size() > 0 || d2.size() > 0) {
            if (d1.size() > 0) {
                count1 = count1 + d1.removeLast();
            }
            if (d2.size() > 0) {
                count2 = count2 + d2.removeLast();
            }
        }
        int count = Integer.parseInt(count1) * Integer.parseInt(count2);
        Deque<Integer> result = new ArrayDeque<>();
        if (count > 0) {
            while (count > 0) {
                result.addLast(count % 10);
                count = count / 10;
            }
        } else {
            while (count < 0) {
                result.addLast(count % 10);
                count = count / 10;
            }
        }
        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        String count1 = "";
        String count2 = "";
        while (d1.size() > 0 || d2.size() > 0) {
            if (d1.size() > 0) {
                count1 = count1 + d1.removeLast();
            }
            if (d2.size() > 0) {
                count2 = count2 + d2.removeLast();
            }
        }
        int count = Integer.parseInt(count1) + Integer.parseInt(count2);
        Deque<Integer> result = new ArrayDeque<>();
        if (count > 0) {
            while (count > 0) {
                result.addLast(count % 10);
                count = count / 10;
            }
        } else {
            while (count < 0) {
                result.addLast(count % 10);
                count = count / 10;
            }
        }
        return result;
    }
}

