package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Homework hw = new Homework();
        //hw.multiple(new ArrayDeque<>(Arrays.asList(5, 2)), new ArrayDeque<>(Arrays.asList(4)));
        // result [0,0,1]
        //System.out.println(hw.multiply(new ArrayDeque<>(Arrays.asList(5, 2)), new ArrayDeque<>(Arrays.asList(3, 4))));
        //System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5, -2)), new ArrayDeque<>(Arrays.asList(5))));

        Deque d1 = new ArrayDeque<>(Arrays.asList(5, -2));
        Deque d2 = new ArrayDeque<>(Arrays.asList(5, 3, 5));

        System.out.println(d1);
        System.out.println(d2);

        if (d1.size() < d2.size()) d2 = hw.swap(d1, d1 = d2);

        System.out.println(d1);
        System.out.println(d2);

        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) {
        int multi;
        int i1 = 0;
        int i2 = 0;
        ArrayDeque<Integer> res = new ArrayDeque<>();

        while (!d1.isEmpty()) {
            i1 = i1 * 10 + d1.pollLast();
        }

        while (!d2.isEmpty()) {
            i2 = i2 * 10 + d2.pollLast();
        }

        multi = i1 * i2;

        while (multi / 10 > 0) {
            res.addLast(multi % 10);
            multi /= 10;
        }

        if (multi > 0) res.addLast(multi);

        return res;
    }


    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        int sum = 0;
        int flag = 1;
        int flag1 = 1;
        int flag2 = 1;
        int tmp1;
        int tmp2;
        ArrayDeque<Integer> res = new ArrayDeque<>();


        tmp1 = d1.peekLast();
        tmp2 = d2.peekLast();
        if (tmp1 < 0 && tmp2 < 0) flag = -1;
        else if (tmp1 < 0) flag1 = -1;
        else if (tmp2 < 0) flag2 = -1;
        else ;

        while (!d1.isEmpty() && !d2.isEmpty()) {
            if (!d1.isEmpty()) {
                sum += d1.poll() * flag1;

            }
            if (!d2.isEmpty()) {
                sum += d2.poll() * flag2;
            }
        }


        return res;
    }

    public Deque<Integer> sub(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> res = new ArrayDeque<>();

        return res;
    }

    public Deque swap(Deque a, Deque b) {  // usage: y = swap(x, x=y);
        return a;
    }


}
