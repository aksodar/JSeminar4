package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

public class Task2 {

    //Дана строка содержащая только символы '(', ')', '{', '}', '[' и ']', определите,
    // является ли входная строка логически правильной.
    // Входная строка логически правильная, если:
    // 1) Открытые скобки должны быть закрыты скобками того же типа.
    // 2) Открытые скобки должны быть закрыты в правильном порядке. Каждая закрывающая скобка имеет соответствующую
    // открытую скобку того же типа.
    // ()[] = true
    // () = true
    // {[()]} = true
    // ()() = true
    // )()( = false

    public static void main(String[] args) throws Exception {
        String str = "(){{[()]}()}()";
        Deque<Character> deque = new ArrayDeque<>();
        char[] c = str.toCharArray();

        for (char i: c) {
            deque.offerLast(i);
        }
        System.out.println(deque);

        //Deque<Character> deque = new ArrayDeque<>(Arrays.asList('(', '{', '[', '(', ')', ']', '}', '[', ']', ')'));
        //Deque<Character> deque = new ArrayDeque<>(Arrays.asList('{','[','(',')',']','}'));
        Task2 result = new Task2();
        System.out.println(result.validate(deque));
    }

    public boolean validate(Deque<Character> deque) throws Exception {
        if (deque.size() % 2 != 0) {
            throw new Exception("Количество символов не четное!");
        }
        Deque<Character> stack = new ArrayDeque<>();
        Character temp;
        //Character tempLast;
        while (deque.size() > 0) {
            temp = deque.pollFirst();
            switch (temp) {
                case 123:   // { - 123
                    if (deque.size() == 0){
                        break;
                    } else if (deque.peekFirst() == 125) {
                        deque.pollFirst();
                    } else {
                        stack.offerFirst(temp);
                    }
                    break;
                case 125:   // } - 125
                    if (stack.size() > 0 && (stack.peekFirst() == 123)) {
                        stack.pollFirst();
                        break;
                    }
                    stack.offerFirst(temp);
                    break;
                case 91:    // [ - 91
                    if (deque.size() == 0){
                        break;
                    } else if (deque.peekFirst() == 93) {
                        deque.pollFirst();
                    } else {
                        stack.offerFirst(temp);
                    }
                    break;
                case 93:    // ] - 93
                    if (stack.size() > 0 && (stack.peekFirst() == 91)) {
                        stack.pollFirst();
                        break;
                    }
                    stack.offerFirst(temp);
                    break;
                case 40:    // ( - 40
                    if (deque.size() == 0){
                        break;
                    } else if (deque.peekFirst() == 41) {
                        deque.pollFirst();
                    } else {
                        stack.offerFirst(temp);
                    }
                    break;
                case 41:    // ) - 41
                    if (stack.size() > 0 && stack.peekFirst() == 40) {
                        stack.pollFirst();
                        break;
                    }
                    stack.offerFirst(temp);
                    break;
            }
        }
        if (stack.size() > 0) {
            return false;
        }
        return true;
    }
}


