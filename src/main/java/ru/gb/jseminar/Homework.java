package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Homework hw = new Homework();
        System.out.println(hw.multiple(new ArrayDeque<>(Arrays.asList(5,2)), new ArrayDeque<>(Arrays.asList(4))));
        // result [0,0,1]
        System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5))));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){
        Deque<Integer> result1 = new ArrayDeque<>();
        Integer tab2 = 0;


        while (d1.size()>0 && d2.size()>0){
            Integer temp = 0 + tab2;
            tab2 = 0;
            if (d1.size()> 0){
                temp = d1.pollFirst();
            }
            if (d2.size()>0){
                temp *= d2.pollFirst();
            }
            while (temp >= 10 ){
                temp = temp - 10;
                tab2 ++;
            }
            result1.offer(temp);
            if (tab2 > 1){
                result1.offer(0);
                tab2 = tab2 -1;
            }
        }
        if (tab2 !=0){
            result1.offer(tab2);
        }

        return result1;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        Deque<Integer> result = new ArrayDeque<>();
        int tab = 0;

        while (d1.size()>0 || d2.size()>0){
            int sum = 0 + tab;
            tab = 0;
            if (d1.size()>0){
                sum = d1.pollFirst();
            }
            if (d2.size() > 0 ){
                sum += d2.pollFirst();
            }
            if (sum >= 10){
                sum = sum - 10;
                tab = 1;
            }
            result.offer(sum);
        }
        if (tab != 0 ){
            result.offer(tab);
        }
        return result;
    }
}
