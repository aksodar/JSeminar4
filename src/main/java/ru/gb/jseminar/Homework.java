package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
      System.out.println("multiply "+ hw.multiple(new ArrayDeque<>(Arrays.asList(5,2)),
               new ArrayDeque<>(Arrays.asList(4))));
        // result [0,0,1]
        System.out.println("sum " + hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5))));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null){
            throw new Exception("no date");
        }
        Deque result = new ArrayDeque();
        int temp = 0;
        int mult = 1;
        while (d1.size() > 0) {
            temp = d1.pollFirst() * mult + temp;
            mult = mult * 10;
        }
        int temp1 = 0;
        int mult1 = 1;
        while (d2.size()>0) {
            temp1 = d2.pollFirst() * mult1 + temp1;
            mult1 = mult1 * 10;
        }
        int res = temp1 * temp;
        while (res > 0) {
            result.offer(res % 10);
            res = res / 10;
        }
        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null){
            throw new Exception("not date");
        }
        Deque<Integer> result = new ArrayDeque<>();
        int dec = 0;
        while (d1.size()> 0 ||  d2.size()>0) {
            int sum = dec;
            dec= 0;
            int sign1=1;
            int sign2=1;
            if ((d1.size()> 0) && (d1.peekLast()<0)) {
                sign1 = -1;
            }
            if  ((d2.size()>0) && (d2.peekLast()<0)) {
                sign2 = -1;
            }
            if (d1.size() > 0  ) {
                sum += Math.abs(d1.pollFirst()) * sign1;
            }
            if (d2.size() > 0) {
                sum += Math.abs(d2.pollFirst()) * sign2;
            }
            if (sum >= 10) {
                sum = sum - 10;
                dec = 1;
            }
            result.offer(sum);
        }
        if (dec !=0){
            result.offer(dec);
        }
        return  result;
    }
}
