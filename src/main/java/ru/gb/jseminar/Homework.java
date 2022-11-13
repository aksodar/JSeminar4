package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.logging.Logger;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {

        Deque<Integer> numbers_1 = new ArrayDeque<>(Arrays.asList(4, 3, 4, 7, 8));
        Deque<Integer> numbers_2 = new ArrayDeque<>(Arrays.asList(5, 3, 1, 7));
        Deque<Integer> numbers_3 = new ArrayDeque<>(Arrays.asList(3 ,4, -1));
        Deque<Integer> numbers_4 = new ArrayDeque<>(Arrays.asList(4, -7));

        Logger log = Logger.getLogger(Homework.class.getName());
        Homework homework = new Homework();

        log.info(String.valueOf(homework.multiple(numbers_1, numbers_2)));
        log.info(String.valueOf(homework.sum(numbers_3, numbers_4)));
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){
        Deque<Integer> result = new ArrayDeque<>();
        int temp1 = 0;
        int temp2 = 0;

        while (!d1.isEmpty()) {
            temp1 = 10 * temp1 + d1.pollLast();
        }
        while (!d2.isEmpty()) {
            temp2 = 10 * temp2 + d2.pollLast();
        }

        int mul = temp1 * temp2;

        //return new ArrayDeque<>();
        do {
            result.add(mul % 10);
            mul /= 10;
        }
        while  (mul > 0);
        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        Deque<Integer> result = new ArrayDeque<>();
    //    return new ArrayDeque<>();
    //}
        int temp1 = 0;
        int temp2 = 0;

        Boolean negative_1 = false;
        Boolean negative_2 = false;

        while (!d1.isEmpty()) {
            if (d1.getLast() < 0){
                temp1 = 10 * temp1 - d1.pollLast();
                negative_1 = true;
            }
            else {
                temp1 = 10 * temp1 + d1.pollLast();
            }

        }

        while (!d2.isEmpty()) {
            if (d2.getLast() < 0){
                temp2 = 10 * temp2 - d2.pollLast();
                negative_2 = true;
            }
            else {
                temp2 = 10 * temp2 + d2.pollLast();
            }
        }

            if (negative_1) {
                temp1 = -temp1;
            }
            if (negative_2) {
                temp2 = -temp2;
            }

            int sum = temp1 + temp2;

            if (sum > 0) {
                do{
                    result.add(sum % 10);
                    sum /= 10;
                } while  (sum > 0);
            } else {
                do{
                    result.add(sum % 10);
                    sum /= 10;
                } while  (sum < 0);
            }
    return result;
}
}
