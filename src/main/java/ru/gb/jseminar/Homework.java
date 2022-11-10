package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

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
        LinkedList<Integer> listMult = new LinkedList<>();
        int num1 = 0;
        int num2 = 0;
        int mult;
        int size1 = d1.size();
        int size2 = d2.size();
        for (int i = 0; i < size1; i++) {
            num1 += d1.pollFirst() * Math.pow(10,i);
        }
        for (int i = 0; i < size2; i++) {
            num2 += d2.pollFirst() * Math.pow(10,i);
        }
        mult = num1 * num2;
        do {
            listMult.add(mult % 10);
            mult /= 10;
        } while (mult / 10 != 0);
        listMult.add(mult);
        return listMult;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        LinkedList<Integer> listSum = new LinkedList<>();
        int sign1 = 1;
        int sign2 = 1;
        int num1 = 0;
        int num2 = 0;
        int summ;
        int size1 = d1.size();
        int size2 = d2.size();
        for (int i = 0; i < size1; i++) {
            if (d1.getFirst() < 0){
                d1.addFirst(-1 * d1.pollFirst());
                sign1 = -1;
            }
            num1 += d1.pollFirst() * Math.pow(10,i);
        }
        for (int i = 0; i < size2; i++) {
            if (d2.getFirst() < 0){
                d2.addFirst(-1 * d2.pollFirst());
                sign2 = -1;
            }
            num2 += d2.pollFirst() * Math.pow(10,i);
        }
        summ = sign1 * num1 + sign2 * num2;
        do {
            listSum.add(summ % 10);
            summ /= 10;
        } while (summ / 10 != 0);
        listSum.add(summ);
        return listSum;
    }
}
