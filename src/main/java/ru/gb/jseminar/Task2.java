package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Hashtable;
import java.util.Map;

public class Task2 {

    // Дана строка содержащая только символы '(', ')', '{', '}', '[' и ']',
    // определите,
    // является ли входная строка логически правильной.
    // Входная строка логически правильная, если:
    // 1) Открытые скобки должны быть закрыты скобками того же типа.
    // 2) Открытые скобки должны быть закрыты в правильном порядке. Каждая
    // закрывающая скобка имеет соответствующую
    // открытую скобку того же типа.
    // ()[] = true
    // () = true
    // {[()]} = true
    // ()() = true
    // )()( = false

    public static void main(String[] args) {
        Task2 obj = new Task2();
        System.out.println(obj.validate("()[]"));
        System.out.println(obj.validate("()"));
        System.out.println(obj.validate("{[()]}"));
        System.out.println(obj.validate("()()"));
        System.out.println(obj.validate(")()("));
    }

    public boolean validate(String inputString) {
        Map<Character, Character> bracketsMap = new Hashtable<Character, Character>();
        bracketsMap.put(')', '(');
        bracketsMap.put(']', '[');
        bracketsMap.put('}', '{');
        Deque<Character> result = new ArrayDeque<>();

        for (char bracket : inputString.toCharArray()) {
            if (bracketsMap.containsValue(bracket)) {
                result.addFirst(bracket);
            } 
            else if (bracketsMap.containsKey(bracket)) {
                if (result.isEmpty() || result.pollFirst() != bracketsMap.get(bracket)) {
                    return false;
                }
            }
        }
        return result.isEmpty();
    }
}
