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
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(2, 5, 1));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(4));
        log.info(String.valueOf(hw.multiple(d1, d2)));
        // result [0,0,1]
        Deque<Integer> d3 = new ArrayDeque<>(Arrays.asList(8,5, -2));
        Deque<Integer> d4 = new ArrayDeque<>(Arrays.asList(9, 6, -3));
        log.info(String.valueOf(hw.sum(d3, d4)));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> result = new ArrayDeque<>();


        int sum = 0;

        while (!d1.isEmpty()) {
            int mult = 1;
            mult = mult * d1.pollFirst();
            mult = mult * d2.getFirst();
            if (mult > 9) {
                result.add(sum + (mult % 10));
                sum = mult / 10;

            } else {
                if ((sum + mult) < 9) {
                    result.add(sum + mult);
                    sum = 0;
                } else {
                    result.add((sum + mult) % 10);
                    sum = (sum + mult) / 10;
                }

            }
        }
        if (sum != 0) {
            result.add(sum);
        }


        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> result = new ArrayDeque<>();
        int sum = 0;
        if (d1.getLast() < 0 && d2.getLast() < 0) {

            int temp1 = -1 * d1.getLast();
            d1.pollLast();
            d1.addLast(temp1);
            int temp2 = -1 * d2.getLast();
            d2.pollLast();
            d2.addLast(temp2);

            while (!d1.isEmpty() || !d2.isEmpty()) //или d1 не пустой или d2 не пустой
            {
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

