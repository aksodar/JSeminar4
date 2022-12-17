package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task1 {

    //Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    // Сложите два числа и верните сумму в виде связанного списка.
    public static void main(String[] args) {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(2,7,1));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(4,3,5,1));
        Task1 task1 = new Task1();
        System.out.println(task1.sum(d1, d2));

        // result [7,0,6]

    }


    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> d3 = new ArrayDeque<>(Arrays.asList());
        int number = 0;
        while (d2.size() > 0 && d1.size() > 0) {
            if (d1.getLast() + d2.getLast() < 10) {
                d3.addFirst(d1.getLast() + d2.getLast());
                d1.pollLast();
                d2.pollLast();
            } else {
                if (d1.size() < 2 && d2.size() < 2) {
                number = d1.getLast() + d2.getLast();
                d3.addFirst(number%10);
                d3.addFirst(number/10);
                d1.pollLast();
                d2.pollLast();
                } else {
                    number = d1.getLast() + d2.getLast();
                    d3.addFirst(number%10);
                    d1.pollLast();
                    d2.pollLast();
                    d3.addFirst(d1.getLast() + d2.getLast() + number/10);
                    d1.pollLast();
                    d2.pollLast();
                }
            }

        }

        return d3;
    }
}
