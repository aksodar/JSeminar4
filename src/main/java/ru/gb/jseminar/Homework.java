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

        if(d1 == null || d2 == null) {
            throw new Exception("Входные данные не заданы!");
    }
        int num1 = 0;
        int num2 = 0;
        int count = 1;
        while (d1.size()>0){
            num1 = num1 + d1.pollFirst() * count;
            count = count * 10;
        }
        count = 1;
        while (d2.size()>0){
            num2 = num2 + d2.pollFirst() * count;
            count = count * 10;
        }
        int res = num1 * num2;
        Deque<Integer> result = new ArrayDeque<>();
        while (res > 0){
            result.offer(res % 10);
            res = res / 10;
        }

        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if(d1 == null || d2 == null) {
            throw new Exception("Входные данные не заданы!");
        }
        int num1 = 0;
        int num2 = 0;
        int count = 1;
        int sign1 = 1;
        int sign2 = 1;
        if (d1.peekLast() < 0) {
            sign1 = -1;
            }
        if (d2.peekLast() < 0) {
            sign2 = -1;
        }
        while (d1.size() > 0){
            num1 = num1 + Math.abs(d1.pollFirst()) * count;
            count = count * 10;
        }
        count = 1;
        while (d2.size() > 0) {
            num2 += num2 + Math.abs(d2.pollFirst()) * count;
            count = count * 10;
        }
        num1 = num1 * sign1;
        num2 = num2 * sign2;
        int sum = num1 + num2;
        int signSum = 1;
        if (sum < 0) {
            signSum = -1;
        }
        sum = Math.abs(sum);
        Deque<Integer> result = new ArrayDeque<>();
        while (sum > 0){
            result.offer(sum % 10);
            sum = sum / 10;
        }
        int temp = result.pollLast() * signSum;
        result.offerLast(temp);
        return result;
    }
}
