package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class Homework {
    private static final Homework homework = new Homework();
    private static final Logger logger = Logger.getLogger(Homework.class.getName());

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.

    public static void main(String[] args) {

        // multiple(new ArrayDeque<>(Arrays.asList(5,2)), new ArrayDeque<>(Arrays.asList(4)));
        // result [0,0,1]
        Deque<Integer> multi = homework.multiple(new ArrayDeque<>(Arrays.asList(5,2)),
                new ArrayDeque<>(List.of(4)));
        logger.info(String.valueOf(multi));

        // sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5)));
        // result [0,-2]
        Deque<Integer> summary = homework.sum(new ArrayDeque<>(Arrays.asList(5,-2)),
                new ArrayDeque<>(List.of(5)));
        logger.info(String.valueOf(summary));
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) {
        return homework.resultDeque(getNumber(d1) * getNumber(d2));
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        return homework.resultDeque(getNumber(d1) + getNumber(d2));
    }

    public int getNumber(Deque<Integer> deque) {
        int number;
        int count;
        if (deque.isEmpty()) {
            number = 0;
        } else {
            count = (int) deque.stream()
                    .filter((n) -> n < 0)
                    .count();

            AtomicInteger i = new AtomicInteger(0);
            number = deque.stream()
                    .map((a) ->
                            Math.abs(a) * (int) Math.pow(10, i.getAndIncrement()))
                    .reduce(0, Integer::sum);
            number = (int) (number * Math.pow(-1, count));
        }
        logger.info(String.valueOf(number));
        return number;
    }

    public Deque<Integer> resultDeque(int number) {
        int temp;
        boolean minus = false;
        Deque<Integer> result = new ArrayDeque<>();
        if (number < 0) {
            number = Math.abs(number);
            minus = true;
        }
        while (number > 0) {
            temp = number % 10;
            result.addLast(temp);
            number = (number - temp) / 10;
        }
        if (minus && !result.isEmpty()) {
            int last = result.pollLast();
            result.addLast(-last);
        }
        return result;
    }
}
