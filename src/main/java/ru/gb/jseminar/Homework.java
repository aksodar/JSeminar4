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
        System.out.println(hw.multiple(new ArrayDeque<>(Arrays.asList(5,2)), new ArrayDeque<>(Arrays.asList(4))));
//        // result [0,0,1]
        System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(-5))));
//        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 ==null){
            throw new Exception("Входные данные отсутствуют");
        }
        String res = "";
        String res1 = "";
        for (int i = 0; i < d1.size();i++) {
            res+=d1.pollLast();
            i--;
        }
        for (int i = 0; i < d2.size();i++) {
            res1+=d2.pollLast();
            i--;
        }
        int res3 = Integer.parseInt(res)*Integer.parseInt(res1);
        Deque<Integer> deque = new ArrayDeque<>();
        do{
            int temp = res3%10;
            deque.offer(temp);
            res3 /= 10;
        } while (res3!=0);
        return  deque;
    }


    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {

        if (d1 == null || d2 == null) {
            throw new Exception("Входные данные отсутствуют");
        }
        String res = "";
        String res1 = "";
        for (int i = 0; i < d1.size();i++) {
            res+=d1.pollLast();
            i--;
        }
        for (int i = 0; i < d2.size();i++) {
            res1+=d2.pollLast();
            i--;
        }

        int res9 = Integer.parseInt(res1)+Integer.parseInt(res);

        Deque<Integer> deque = new ArrayDeque<>();
        do{
            int temp = res9%10;
            deque.offer(temp);
            res9 /= 10;
        } while (res9!=0);

      return deque;
    }
}
