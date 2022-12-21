package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        System.out.println(hw.multiple(new ArrayDeque<>(Arrays.asList(5, 2)), new ArrayDeque<>(Arrays.asList(4))));
//        // result [0,0,1]
        System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5, -2)), new ArrayDeque<>(Arrays.asList(5))));
//        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("Входные данные отсутствуют");
        }
        String result1 = "";
        String result2 = "";
        for (int i = 0; i < d1.size(); i++) {
            result1 =result1 + d1.pollLast();
            i--;
        }
        for (int i = 0; i < d2.size(); i++) {
            result2 = result2 + d2.pollLast();
            i--;
        }
        int result3 = Integer.parseInt(result1) * Integer.parseInt(result2);
        Deque<Integer> deque = new ArrayDeque<>();
        while (result3 != 0) {
            int temp = result3 % 10;
            deque.offer(temp);
            result3 /= 10;
        }
        return deque;
    }
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {

        if (d1 == null || d2 == null) {
            throw new Exception("Входные данные отсутствуют");
        }
        String result1 = "";
        String result2 = "";
        for (int i = 0; i < d1.size();i++) {
            result1=result1 + d1.removeLast();
            i--;
        }
        for (int i = 0; i < d2.size();i++) {
            result2=result2 + d2.removeLast();
            i--;
        }

        int result4 = Integer.parseInt(result2)+Integer.parseInt(result1);

        Deque<Integer> deque = new ArrayDeque<>();
        while (result4!=0){
            int temp = result4%10;
            deque.offer(temp);
            result4 /= 10;
        }

        return deque;
    }
}


