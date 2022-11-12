package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.logging.Logger;

public class Homework1 {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Deque<Integer>d1 = new ArrayDeque<>(Arrays.asList(2,5));
        Deque<Integer>d2 = new ArrayDeque<>(Arrays.asList(5,2));
        Homework1 homework = new Homework1();
        Logger log = Logger.getLogger(Homework1.class.getName());
        log.info(String.valueOf(homework.multiple(d1,d2)));


    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){
        ArrayDeque<Integer> result = new ArrayDeque<>();
        ArrayDeque<Integer> result2 = new ArrayDeque<>();
        ArrayDeque<Integer> result3 = new ArrayDeque<>();
        ArrayDeque<Integer> result4 = new ArrayDeque<>();
        int sum=0;
        int mult=0;
        int i=0;
        int j=0;
        for (int item:d2) {
            for (int item2:d1) {
                sum = item * item2 + mult;
                if (sum < 10) {
                    result.add(sum);
                    mult = 0;
                } else {
                    result.add(sum % 10);
                    mult = sum / 10;
                }
            }
            if(mult!=0){
                result.add(mult);
                mult=0;
            }
            if (i!=0){
                for (int item4:result2) {
                    if (i<=j){
                    }else {
                        result3.add(result2.remove());
                    }
                    j++;
                }
                System.out.println(result3);
            }else{
                for (int item3:result) {
                    result2.add(result.remove());
                }
                System.out.println(result2);
            }
            i++;
        }
        int sum1 = 0;
        while (!result2.isEmpty() || !result.isEmpty()) {
            if (!result2.isEmpty()) {
                sum1 += result2.pollFirst();
            }
            if (!result.isEmpty()) {
                sum1 += result.pollFirst();
            }
            if (sum1 > 9) {
                result4.add(sum1 % 10);
                sum1 = 1;
            } else {
                result4.add(sum1);
                sum1 = 0;
            }
        }
        if (sum1 != 0) {
            result4.add(sum1);
        }
        result4.addFirst(result3.pollFirst());
//        System.out.println(result4);
        return result4;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){

        return new ArrayDeque<>();
    }

}
