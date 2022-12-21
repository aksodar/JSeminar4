package ru.gb.jseminar;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
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
        String staples = ")()(";
        Task2 t2 = new Task2();
        System.out.println(t2.validate(staples));
    }

    public boolean validate(String staples) {
        Map<Character, Character> check  = new HashMap<>();
        check.put(')', '(');
        check.put('}', '{');
        check.put(']', '[');
        Deque<Character> stack = new LinkedList<>();
        for (char c : staples.toCharArray()) {
            if (check.containsValue(c)) {
                stack.push(c);
            } else if (check.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != check.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}