package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(5, 2));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(4));
        Deque<Integer> d3 = new ArrayDeque<>(Arrays.asList(5, -2));
        Deque<Integer> d4 = new ArrayDeque<>(Arrays.asList(5, 0));
        System.out.println("" + hw.multiple(d1, d2).toString());
        // result [0,0,1]
        System.out.println("" + hw.sum(d3, d4).toString());
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("Входные данные не заданы");
        }
        Deque<Integer> result = new ArrayDeque<>();
        int num = 0;
        while (d1.size() > 0 && d2.size() > 0) {
            int prod = 1;
            prod = prod + num;
            num = 0;
            if (d1.size() > 0) {
                prod = prod * d1.pollFirst();
            }
            if (d2.size() > 0) {
                prod = prod * d2.pollFirst();
            }
            if (prod >= 10) {
                prod = prod - 10;
                num = 1;
            }
            result.offer(prod);
        }
        if (num != 0) {
            result.offer(num);
        }
        return result;
    }


    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d3, Deque<Integer> d4) throws Exception {
        if (d3 == null || d4 == null) {
            throw new Exception("Входные данные не заданы");
        }
        Deque<Integer> res = new ArrayDeque<>();
        int num = 0;
        while (d3.size() > 0 && d4.size() > 0) {
            int sum = num;
            num = 0;
            if (d3.size() > 0){
                sum += d3.pollFirst();
            }
            if (d4.size() > 0){
                sum = sum - d4.pollFirst();
            }
            if (sum >= 10) {
                sum = sum - 10;
                num = 1;
            }
            res.offer(sum);
        }
        if ( num != 0){
            res.offer(num);

        }
        return res;
    }
}
