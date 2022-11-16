package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.logging.Logger;

public class Task1 {

    //Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    // Сложите два числа и верните сумму в виде связанного списка.
    public static void main(String[] args) {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1,2,3,4,7,8));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5,4,7,5,1,5,9,2,0,2));
        Task1 task = new Task1();
        Logger log = Logger.getLogger(Task1.class.getName());
        log.info(String.valueOf(task.sum(d1, d2)));
        // result [1,0,6,6]
    }
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        Deque<Integer> result = new ArrayDeque<>();
        int dec = 0;
        while (true) {
            Integer a = d1.pollFirst();
            Integer b = d2.pollFirst();
            if (a == null && b == null) {
                break;
            } else {
                if (a == null) a = 0;
                if (b == null) b = 0;
                int c = ((a + b) % 10) + dec;
                result.addFirst(c);
                if (a + b  > 9) {
                    dec = 1;
                } else {
                    dec = 0;
                }
            }
        }
        if (dec != 0) result.addFirst(dec);
        return result;
    }
}
