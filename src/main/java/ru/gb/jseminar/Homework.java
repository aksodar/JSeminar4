package ru.gb.jseminar;

import java.net.StandardSocketOptions;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        //System.out.println("The result is  " + hw.multiple(new ArrayDeque<>(Arrays.asList(5,2)), new ArrayDeque<>(Arrays.asList(4))));
        // result [0,0,1]
        //System.out.println("The result is  " + hw.sum(new ArrayDeque<>(Arrays.asList(8,3,-1)), new ArrayDeque<>(Arrays.asList(-8))));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Character> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("Empty data");
        }
        ArrayDeque<Character> res = new ArrayDeque<>();
        String first = "";
        String scnd = "";
        while (d1.size() > 0){
            String str1 = String.valueOf(d1.pollLast());
            first = first + str1;
        }
        System.out.println("First value - " + first);
        int xx = Integer.parseInt(first.trim());
        while (d2.size() > 0){
            String str2 = String.valueOf(d2.pollLast());
            scnd = scnd + str2;
        }
        System.out.println("Second value - " + scnd);
        int yy = Integer.parseInt(scnd.trim());
        int mult = xx * yy;
        String multStr = String.valueOf(mult);
        char[] chars = multStr.toCharArray();

        for (char ch: chars){
            res.addFirst(ch);
        }
        return res;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    //Последний знак минус указывает на отрицательную сумму двух чисел.
    public Deque<Character> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("Empty data");
        }
        ArrayDeque<Character> res = new ArrayDeque<>();
        String first = "";
        String scnd = "";
        while (d1.size() > 0){
            String str1 = String.valueOf(d1.pollLast());
            first = first + str1;
        }
        System.out.println("First value: " + first);
        int xx = Integer.parseInt(first.trim());
        while (d2.size() > 0){
            String str2 = String.valueOf(d2.pollLast());
            scnd = scnd + str2;
        }
        System.out.println("Second value: " + scnd);
        int yy = Integer.parseInt(scnd.trim());
        int mult = xx + yy;
        if (mult > 0){

        }
        String multStr = String.valueOf(mult);
        char[] chars = multStr.toCharArray();

        for (char ch: chars){
            res.addFirst(ch);
        }
        return res;
    }
}
