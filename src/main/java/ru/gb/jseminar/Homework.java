package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(5,2));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(4));
        System.out.println("Result mult = " + hw.multiple(d1, d2).toString());
        // result [0,0,1]

        Deque<Integer> d3 = new ArrayDeque<>(Arrays.asList(5,-2));
        Deque<Integer> d4 = new ArrayDeque<>(Arrays.asList(5));// это число будет отрицательным
        // result [0,-2]
        System.out.println("Result sum = " + hw.sum(d3, d4).toString());
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception {

        if (d1 == null || d2 == null){
            throw new Exception("Error in the entered data");
        }
        Deque<Integer> result = new ArrayDeque<>();
        int doz = 1;
        int mult = 1;
        while (d1.size() > 0 || d2.size() > 0){

            if (d1.size()>0){
                mult *= d1.pollFirst();
            }
            if (d2.size()>0){
                mult *= d2.pollFirst();
            }
            if (mult >= 10){
                mult = mult % 10;
            }
            result.offer(mult);
        }
        if (doz != 0){
            result.offer(doz);
        }
        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка.
    // Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("Данные пустые");
        }
        Deque <Integer> result = new ArrayDeque<>();
        int doz = 0;
        while (d1.size() > 0 || d2.size() > 0){
            int sum = doz;
            doz = 0;
            if (d1.size() > 0){
                sum += d1.pollFirst();
            }
            if (d2.size() > 0){
                sum -= d2.pollFirst();
            }
            if (sum >= 10){
                sum = sum - 10;
                doz = 1;
            }
            result.offer(sum);
        }
        if (doz != 0){
            result.offer(doz);
        }return result;
    }
}
