package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
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
        Deque<Character> examplList = new ArrayDeque<>(Arrays.asList('(', '{', '}', '(', ')', '[', ']', ')')); //'(', '{', '}', '(', ')', '[', ']', ')'
        Task2 task2 = new Task2();

        System.out.println(task2.validate(examplList));
    }

    public boolean validate(Deque<Character> deque) throws Exception{
        if (deque.size() == 0){
            throw new Exception("Пустая коллекция.");
        }

        while (deque.size() > 0){
            if (deque.size() % 2 != 0) return false;
            Character symbol = deque.pollFirst();

            switch (symbol){
                case '(':
                    if (deque.peekLast() != ')'){
                        if (deque.peekFirst() != ')') return false;
                        else deque.pollFirst();
                    }
                    else deque.pollLast();
                    break;

                case '[':
                if (deque.peekLast() != ']'){
                    if (deque.peekFirst() != ']') return false;
                    else deque.pollFirst();
                }
                else deque.pollLast();
                    break;

                case '{':
                if (deque.peekLast() != '}'){
                    if (deque.peekFirst() != '}') return false;
                    else deque.pollFirst();
                }
                else deque.pollLast();
                    break;
            }
        }
        return true;
    }
}
