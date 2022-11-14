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
        result = hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5,1)));
        // result [0,-2]
        logger.info(String.valueOf(result));

    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){

        return new ArrayDeque<>();
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
                    sum -= d1.pollFirst();
            }
            if (!d2.isEmpty()) {
                if (d2.getLast() >= 0)
                    sum += d2.pollFirst();
                else
                    sum -= d2.pollFirst();
            }
            if (sum > 9) {
                result.add(sum % 10);
                sum = 1;
            } else {
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
