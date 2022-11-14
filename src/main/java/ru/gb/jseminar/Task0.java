package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task0 {

    // Дан Deque состоящий из последовательности цифр.
    // Необходимо проверить, что последовательность цифр является палиндромом
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1,2,3,4,5,6));

    }


    public boolean checkOn(Deque<Integer> deque){
        if (deque != null && deque.size() > 0){
            if (deque.size() == 1) return true;
            if (deque.size() > 1){
                if (!deque.pollFirst().equals(deque.pollLast())) return false;
            }
        }

        return false;
    }
}
