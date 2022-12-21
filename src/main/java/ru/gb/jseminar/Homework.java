package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    // Даны два Deque представляющие два целых числа. Цифры хранятся в обратном
    // порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        System.out.println("Произведение: "
                + hw.multiple(new ArrayDeque<>(Arrays.asList(5, 5)), new ArrayDeque<>(Arrays.asList(5, 3))));
        // result [0,0,1]
        System.out.println("Разница: "
                + hw.difference(new ArrayDeque<>(Arrays.asList( 3,2,1)), new ArrayDeque<>(Arrays.asList(5, 1))));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("Входные данные не заданы");
        }
        Deque<Integer> result = new ArrayDeque<>(0);
        Deque<Integer> line = new ArrayDeque<>(result);
        int multiplier;
        int mult = 1;
        int rank = 0;
        int count = 0;

        while (!d2.isEmpty()) {
            Deque<Integer> tmpDeque = new ArrayDeque<>(d1);
            multiplier = d2.poll();
            while (!tmpDeque.isEmpty()) {
                mult = tmpDeque.poll() * multiplier + rank;
                rank = 0;
                if (mult >= 10) {
                    rank = mult / 10;
                    mult = mult % 10;
                }
                line.offer(mult);
            }
            if (rank != 0) {
                line.offer(rank);

            }
            rank = 0;
            for (int index = 0; index < count; index++) {
                line.addFirst(0);
            }
            count++;

            Homework plus = new Homework();
            result = plus.sum(line, result);

        }

        return result;
    }

    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("Входные данные не заданы");
        }
        Deque<Integer> result = new ArrayDeque<>();
        int digit = 0;
        while (d1.size() > 0 || d2.size() > 0) {
            int sum = digit;
            digit = 0;
            if (d1.size() > 0) {
                sum += d1.pollFirst();
            }
            if (d2.size() > 0) {
                sum += d2.pollFirst();
            }
            if (sum >= 10) {
                sum -= 10;
                digit = 1;
            }

            result.offer(sum);
        }
        if (digit != 0) {
            result.offer(digit);
        }

        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два
    // числа должны быть отрицательными

    //вычитание второго числа из первого
    public Deque<Integer> difference(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("Входные данные не заданы");
        }
        Deque<Integer> result = new ArrayDeque<>();
        int digit = 0;
        int digit1;
        int digit2;
        while (d1.size() > 0 || d2.size() > 0) {
            int res = 0;
            if (d1.size() > 0) {
                digit1 = d1.pollFirst() - digit;
            }
            else{ digit1 = 0;}
            if (d2.size() > 0) {
                digit2 = d2.pollFirst();
            }
            else{ digit2 = 0;}
            digit = 0;
            if (digit1 < digit2) {
                res = digit1 + 10 - digit2;
                digit = 1;
            } else {
                res = digit1 - digit2;
            }

            result.offer(res);
        }

        return result;
    }
}
