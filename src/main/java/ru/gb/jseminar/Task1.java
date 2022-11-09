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
        Task1 task1 = new Task1();
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(3,2,1));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(7,4,5));
        Logger logger = Logger.getLogger(Task1.class.getName());
        logger.info(String.valueOf(task1.sum(d1, d2)));
        // result [1,0,6,6]

    }

    public int getNumber (Deque<Integer> p1){
        int size = p1.size();
        int pr = 1;
        int number = 0;
        for (int i = 0; i < size; i++) {
                number = number + p1.pollLast() * pr;
                pr = pr * 10;
            }
        return number;
    }
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        int number = getNumber(d1) + getNumber(d2);
        Deque<Integer> deque = new ArrayDeque<>();
        while (number/10 != 0 ){
            deque.addFirst(number%10);
            number = number/10;
        }deque.addFirst(number%10);

        return deque;
    }
}
