package ru.gb.jseminar;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.logging.Logger;


public class Task1_1 {

    //Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    // Сложите два числа и верните сумму в виде связанного списка.
    public static void main(String[] args) {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(3,2,1));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(7,4,5));
        Task1_1 task1_1 = new Task1_1();
        Logger log = Logger.getLogger(Task1_1.class.getName());
        log.info(String.valueOf(task1_1.sum(d1, d2)));
        // result [6,6,0,1]

    }


    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        LinkedList<Integer> result = new LinkedList<>();
        int temp = 0;
        while (d1.size() > 0 || d2.size() > 0) {
            if (d1.size() > 0) { temp = temp + d1.getLast(); d1.removeLast();}
            if (d2.size() > 0) { temp = temp + d2.getLast();d2.removeLast();}
            if (temp > 9) { result.add(temp%10); temp = 1;
            } else {result.add(temp); temp = 0;}
        }
        if (temp == 1) {result.add(temp);}
        return result;
    }
}
