package ru.gb.jseminar;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.*;
import java.util.Map;

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

    public static void main(String[] args) {

        Task2 test = new Task2();
//        String testStr = "()[{}][{}()]{{]}"; // false
        String testStr = "()[{}][{}()]{[]}"; // true
        Deque<String> testDeque = new ArrayDeque<>(List.of(testStr.split("")));
        System.out.println(test.validate(testDeque));
        }

    public boolean validate(Deque<String> testDeque) {
        if (testDeque.size() % 2 != 0) {

            return false;

        }

        Map<String, String> check = new HashMap<String, String>();
        check.put("(", ")");
        check.put("[", "]");
        check.put("{", "}");

        Deque<String> stack = new ArrayDeque<>();

        while (testDeque.size() > 0) {
            if (check.containsKey(testDeque.getFirst())) {
                String temp = testDeque.removeFirst();
                stack.addLast(temp);
            } else {
                if (check.get(stack.getLast()).equals(testDeque.removeFirst())) {
                    stack.removeLast();
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}