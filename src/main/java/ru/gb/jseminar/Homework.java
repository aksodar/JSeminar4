package ru.gb.jseminar;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        System.out.println(hw.multiple(new ArrayDeque<>(Arrays.asList(5, 2)), new ArrayDeque<>(Arrays.asList(4))));
        // result [0,0,1]
        System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5, -2)), new ArrayDeque<>(Arrays.asList(5))));
//        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("Входные данные отсутствуют");
        }
        ArrayDeque<Integer> res = new ArrayDeque<Integer>();
        while(d1.size() > 0 || d2.size() > 0) {
            int mult = 0;
            int mult1 = 0;
            int multres = 0;
            if (d1.size() > 0) {
                for (int i = 0; i < d1.size() + i; i++) {
                    mult += d1.pollFirst() * Math.pow(10, i);
                }
            }
            if (d2.size() > 0) {
                for (int j = 0; j < d2.size() + j; j++) {
                    mult1 += d2.pollFirst() * Math.pow(10, j);
                }
            }
            multres = mult * mult1;
            while (multres / 10 != 0) {
                res.add(multres % 10);
                multres /= 10;
            }
            res.add(multres);
        }
        return res;
    }


    //    Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("Входные данные отсутствуют");
        }
        ArrayDeque<Integer> result = new ArrayDeque<>();
        int temp = 0;
        while(d1.size() > 0 || d2.size() > 0) {
            int sum1 = 0;
            int sum2 = 0;
            int sumres = 0;
            if (d1.size() > 0) {
                d1.offerLast(-d1.pollLast());
                for (int i = 0; i < d1.size() + i; i++) sum1 += d1.pollFirst() * Math.pow(10, i);
            }
            if (d2.size() > 0) {
                for (int j = 0; j < d2.size() + j; j++) sum2 += d2.pollFirst() * Math.pow(10, j);
            }
            sum1 = sum1 * (-1);
            sumres = sum1 + sum2;
            if (sumres <= -10) {
                while (sumres / 10 != 0) {
                    result.offer(sumres % 10);
                    sumres /= 10;
                }
            }
            if (sumres >= 10) {
                while (sumres / 10 != 0) {
                    result.offer(sumres % 10);
                    sumres /= 10;
                }
            }
            result.offer(sumres);
        }
        return result;
    }
}