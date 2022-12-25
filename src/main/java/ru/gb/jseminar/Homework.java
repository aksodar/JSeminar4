package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        Deque <Integer> deque1 = new ArrayDeque<>(Arrays.asList(5,2));
        Deque <Integer> deque2 = new ArrayDeque<>(Arrays.asList(4));
        System.out.println("Произведение: "+hw.multiple(deque1, deque2));
        // result [0,0,1]
        Deque <Integer> deque3 = new ArrayDeque<>(Arrays.asList(5,-2));
        Deque <Integer> deque4 = new ArrayDeque<>(Arrays.asList(0,5));
        System.out.println("Сумма: "+hw.sum(deque3, deque4));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null){
            throw new Exception("Входные данные не заданы");
        }
        Deque <Integer> result = new ArrayDeque<>();
        int dozens = 0;
        while(d1.size() > 0 || d2.size() > 0){
            int mult = 1;
            if (d1.size() > 0) {
                mult = mult * d1.pollFirst();
            }
            if(d2.size() > 0) {
                mult = mult * d2.peekFirst() + dozens;
                dozens = 0;
            }
            if (mult >= 10){
                dozens = mult/10;
                mult = mult%10;
            }

            result.offer(mult);
            if (d1.size() == 0) {
                d2.pollFirst();
                if (dozens!=0) {
                    result.offer(dozens);
                }
            }
        }
        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("Входные данные не заданы!");
        }
        Deque<Integer> result = new ArrayDeque<>();
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < d1.size(); i++) {
            s1 = s1 + d1.pollLast();
            i--;
        }
        for (int j = 0; j < d2.size(); j++) {
            s2 = s2 + d2.pollLast();
            j--;
        }
        int resInt = Integer.parseInt(s2) + Integer.parseInt(s1);
        do {
            int rem = resInt%10;
            result.offer(rem);
            resInt = resInt/10;
        } while (resInt != 0);
        return result;
    }
}
