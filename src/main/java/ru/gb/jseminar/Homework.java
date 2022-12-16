package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static java.lang.Math.abs;

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
    public static Integer dequeInInt(Deque<Integer> deque){
        int mult = 1;
        int res  = 0;
        int minusRatio = 1;
        for (int item: deque) {
            if (item < 0){minusRatio = -1;}
            res += mult * abs(item);
            mult *= 10;
        }

        return res * minusRatio;
    }
    public static Deque<Integer> intInDeque (Integer number){
        Deque<Integer> result = new ArrayDeque<>();
        int minusRatio = 1;
        if (number<0){
            number *= -1;
            minusRatio = -1;
        }

        while (number > 0) {
            result.offerLast(number % 10);
            number = number / 10;
        }

        if (minusRatio == -1) {
            int a = result.pollLast();
            a *= minusRatio;
            result.offerLast(a);
        }

        return result;
    }
    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){

        Deque<Integer> result = new ArrayDeque();

        int numFirst = dequeInInt(d1);
        int numSecond = dequeInInt(d2);

        return intInDeque(numFirst * numSecond);
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){

        Deque<Integer> result = new ArrayDeque();

        int numFirst = dequeInInt(d1);
        int numSecond = dequeInInt(d2);

        return intInDeque(numFirst + numSecond);
    }
}
