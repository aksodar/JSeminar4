package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.logging.Logger;

public class Task0 {

    // Дан Deque состоящий из последовательности цифр.
    // Необходимо проверить, что последовательность цифр является палиндромом
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1, 4, 3, 3, 2, 1));
        Task0 task = new Task0();
        Logger log = Logger.getLogger(Task0.class.getName());
        log.info(String.valueOf(task.checkOn(deque)));
    }

    public boolean checkOn(Deque<Integer> deque) {
        boolean a = false;
        while (deque.size() > 1) {
            if (deque.pollFirst() == deque.pollLast()) {
                a = true;
            } else {
                return false;
            }
        }
        return a;
    }
}
