package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Homework hw = new Homework();
        hw.multiple(new ArrayDeque<>(Arrays.asList(5,2)), new ArrayDeque<>(Arrays.asList(4)));
        // result [0,0,1]
        hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5)));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) {

        return new ArrayDeque<>();
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {

        return new ArrayDeque<>();
    }

    public int getNumber(Deque<Integer> deque) {
        int number;
        if (deque.isEmpty()) {
            number = 0;
        } else {
            AtomicInteger i = new AtomicInteger(0);
            number = deque.stream()
                    .map((a) ->
                            a * (int) Math.pow(10, i.getAndIncrement()))
                    .reduce(0, Integer::sum);
        }
        return number;
    }

    public Deque<Integer> resultDeque(int number) {
        int temp = 0;
        Deque<Integer> result = new ArrayDeque<>();
        while (number > 0) {
            temp = number % 10;
            result.addLast(temp);
            number = (number - temp) / 10;
        }
        return result;
    }
}
