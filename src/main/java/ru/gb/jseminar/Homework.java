package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.logging.Logger;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Homework hw = new Homework();
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(5,2));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5,2));
        Deque<Integer> d3 = new ArrayDeque<>(Arrays.asList(5,-2));
        Deque<Integer> d4 = new ArrayDeque<>(Arrays.asList(5));
        Logger log = Logger.getLogger(Homework.class.getName());
        log.info(String.valueOf(hw.multiple(d1, d2)));
        log.info(String.valueOf(hw.sum(d3, d4)));
        // result [5,2,6]
       // hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5)));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){
        Deque<Integer> result = new ArrayDeque<>();
        int numb1 = 0;
        int numb2 = 0;
        while (!d1.isEmpty()) {
            numb1 = (numb1 * 10) + d1.pollLast();
        }
        while (!d2.isEmpty()) {
            numb2 = (numb2 * 10) + d2.pollLast();
        }
        int multi = numb1 * numb2;
        do {
            result.add(multi % 10);
            multi /= 10;
        } while  (multi > 0);
        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d3, Deque<Integer> d4){
        Deque<Integer> result = new ArrayDeque<>();
        int numb1 = 0;
        int numb2 = 0;
        boolean zn_1 = false;
        boolean zn_2 = false;
        while (!d3.isEmpty()) {
            if (d3.getLast() < 0){
                numb1 = 10 * numb1 - d3.pollLast();
                zn_1 = true;
            }
            else {
                numb1 = 10 * numb1 + d3.pollLast();
            }
        }
        while (!d4.isEmpty()) {
            if (d4.getLast() < 0){
                numb2 = 10 * numb2 - d4.pollLast();
                zn_2 = true;
            }
            else {
                numb2 = 10 * numb2 + d4.pollLast();
            }
        }
        if (zn_1) {
            numb1 = -numb1;
        }
        if (zn_2) {
            numb2 = -numb2;
        }
        int summa = numb1 + numb2;
        if (summa > 0) {
            do {
                result.add(summa % 10);
                summa /= 10;
            } while  (summa > 0);
        } else {
            do {
                result.add(summa % 10);
                summa /= 10;
            } while  (summa < 0);
        }
        return result;
    }
}



