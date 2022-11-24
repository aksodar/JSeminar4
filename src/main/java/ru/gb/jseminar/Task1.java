package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task1 {

    //Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    // Сложите два числа и верните сумму в виде связанного списка.
    public static void main(String[] args) {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(4,3,2,1));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(7,4,5));
        Task1 t1 = new Task1();
        if (d1.size()>= d2.size()) {
            System.out.println(t1.sum(d2,d1));
        }
        else {
            System.out.println(t1.sum(d1,d2));
        }
        // result [1,0,6,6]

    }


    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        int overnine = 0;
        int cur = 0;
        ArrayDeque<Integer> res = new ArrayDeque<>();

        while (d1.size() > 0) {
            cur = d1.pollLast() + d2.pollLast();
            res.addFirst(cur % 10 + overnine);
            overnine = cur/10;
        }

        if (d2.size()==0 && overnine!=0) {
            res.addFirst(overnine);
            return res;
        }

        if (d2.size()>0 && overnine != 0) {
            d2.addLast(d2.pollLast()+overnine);
        }

        while (d2.size()>0) {
            res.addFirst(d2.pollLast());
        }

        return res;
    }
}
