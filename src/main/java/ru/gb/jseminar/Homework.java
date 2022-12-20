package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        System.out.println(hw.multiple(new ArrayDeque<>(Arrays.asList(5, 2)), new ArrayDeque<>(Arrays.asList(4))));
        // result [0,0,1]
        System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5, -2)), new ArrayDeque<>(Arrays.asList(5))));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if(d1 == null || d2 == null){
            throw new Exception("Входные данные пустые");
        }
            Deque<Integer> result = new ArrayDeque<>();
            int tmp1 = 0;
            int pow = 1;
        while (d1.size() > 0) {
                tmp1 = d1.poll() * pow + tmp1;
                pow = pow * 10;
            }
            int tmp2 = 0;
        pow = 1;
            while (d2.size() > 0) {
                tmp2 = d2.poll() * pow + tmp2;
                pow = pow * 10;
            }
            int res = tmp1 * tmp2;
            while (res > 0) {
                result.offer(res % 10);
                res = res / 10;
            }
            return result;
        }


        // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
        public Deque<Integer> sum(Deque <Integer> d1, Deque <Integer> d2) throws Exception {
            if (d1 == null || d2 == null) {
                throw new Exception("Входные данные пустые");
            }
            Deque<Integer> result = new ArrayDeque<>();
            int tmp1 = 0;
            int pow = 1;
            int sign = 1;
            if (d1.getLast() < 0){ sign = -1;}
            while(d1.size() > 0){
                tmp1 = Math.abs(d1.pollFirst()) * pow + tmp1;
                pow = pow * 10;
            }
            tmp1 = tmp1 * sign;
            int tmp2 = 0;
            pow = 1;
            sign = 1;
            if (d2.getLast() < 0){ sign = -1;}
            while(d2.size() > 0){
                tmp2 = Math.abs(d2.pollFirst()) * pow + tmp2;
                pow = pow * 10;
            }
            tmp2 = tmp2 * sign;
            int res = tmp1 + tmp2;
            while (Math.abs(res) > 0) {
                result.offer(res % 10);
                res = res / 10;
            }
            return result;

        }
    }

