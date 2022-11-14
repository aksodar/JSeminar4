package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task1 {

    //Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    // Сложите два числа и верните сумму в виде связанного списка.
    public static void main(String[] args) {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5, 4, 7));
        Task1 t1 = new Task1();
        System.out.print(t1.sum(d1,d2));
        // result [1,0,6,6]

    }


    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        ArrayDeque<Integer> arrayDeq = new ArrayDeque<>();
        int sum = 0;
        while (!d1.isEmpty() || !d2.isEmpty()) {
            if (!d1.isEmpty()) {
                sum += d1.pollFirst();
            }
            if (!d2.isEmpty()) {
                sum += d2.pollFirst();
            }
            if (sum > 9) {
                arrayDeq.add(sum % 10);
                sum = 1;
            } else {
                arrayDeq.add(sum);
                sum = 0;
            }
        }
        if (sum != 0) arrayDeq.add(sum);
        return arrayDeq;
    }
}
