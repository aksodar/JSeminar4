package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        hw.multiple(new ArrayDeque<>(Arrays.asList(5, 2)), new ArrayDeque<>(Arrays.asList(4)));
        // result [0,0,1]
        hw.sum(new ArrayDeque<>(Arrays.asList(5, -2)), new ArrayDeque<>(Arrays.asList(5)));
        // result [0,-2]
        System.out.println(hw.multiple(new ArrayDeque<>(Arrays.asList(5, 2)), new ArrayDeque<>(Arrays.asList(4))));
        System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5, -2)), new ArrayDeque<>(Arrays.asList(5))));
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("empty collection");
        }
        int multi;
        int i1 = 0;
        int i2 = 0;
        ArrayDeque<Integer> res = new ArrayDeque<>();

        while (!d1.isEmpty()) {
            i1 = i1 * 10 + d1.pollLast();
        }
        while (!d2.isEmpty()) {
            i2 = i2 * 10 + d2.pollLast();
        }

        multi = i1 * i2;

        while (multi / 10 > 0) {
            res.addLast(multi % 10);
            multi /= 10;
        }
        if (multi > 0) res.addLast(multi);
        return res;
    }


    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("empty collection");
        }
        Deque<Integer> result = new ArrayDeque<>();
        int sum = 0;
        if (d1.size() > 0 || d2.size() > 0) {
            int temp1 = -1 * d1.getLast();
            d1.pollLast();
            d1.addLast(temp1);
            int temp2 = -1 * d2.getLast();
            d2.pollLast();
            d2.addLast(temp2);

            while (!d1.isEmpty() || !d2.isEmpty()) {
                if (!d1.isEmpty()) {
                    sum = sum + d1.pollFirst();
                }
                if (!d2.isEmpty()) {
                    sum = sum + d2.pollFirst();
                }
                if (sum > 9) {
                    result.add(sum % 10);
                    sum = sum / 10;
                } else {
                    result.add(sum);
                    sum = 0;
                }
            }
            if (sum != 0) {
                result.add(sum);
            }
            int last = -1 * result.getLast();
            result.pollLast();
            result.addLast(last);
        }
        return result;
    }
}

