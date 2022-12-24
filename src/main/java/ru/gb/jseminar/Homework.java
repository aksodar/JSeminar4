package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        System.out.println("Результат умножения: " + hw.multiple(new ArrayDeque<>(Arrays.asList(5,2)), new ArrayDeque<>(Arrays.asList(4))));
        // result [0,0,1]
        System.out.println("Результат сложения: " + hw.sum(new ArrayDeque<>(Arrays.asList(5)), new ArrayDeque<>(Arrays.asList(5,-2))));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null){
            throw new Exception("Входные данные не заданы!");
        }
        Deque<Integer> result = new ArrayDeque<>();

        int dozens = 0;
        while (d1.size() > 0){
            int mult1;
            int mult2;
            int mult3;
            mult1 = d1.pollFirst();
            mult2 = d2.peekFirst();
            mult3 = mult1 * mult2;
            if (mult3 < 10){
                int temp = mult3 + dozens;
                if (temp >= 10){
                    result.offer(temp % 10);
                    dozens = temp / 10;
                    continue;
                }
                result.offer(temp);
                continue;
            }
            result.offer(mult3 % 10 + dozens);
            dozens = mult3 / 10;
        }
        if (dozens > 0){
            result.offer(dozens);
        }
        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null){
            throw new Exception("Входные данные не заданы!");
        }
        Deque<Integer> result = new ArrayDeque<>();
        if (d1.peekLast() < 0 && d2.peekLast() < 0){
            d1.offerLast(d1.pollLast() * -1);
            d2.offerLast(d2.pollLast() * -1);
            int dozens = 0;
            while (d1.size() > 0 || d2.size() > 0){
                int sum = dozens;
                dozens = 0;
                if (d1.size() > 0){
                    sum += d1.pollFirst();
                }
                if (d2.size() > 0){
                    sum += d2.pollFirst();
                }
                if (sum >= 10){
                    sum = sum - 10;
                    dozens = 1;
                }
                result.offer(sum);
            }
            if (dozens != 0){
                result.offer(dozens);
            }
            result.offerLast(result.pollLast() * -1);
            return result;
        } else
        if (d1.size() >= d2.size()){
            if (d1.peekLast() < 0){
                d1.offerLast(d1.pollLast() * -1);
            }
            if (d2.peekLast() < 0){
                d2.offerLast(d2.pollLast() * -1);
            }
            while (d1.size() > 0) {
                int minuend;    // уменьшаемое
                int subtrahend; // вычитаемое
                int difference; // разность
                if (d2.size() > 0){
                    if (d1.peekFirst() >= d2.peekFirst()){
                        minuend = d1.pollFirst();
                        subtrahend = d2.pollFirst();
                        difference = minuend - subtrahend;
                        result.offer(difference);
                        continue;
                    }
                    if (d1.peekFirst() < d2.peekFirst()) {
                        minuend = d1.pollFirst() + 10;
                        subtrahend = d2.pollFirst();
                        difference = minuend - subtrahend;
                        result.offerFirst(difference);
                        d1.offerFirst(d1.pollFirst() - 1);
                        continue;
                    }
                } else {
                    result.offer(d1.pollFirst());
                }
            }
        }
        if (d1.size() < d2.size()){
            if (d1.peekLast() < 0){
                d1.offerLast(d1.pollLast() * -1);
            }
            if (d2.peekLast() < 0){
                d2.offerLast(d2.pollLast() * -1);
            }
            while (d2.size() > 0){
                int minuend;    // уменьшаемое
                int subtrahend; // вычитаемое
                int difference; // разность
                if (d1.size() > 0){
                    if (d2.peekFirst() >= d1.peekFirst()){
                        minuend = d2.pollFirst();
                        subtrahend = d1.pollFirst();
                        difference = minuend - subtrahend;
                        result.offer(difference);
                        continue;
                    }
                    if (d2.peekFirst() < d1.peekFirst()) {
                        minuend = d2.pollFirst() + 10;
                        subtrahend = d1.pollFirst();
                        difference = minuend - subtrahend;
                        result.offerFirst(difference);
                        d2.offerFirst(d2.pollFirst() - 1);
                        continue;
                    }
                } else {
                    result.offer(d2.pollFirst());
                }
            }
        }
        result.offerLast(result.pollLast() * -1);
        return result;
    }
}
