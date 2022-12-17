package ru.gb.jseminar;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Homework hw = new Homework();
        System.out.println(hw.multiple(new ArrayDeque<>(Arrays.asList(3, 4, 1, 7, 9)), new ArrayDeque<>(Arrays.asList(9, 8, 1, 4))));
        System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5, 9, 3, -3)), new ArrayDeque<>(Arrays.asList(6, 8, 2, -8))));
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> d4 = new ArrayDeque<>();
        Deque<Integer> d3 = new ArrayDeque<>();
        Deque<Integer> result = new ArrayDeque<>();
        Deque<Integer> d1Temp = new ArrayDeque<>(d1);
        int temp = 0;
        int a = d2.size();
        for (int i = 0; i < a; i++) {
            for (int k = 0; k < i; k++) {
                d3.addFirst(0);
            }
            int b = d1Temp.size();
            for (int j = 0; j < b; j++) {
                if ((d2.getFirst() * d1Temp.getFirst() + temp) < 10) {
                    d3.addFirst(d2.getFirst() * d1Temp.pollFirst() + temp);
                    temp = 0;
                } else {
                    d3.addFirst((d2.getFirst() * d1Temp.getFirst() + temp) % 10);
                    temp = (d2.getFirst() * d1Temp.pollFirst() + temp) / 10;
                }
            }
            if (temp > 0) {
                d3.addFirst(temp);
                temp = 0;
            }
            d1Temp.addAll(d1);
            if (d2.size() > 0) {
                d2.removeFirst();
            }
            while (d4.size() < d3.size()) {
                d4.addFirst(0);
            }
            int temp2 = 0;
            while (d3.size() > 0 && d4.size() > 0) {
                if (d3.getLast() + d4.getLast() + temp2 < 10) {
                    result.addFirst(d3.getLast() + d4.getLast() + temp2);
                    temp2 = 0;
                } else {
                    result.addFirst((d3.getLast() + d4.getLast() + temp2) % 10);
                    temp2 = 1;
                }
                d3.pollLast();
                d4.pollLast();
            }
            if (temp2 != 0) {
                result.addFirst(temp2);
            }
            d4 = result;
        }
        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными

    // Решение для двух отрицательных чисел
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        int temp = 0;
        Deque<Integer> result = new ArrayDeque<>();
        Deque<Integer> d1Temp = new ArrayDeque<>();
        Deque<Integer> d2Temp = new ArrayDeque<>();
        if (d1.getLast() < 0 && d2.getLast() < 0) {
            d1.addLast(d1.getLast() - d1.pollLast() * 2);
            d2.addLast(d2.getLast() - d2.pollLast() * 2);

            while (d1.size() > 0 && d2.size() > 0) {
                if (d1.getFirst() + d2.getFirst() + temp < 10) {
                    result.addLast(d1.getFirst() + d2.getFirst() + temp);

                    temp = 0;
                } else {
                    result.addLast((d1.getFirst() + d2.getFirst() + temp) % 10);
                    temp = 1;

                }
                d1.pollFirst();
                d2.pollFirst();

            }
            if (temp != 0) {
                result.addLast(temp);
            }
            result.addLast(result.getLast() - result.pollLast() * 2);
        }
        return result;
    }
}