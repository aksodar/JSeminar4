package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.logging.Logger;

public class Task1 {

    // Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся
    // в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    // Сложите два числа и верните сумму в виде связанного списка.
    public static void main(String[] args) {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(3, 2, 1, 5));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(7, 4, 7));
        Logger log = Logger.getLogger(Task0.class.getName());
        log.info(String.valueOf(new Task1().sum(d1, d2)));
        // result [1,0,6,6]

    }

    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> result = new ArrayDeque<>();
        int sum = 0;
        while (!d1.isEmpty() || !d2.isEmpty()) {
            if (!d1.isEmpty()) {
                sum += d1.pollLast();
            }
            if (!d2.isEmpty()) {
                sum += d2.pollLast();
            }
            System.out.println(sum);
            if (sum > 9) {
                result.addFirst(sum % 10);
                sum = 1;
                if (d1.isEmpty() && d2.isEmpty()) {
                    result.addFirst(sum);
                }
            } else {
                result.addFirst(sum);
                sum = 0;
            }
        }
        return result;
    }
}
