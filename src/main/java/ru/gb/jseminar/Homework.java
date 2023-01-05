package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    // Даны два Deque представляющие два целых числа. Цифры хранятся в обратном
    // порядке, и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        hw.multiple(new ArrayDeque<>(Arrays.asList(5, 2)), new ArrayDeque<>(Arrays.asList(4)));
        // result [0,0,1]
        // hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new
        // ArrayDeque<>(Arrays.asList(5)));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("На входе пустые данные");
        }

        Deque<Integer> temp = new ArrayDeque<>();
        int tMul = 0;

        if (d2.size() > 0) {
            int d2Mul = d2.pollFirst();

            while (d1.size() > 0) {
                int mul = 0;
                if (d1.size() > 0) {
                    mul = d1.pollFirst() * d2Mul;
                }
                if (tMul > 0) {
                    mul = mul + tMul;
                    tMul = 0;
                }
                if (mul > 9) {
                    tMul = mul / 10;
                    mul = mul % 10;

                }
                temp.offer(mul);
            }
        }

        if (tMul > 0) {
            temp.add(tMul);
        }

        System.out.println("Произведение: " + temp);
        return temp;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два
    // числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {

        return new ArrayDeque<>();
    }
}
