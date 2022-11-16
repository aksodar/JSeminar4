package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Homework hw = new Homework();
        System.out.println(hw.mul(new ArrayDeque<>(Arrays.asList(5, 2)), new ArrayDeque<>(Arrays.asList(4))));
        // result [0,0,1]
        System.out.println(hw.mul(new ArrayDeque<>(Arrays.asList(5)), new ArrayDeque<>(Arrays.asList(4))));
        // result [0,2]
        System.out.println(hw.mul(new ArrayDeque<>(Arrays.asList(1)), new ArrayDeque<>(Arrays.asList(0,1))));
        // result [0,1]
        System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5, -2)), new ArrayDeque<>(Arrays.asList(5))));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> mul(Deque<Integer> d1, Deque<Integer> d2) {
        Integer normalResult = toNormalNumber(d1) * toNormalNumber(d2);
        return toDequeNumber(normalResult);
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        if (d1.peekLast() < 0 && d2.peekLast() < 0) {
            d1.addLast(-1 * d1.pollLast());
            d2.addLast(-1 * d2.pollLast());
            Deque<Integer> result = normalSum(d1, d2);
            result.addLast(-1 * result.pollLast());
            return result;
        } else if (d1.peekLast() < 0) {
            d1.addLast(-1 * d1.pollLast());
            if (d1.size() > d2.size() || (d1.size() == d2.size() && d1.peekLast() > d2.peekLast())) {
                Deque<Integer> result = normalSub(d1, d2);
                result.addLast(-1 * result.pollLast());
                return result;
            } else {
                return normalSub(d2, d1);
            }
        } else if (d2.peekLast() < 0) {
            d2.addLast(-1 * d2.pollLast());
            if (d2.size() > d1.size() || (d2.size() == d1.size() && d2.peekLast() > d1.peekLast())) {
                Deque<Integer> result = normalSub(d2, d1);
                result.addLast(-1 * result.pollLast());
                return result;
            } else {
                return normalSub(d1, d2);
            }
        } else {
            return normalSumVer2(d1, d2);
        }
    }

    public Deque<Integer> normalSum(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> result = new ArrayDeque<>();
        Integer sum = 0;
        while (d1.size() > 0 && d2.size() > 0) {
            sum += d1.pollFirst() + d2.pollFirst();
            sum = tenDigit(sum, result);
        }
        d1.addAll(d2);
        while (d1.size() > 0) {
            sum += d1.pollFirst();
            sum = tenDigit(sum, result);
        }
        if (sum > 0) result.add(1);
        return result;
    }

    public Integer tenDigit(Integer Digit, Deque<Integer> result) {
        if (Digit - 10 >= 0) {
            result.add(Digit - 10);
            return 1;
        } else {
            result.add(Digit);
            return 0;
        }
    }

    public Deque<Integer> normalSumVer2(Deque<Integer> d1, Deque<Integer> d2) {
        Integer normalResult = toNormalNumber(d1) + toNormalNumber(d2);
        return toDequeNumber(normalResult);
    }

    public Deque<Integer> normalSub(Deque<Integer> d1, Deque<Integer> d2) {
        Integer normalResult = toNormalNumber(d1) - toNormalNumber(d2);
        return toDequeNumber(normalResult);
    }

    public Integer toNormalNumber(Deque<Integer> d) {
        Integer normalNumber = 0;
        int i = 1;
        while (d.size() > 0) {
            normalNumber += d.pollFirst() * i;
            i *= 10;
        }
        return normalNumber;
    }

    public Deque<Integer> toDequeNumber(Integer normalNumber) {
        Deque<Integer> dequeNumber = new ArrayDeque<>();
        if (normalNumber == 0) {
            dequeNumber.add(0);
            return dequeNumber;
        }
        while (normalNumber > 0) {
            Integer digitNormalNumber = normalNumber % 10;
            normalNumber /= 10;
            dequeNumber.addLast(digitNormalNumber);
        }
        return dequeNumber;
    }
}