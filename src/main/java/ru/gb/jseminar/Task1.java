package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task1 {

    //Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    // Сложите два числа и верните сумму в виде связанного списка.
    public static void main(String[] args) throws Exception {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1,2,3));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5,8,9));
        // result [6,6,0,1]

        Task1 sq = new Task1();
        System.out.println(sq.sum(d1, d2));
    }


    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("empty collection");
        }
        Deque<Integer> result = new ArrayDeque<>();
        int d = 0;

        while (d1.size() > 0 || d2.size() > 0) {
            int sum = d;
            d = 0;
            if(d1.size() > 0) {
                sum += d1.pollFirst();
            }
            if(d2.size() > 0) {
                sum += d2.pollFirst();
            }
            if (sum > 9){
                d = 1;
                sum = sum - 10;
            }

            result.offer(sum);
        }
        if (d != 0) {
            result.offer(d);
        }

        return result;
    }
}
