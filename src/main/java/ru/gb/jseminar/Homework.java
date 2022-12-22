package ru.gb.jseminar;

//import java.awt.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        hw.multiple(new ArrayDeque<>(Arrays.asList(5, 2)), new ArrayDeque<>(Arrays.asList(4)));
        // result [0,0,1]
        hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5)));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        Deque<Integer> result = new ArrayDeque<>();

        if (d1 == null || d2 == null) {
            throw new Exception("Входные данные отсутсвуют!");
        }

        int value = -1;
        int discharge = 0;
        while (d1.size() > 0) {
            value = (d1.pollFirst() * d2.getFirst()) + discharge;
            if (value >= 10) {
                discharge = value / 10;
                value = 0;
            }
            result.offer(value);
        }
        if (discharge != 0) {
            result.offer(discharge);
        }
        System.out.println("ОТВЕТ для функции 'multiple': " + result);
        return result;
    }

        // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        Deque<Integer> result = new ArrayDeque<>();

        if (d1 == null || d2 == null) {
            throw new Exception("Входные данные отсутсвуют!");
        }
        // Конвертирование списка в число в обратном порядке
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < d1.size(); i++) {
            s1.append(d1.pollLast());
            i--;
        }
        int number_d1 = Integer.parseInt(s1.toString());
        int discharge = 0;
        int value = number_d1 + d2.getFirst();

        if (value >= 10 || value <= -10) {
            discharge = value / 10;
            value = 0;
        }
        result.offer(value);
        if (discharge != 0) {
            result.offer(discharge);
        }

        System.out.println("ОТВЕТ для функции 'sum': " + result);
        return result;
    }
}