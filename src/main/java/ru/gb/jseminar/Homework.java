package Homework.homework4.JSeminar_4.src.main.java.ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    // Даны два Deque представляющие два целых числа. Цифры хранятся в обратном
    // порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        System.out.println(hw.multiple(new ArrayDeque<>(Arrays.asList(5, 2)), new ArrayDeque<>(Arrays.asList(4))));
        // result [0,0,1]
        System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5))));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1.size() == 0 && d2.size() == 0) {
            throw new Exception("both data are empty");
        }
        Deque result = new ArrayDeque<>();
        int num1 = d1.pollLast();
        if (num1 < 0) {
            while (d1.size() > 0) {
                num1 = num1 * 10 - d1.poll();
            }
        } else {
            while (d1.size() > 0) {
                num1 = d1.poll() + num1 * 10;
            }
        }
        int num2 = d2.pollLast();
        if (num2 < 0) {
            while (d2.size() > 0) {
                num2 = num2 * 10 - d2.poll();
            }
        } else {
            while (d2.size() > 0) {
                num2 = d2.poll() + num2 * 10;
            }
        }
        int multi = num1 * num2;
        if (multi == 0) {
            result.offer(multi);
        } else {
            while (multi != 0) {
                result.offer(multi % 10);
                multi = multi / 10;
            }
        }
        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два
    // числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1.size() == 0 && d2.size() == 0) {
            throw new Exception("both data are empty");
        }
        Deque result = new ArrayDeque<>();
        int num1 = d1.pollLast();
        if (num1 < 0) {
            while (d1.size() > 0) {
                num1 = num1 * 10 - d1.poll();
            }
        } else {
            while (d1.size() > 0) {
                num1 = d1.poll() + num1 * 10;
            }
        }
        int num2 = d2.pollLast();
        if (num2 < 0) {
            while (d2.size() > 0) {
                num2 = num2 * 10 - d2.poll();
            }
        } else {
            while (d2.size() > 0) {
                num2 = d2.poll() + num2 * 10;
            }
        }
        int summa = num1 + num2;
        if (summa == 0) {
            result.offer(summa);
        } else {
            while (summa != 0) {
                result.offer(summa % 10);
                summa = summa / 10;
            }
        }
        return result;
    }
}
