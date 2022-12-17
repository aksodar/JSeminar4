package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task1 {

    //Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    // Сложите два числа и верните сумму в виде связанного списка.
    public static void main(String[] args) throws Exception {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(2,3));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5,4,7));
        Task1 second = new Task1();
        System.out.println(second.sum(d1, d2));
        // result [6,6,0,1]

    }


    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null)
            throw new Exception("null вместо числа"); 
        ArrayDeque<Integer> result = new ArrayDeque<Integer>();
        int memo = 0;
        int summ = 0;
            while (d1.size() > 0 || d2.size() > 0){
                summ = 0;
                if (d1.size() > 0)
                    summ = d1.poll();;
                if (d2.size() > 0)
                    summ += d2.poll();    
                result.add((summ + memo) % 10);
                memo = summ / 10;

        }
        if (memo > 0) result.add(memo);

        return result;
    }
}
