package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Homework hw = new Homework();

        System.out.println(hw.multiple(new ArrayDeque<>(Arrays.asList(5, 2)), new ArrayDeque<>(Arrays.asList(4))));
        // result [0,0,1]
        System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5, -2)), new ArrayDeque<>(Arrays.asList(5))));
        // result [0,-2]

    }

    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) {
        return IntegerToDeque(DequeToInteger(d1) * DequeToInteger(d2));
    }

    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        return IntegerToDeque(DequeToInteger(d1) + DequeToInteger(d2));
    }

    public int DequeToInteger(Deque<Integer> d) {
        int i = 0;
        try {
            i = d.pollLast();
        } catch (Exception e) {
            System.out.println("Empty input");
        }
        boolean positive = true;
        if (i < 0) {
            d.addLast(-i);
            positive = false;
        } else d.addLast(i);
        i = 0;

        while (!d.isEmpty()) {
            i = i * 10 + d.pollLast();
        }

        if (positive) return i;
        else return -i;
    }

    public Deque<Integer> IntegerToDeque(int i) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        boolean negative = false;

        if (i == 0) return deque;

        if (i < 0) {
            i = -i;
            negative = true;
        }

        while (i / 10 > 0) {
            deque.addLast(i % 10);
            i /= 10;
        }

        if (i > 0) deque.addLast(i);
        if (negative) {
            deque.addLast(-deque.pollLast());
        }
        return deque;
    }
}