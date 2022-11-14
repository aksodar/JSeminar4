package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(2,3,2));//32
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(4,6,4));//21 // 6432
        Deque<Integer> d3 = new ArrayDeque<>(Arrays.asList(0,0,-2));
        Deque<Integer> d4 = new ArrayDeque<>(Arrays.asList(0,0,-2));
        Homework hw = new Homework();
        System.out.println(hw.multiple(d1,d2));
        System.out.println(hw.sum(d3,d4));

    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){
        ArrayDeque<Integer> arrayDeq = new ArrayDeque<>();
        int sum = 0;
        int temp = 0;
        int temp2 =0;

        for (int i = 0; i < d1.size()+i; i++) {
            temp += d1.pollFirst() * Math.pow(10,i);
        }
        for (int i = 0; i < d2.size()+i; i++) {
            temp2 += d2.pollFirst() * Math.pow(10,i);
        }
        sum = temp * temp2;
        while (sum / 10 != 0){
            arrayDeq.add(sum%10);
            sum /= 10;
        }
        arrayDeq.add(sum);
        return arrayDeq;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        ArrayDeque<Integer> arrayDeq = new ArrayDeque<>();
        int sum = 0;
        int tempD1 = 0;
        int tempD2 =0;


        for (int i = 0; i < d1.size()+i; i++) {
            tempD1 += d1.pollFirst() * Math.pow(10,i);
        }

        for (int i = 0; i < d2.size()+i; i++) {
            tempD2 += d2.pollFirst() * Math.pow(10,i);
        }

        sum = tempD1 + tempD2;
        while (sum / 10 != 0){
            arrayDeq.add(sum%10);
            sum /= 10;
        }
        arrayDeq.add(sum);
        return arrayDeq;
    }
}
