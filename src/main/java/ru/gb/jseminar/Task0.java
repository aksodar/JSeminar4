package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;

public class Task0 {

    // Дан Deque состоящий из последовательности цифр.
    // Необходимо проверить, что последовательность цифр является палиндромом
    public static void main(String[] args) throws Exception {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(6, 6, 4, 4, 5, 6));

        Task0 t = new Task0();

        System.out.println(t.checkOn(deque));

    }


    public boolean checkOn(Deque<Integer> deque) throws Exception {
        if (deque == null || deque.size() == 0) {
            throw new Exception("Коллекция пустая");
        }
        while (deque.size() > 1) {
            if (!Objects.equals(deque.pollFirst(), deque.pollLast())) {
                return false;
            }

        }

        return true;
    }
}
