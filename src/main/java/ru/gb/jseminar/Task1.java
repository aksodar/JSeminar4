package ru.gb.jseminar;

import          java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.logging.Logger;

public class Task1 {

    //Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    // Сложите два числа и верните сумму в виде связанного списка.
    public static void main(String[] args) {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(3,2,1));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(7,4,5));
        // result [1,0,6,6]
        Logger log = Logger.getLogger(Task1.class.getName());
        log.info(new Task1().sum(d1, d2).toString());
    }


    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        LinkedList<Integer> result = new LinkedList<>();
        int temp = 0;
        while (d1.size() > 0 || d2.size() > 0){
            if ((temp + d1.getFirst() + d2.getFirst() < 10)) {
                result.add(d1.pollFirst() + d2.pollFirst());
                temp = 0;
            }
            else {
                result.add((d1.pollFirst() + d2.pollFirst())%10);
                temp = 1;
            }
        }

        return new ArrayDeque<>();
    }
}
