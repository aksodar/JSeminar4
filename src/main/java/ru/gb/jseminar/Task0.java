package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task0 {

    // Дан Deque состоящий из последовательности цифр.
    // Необходимо проверить, что последовательность цифр является палиндромом
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1,2,3,3,2,1));
        Task0 task0 = new Task0();
        System.out.println(task0.checkOn(deque));

    }


    public boolean checkOn(Deque<Integer> deque){
        int size = deque.size();
        for (int i = 0; i < size / 2; i++){
            if (deque.pollFirst() != deque.pollLast())
            {
                return false;
            }
            System.out.println(deque);
        }
        return true;
    }
}
