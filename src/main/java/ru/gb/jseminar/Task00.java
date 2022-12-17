package ru.gb.jseminar;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.logging.Logger;

public class Task00 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList());
        Task00 task0 = new Task00();
        Logger log = Logger.getLogger(Task00.class.getName());
        log.info(String.valueOf(task0.checkOn(deque)));
    }

    public boolean checkOn(Deque<Integer> deque){
        if (deque.size() == 0) {
            return false;
        }
        while (deque.size() > 1) {
            if (deque.getFirst() != deque.getLast()) {
                return false;
            }
            deque.pollFirst();
            deque.pollLast();

        }
        return true;
        
    }
}
