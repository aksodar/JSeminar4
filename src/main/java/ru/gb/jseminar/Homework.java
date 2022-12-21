package ru.gb.jseminar;

import java.util.*;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        //System.out.println("Multiple :" + hw.multiple(new ArrayDeque<>(Arrays.asList(5,2)), new ArrayDeque<>(Arrays.asList(4))));
        // result [0,0,1]
        System.out.println("Summa :" + hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5))));
        // result [0,-2]

    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception{
        Deque<Integer> result = new ArrayDeque();
        if(d1 == null || d1 == null) {
            throw new Exception("Входные данные не заданы!");
        }
        int num1 = 0;
        int num2 = 0;
        int count = 1;
        while(d1.size()>0) {
            num1 =num1+ d1.pollFirst() * count;
            count = count*10;
        }
        System.out.println(num1);
        count = 1;
        while(d2.size()>0) {
            num2 =num2 + d2.pollFirst() * count;
            count = count*10;
        }
        System.out.println(num2);
        int mult = num1*num2;
        while(mult>0){
            result.offer(mult%10);
            mult = mult/10;
        }
        return result;
        }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception{
        Deque<Integer> result = new ArrayDeque();
        if(d1 == null || d1 == null) {
            throw new Exception("Входные данные не заданы!");
        }
        int num1 = 0;
        int num2 = 0;
        int count = 1;
        int sign1 = 1;
        int sign2 = 1;
        if (d1.peekLast()<0) {
            sign1 = -1;
        }
        if (d2.peekLast()<0) {
            sign2 = -1;
        }
        while(d1.size()>0) {
            num1 =num1+ Math.abs(d1.pollFirst()) * count;
            count = count*10;
        }
        System.out.println(num1);
        count = 1;
        while(d2.size()>0) {
            num2 =num2 + Math.abs(d2.pollFirst()) * count;
            count = count*10;
        }
        System.out.println(num2);
        int sum = sign1*num1+sign2*num2;
        if (sum<0){
            sum = -1*sum;
            sign1 = -1;
        }
        while (sum > 0) {
            result.offer(sum % 10);
            sum = sum / 10;
        }
        int temp = result.peekLast();
        result.pollLast();
        result.offerLast(sign1*temp);
        return result;
        }
    }

