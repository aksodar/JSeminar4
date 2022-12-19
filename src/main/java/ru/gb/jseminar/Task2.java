package ru.gb.jseminar;

import java.util.*;

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
        Task2 qwert = new Task2();
        String testStr = "()[][({}())]{{[]}}";
        Deque<String> dano = new ArrayDeque<>(List.of(testStr.split("")));
        System.out.println(qwert.validate(dano));
        ;
    }

    public boolean validate(Deque<String> dano) {
        if (dano.size() % 2 != 0) {
            System.out.println("Error data");
            return false;
        }
        Map<String, String> check = new HashMap<String, String>();
        check.put("(", ")");
        check.put("[", "]");
        check.put("{", "}");
        Deque<String> stack = new ArrayDeque<>();
        while (dano.size() > 0) {
            if (check.containsKey(dano.getFirst())) {
                String temp = dano.removeFirst();
                stack.addLast(temp);
            } else {
                if (check.get(stack.getLast()).equals(dano.removeFirst())) {
                    stack.removeLast();
                } else {
                    System.out.println("Error data");
                    return false;
                }
            }
        }
        return true;
    }
}
