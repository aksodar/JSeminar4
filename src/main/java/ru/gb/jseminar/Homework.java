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
        log.info(String.valueOf(hw.multiple(new ArrayDeque<>(Arrays.asList(1,2,5,5,2)), new ArrayDeque<>(Arrays.asList(4)))));
        // result [0,0,1]
        log.info(String.valueOf(hw.sum(new ArrayDeque<>(Arrays.asList(5, 6, 2)), new ArrayDeque<>(Arrays.asList(5, 7, -2)))));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){
        Deque<Integer> dq = new ArrayDeque<>();
        int size = 0;
        int result = 0;
        int n1 = 0;
        int n2 = 0;
        int s = 1;
        while (size < d1.size()) {
            result += d1.getFirst() * s;
            d1.removeFirst();
            s *= 10;
        }
        n1 = result;
        result = 0;
        s = 1;
        while (size < d2.size()) {
            result += d2.getFirst() * s;
            d2.removeFirst();
            s *= 10;
        }
        n2 = result;
        int total = n1 * n2;
        System.out.println(total);
        s = 10;
        if (total == 0) {
            dq.add(total);
            return dq;
        }
        else {
            while (total > 0 || total < 0) {
                if(total < 0 && total > -9 || total > 0) {
                    dq.add(total % s);
                    total = (total - (total % s)) / s;
                }
                else {
                    dq.add(-(total % s));
                    total = (total - (total % s)) / s;
                }
                System.out.println(dq.getLast());
            }
            return dq;
        }
    }        

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        int result1 = 0;
        int result2 = 0;
        int sss1 = 1;
        int sss2 = 1;
        while(i < d1.size()) {
            if(d1.getFirst() < 0) {
                result1 += (-d1.getFirst()) * sss1;
                result1 = (-result1);
            }
            else {
                result1 += d1.getFirst() * sss1;
            }
            d1.removeFirst();
            sss1 *= 10;
        }
        while(i < d2.size()) {
            if(d2.getFirst() < 0) {
                result2 += (-d2.getFirst()) * sss2;
                result2 = (-result2);
            }
            else {
                result2 += d2.getFirst() * sss2;
            }
            d2.removeFirst();
            sss2 *= 10;
        }
        int sum = result1 + result2;
        int s = 10;
        if (sum == 0) {
            dq.add(sum);
            return dq;
        }
        else {
            while (sum > 0 || sum < 0) {
                if(sum < 0 && sum > -9 || sum > 0) {
                    dq.add(sum % s);
                    sum /= s;
                }
                else {
                    dq.add(-(sum % s));
                    sum /= s;
                }
            }
            return dq;
        }
    }
}
