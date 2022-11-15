package ru.gb.jseminar;

import java.util.*;
import java.util.logging.Logger;

public class Task0 {

    // Дан Deque состоящий из последовательности цифр.
    // Необходимо проверить, что последовательность цифр является палиндромом
    public static void main(String[] args) {
        Task0 t0 = new Task0();
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1, 2, 5, 2, 1));
        Logger log = Logger.getLogger(Task0.class.getName());
        log.info(String.valueOf(t0.checkOn(deque)));

    }


    public boolean checkOn(Deque<Integer> deque) {
        while (deque.peekFirst() != null) {
            if (Objects.equals(deque.peekFirst(), deque.peekLast())) {
                deque.pollFirst();
                deque.pollLast();
            } else return false;
        }
        return true;
    }
}
