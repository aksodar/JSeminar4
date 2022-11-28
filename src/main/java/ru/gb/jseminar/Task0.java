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
        if (task0.checkOn(deque) == true) {System.out.println("Последовательность цифр является палиндромом");
        } else {System.out.println("Последовательность цифр не является палиндромом");}
        }

    public boolean checkOn(Deque<Integer> deque){
        boolean check = true;
        int size = deque.size();
        while (size > 1) {
            if (deque.getFirst() == deque.getLast()) {
                check = true;
                deque.removeFirst();
                deque.removeLast();
                size = deque.size();
            }

            else {
                check = false;
                size = 0;
            }
        }

        return check;
    }
}
