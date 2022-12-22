package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        System.out.println(hw.multiple(new ArrayDeque<>(Arrays.asList(5,2)), new ArrayDeque<>(Arrays.asList(4))));
        // result [0,0,1]
        System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5))));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("Входные данные не заданы!");
        }
        ArrayDeque<Integer> result = new ArrayDeque<>();
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        while (d1.size() > 0 || d2.size() > 0) {
            if (d1.size() > 0) {
                num1.append(d1.pollLast());
            }
            if (d2.size() > 0) {
                num2.append(d2.pollLast());
            }
        }
        String multiple = Integer.toString(Integer.parseInt(num1.toString()) * Integer.parseInt(num2.toString()));
        for(int i = multiple.length()-1; i >= 0; i -=1) {
            int tempInt = Character.getNumericValue(multiple.charAt (i));
            result.offer(tempInt);
        }
        return new ArrayDeque<>(result);
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("Входные данные не заданы!");
        }
        ArrayDeque<Integer> result = new ArrayDeque<>();
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        while (d1.size() > 0 || d2.size() > 0) {
            if (d1.size() > 0) {
                num1.append(d1.pollLast());
            }
            if (d2.size() > 0) {
                num2.append(d2.pollLast());
            }
        }
        String sum = Integer.toString(Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString()));
        for(int i = sum.length()-1; i >= 0; i -=1) {
            int tempInt = Character.getNumericValue(sum.charAt (i));
            if (tempInt < 0) {
                int temp = result.pollLast();
                result.offer(temp * -1);
            }
            else {
                result.offer(tempInt);
            }
        }
        return new ArrayDeque<>(result);
    }
}

