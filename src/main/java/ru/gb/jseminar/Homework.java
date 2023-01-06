package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        System.out.printf("Результат умножения: %s\n", hw.multiple(new ArrayDeque<Integer>(Arrays.asList(0, 5, -2)), new ArrayDeque<Integer>(Arrays.asList(-4))));
        // result [0,0,1]
        System.out.printf("Результат сложения:  %s\n", hw.sum(new ArrayDeque<>(Arrays.asList(0, 5, -2)), new ArrayDeque<>(Arrays.asList(-5))));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception{
        if (d1.size() == 0 || d2.size() == 0) {
            throw new Exception("Коллекция пустая.");
        }

        Deque<Integer> result = new ArrayDeque<Integer>();
        Integer number = 0;
        Integer symbol = d1.pollLast();
        boolean flag = false;

        if(symbol < 0) flag = true;

        while(d1.size() >= 0){
            number += (int)(Math.abs(symbol) * Math.pow(10, d1.size()));
            if(d1.size() == 0) break;
            symbol = d1.pollLast();
        }

        if(flag == true) number *= (-1) * d2.pollLast();
        else number *= d2.pollLast();
        System.out.println(number);
        for(char num: Integer.toString(number).toCharArray()){
            if(num == '-') continue;
            result.offerFirst(Character.getNumericValue(num));
        }

        if(number < 0) result.offerLast(result.pollLast() * (-1));
        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception{
        if (d1.size() == 0 || d2.size() == 0) {
            throw new Exception("Коллекция пустая.");
        }

        Deque<Integer> result = new ArrayDeque<Integer>();
        Integer number = 0;
        Integer symbol = d1.pollLast();
        boolean flag = false;

        if(symbol < 0) flag = true;
        
        while(d1.size() >= 0){
            number += (int)(Math.abs(symbol) * Math.pow(10, d1.size()));
            if(d1.size() == 0) break;
            symbol = d1.pollLast();
        }
            
        if(flag == true) number -= d2.pollLast();
        else number += d2.pollLast();

        for(char num: Integer.toString(number).toCharArray()){
            if(num == '-') continue;
            result.offerFirst(Character.getNumericValue(num));
        }

        if(flag == true) result.offerLast(result.pollLast() * (-1));
        return result;
    }
}
