package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task0 {

    // Дан Deque состоящий из последовательности цифр.
    // Необходимо проверить, что последовательность цифр является палиндромом
    public static void main(String[] args) throws Exception {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1,2,3,4,5,6));

        Task0 palindrom = new Task0();
        System.out.println(palindrom.checkOn(deque));
    }


    public boolean checkOn(Deque<Integer> deque) throws Exception {
        if (deque == null || deque.size() == 0  ) {
            throw new Exception("Коллекция пустая");
        }
        while (deque.size() > 1) {
            if (deque.pollFirst().equals(deque.pollLast())){
                return  false;
            }
        }
        return true;
    }
}
