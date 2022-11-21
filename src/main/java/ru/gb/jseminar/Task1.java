package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.logging.Logger;

public class Task1 {

    //Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    // Сложите два числа и верните сумму в виде связанного списка.
    public static void main(String[] args) {
        Task1 t1 = new Task1();
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(3, 2, 5));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(7, 4, 5));
        // result [0,7,0,1]
        Logger log = Logger.getLogger(Task1.class.getName());
        log.info(String.valueOf(t1.sum(d1, d2)));
    }


    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> result = new ArrayDeque<>();
        int sum = 0;
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

