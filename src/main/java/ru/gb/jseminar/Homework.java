package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import java.util.logging.Logger;

public class Homework {
    private static final Homework hw = new Homework();
    private static final Logger logger = Logger.getLogger(Homework.class.getName());

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Deque<Integer> result;
        result = hw.multiple(new ArrayDeque<>(Arrays.asList(5,2)), new ArrayDeque<>(Arrays.asList(4)));
        // result [0,0,1]
        logger.info(String.valueOf(result));
        result = hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5)));
        // result [0,-2]
        logger.info(String.valueOf(result));

    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){

        ArrayDeque<Integer> result = new ArrayDeque<>();
        ArrayDeque<ArrayDeque<Integer>> query = new ArrayDeque<>();

        int mult = 1;
        int tmp = 0;

        while (!d1.isEmpty() || !d2.isEmpty()) {
            int i = 0;
            while (!d1.isEmpty()) {
                if (d1.getLast() > 0)
                    tmp += d1.pollFirst() * Math.pow(10,i);
                else
                    tmp -= Math.abs(d1.pollFirst()) * Math.pow(10,i);
                i++;
            }

            mult *= tmp;
            tmp = 0;

            i = 0;
            while (!d2.isEmpty()) {
                if (d2.getLast() > 0)
                    tmp += d2.pollFirst() * Math.pow(10,i);
                else
                    tmp -= Math.abs(d2.pollFirst()) * Math.pow(10,i);
                i++;
            }

            mult *= tmp;
        }

        while (Math.abs(mult) > 9) {
            result.add(Math.abs(mult) % 10);
            mult /= 10;
        }
        result.add(mult);

        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        int sum = 0;
        while (!d1.isEmpty() || !d2.isEmpty()) {
            if (!d1.isEmpty()) {
                if (d1.getLast() >= 0)
                    sum += d1.pollFirst();
                else
                    sum -= Math.abs(d1.pollFirst());
            }
            if (!d2.isEmpty()) {
                if (d2.getLast() >= 0)
                    sum += d2.pollFirst();
                else
                    sum -= Math.abs(d2.pollFirst());
            }
            if (Math.abs(sum) > 9) {
                if (sum > 0) {
                    result.add(sum % 10);
                    sum = 1;
                } else {
                    result.add(Math.abs(sum) % 10);
                    sum = -1;
                }

            } else {
                if (!(d1.isEmpty() && d2.isEmpty()))
                    result.add(Math.abs(sum));
                else
                    result.add(sum);
                sum = 0;
            }
        }
        if (sum != 0) {
            result.add(sum);
        }

        return result;
    }

}
