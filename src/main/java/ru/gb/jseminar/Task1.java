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
        Task1 t1 = new Task1();
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(3, 2, 1));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(7, 4, 5));
        // result [1,0,6,6]
        Logger log = Logger.getLogger(Task1.class.getName());
        log.info(String.valueOf(t1.sum(d1, d2)));

    }

    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        ArrayDeque<Integer> array = new ArrayDeque<>();
        int sum = 0;
        while (!d1.isEmpty() || !d2.isEmpty()) {
            sum = 0;
            if (!d1.isEmpty()) {
                sum += d1.pollFirst();
            }
            if (!d2.isEmpty()) {
                sum += d2.pollFirst();
            }

            if (sum > 9) {
                array.addLast(sum / 10);
                array.addLast(sum % 10);
                // sum = 1;
            } else if (sum != 0) {
                array.addLast(sum);
            }
            // System.out.println(d1);
            // System.out.println(d2);
            // System.out.println(array);
        }
        // if (sum != 0) {
        // array.addLast(sum);
        // }

        return array;
    }
    // public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
    // Deque<Integer> dsum = new ArrayDeque<>();
    // int size = d1.size();
    // for (int i = 0; i < size; i++) {
    // if (d1.getFirst() + d2.getFirst() < 10) {
    // dsum.addLast(d1.pollFirst() + d2.pollFirst());
    // } else {
    // dsum.addLast((d1.getFirst() + d2.getFirst()) / 10);
    // dsum.addLast((d1.pollFirst() + d2.pollFirst()) % 10);
    // }
    // }
    // return dsum;
    // }
}
