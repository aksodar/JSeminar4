package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task0 {

    // Дан Deque состоящий из последовательности цифр.
    // Необходимо проверить, что последовательность цифр является палиндромом
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList()); //1,2,3,4,3,2,1    1,2,3,4,5,6
        Task0 t = new Task0();
        System.out.println(t.checkOn(deque));
    }


    public boolean checkOn(Deque<Integer> deque){
        if (deque.isEmpty()) return false;
        for (int i = 0; i < deque.size()/2; i++) {
            if (deque.pollFirst() != deque.pollLast()) return false;
        }
        return true;
    }
}
