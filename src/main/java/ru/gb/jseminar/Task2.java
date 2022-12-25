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
        Task2 tr = new Task2();
        Deque<Character> line = new ArrayDeque<>(Arrays.asList('[','(',')','{','(','[',']',')','}',']'));
        System.out.println(tr.validate(line));

    }

    public boolean validate(Deque<Character> deque){
        Map<Character, Character> dict = new Hashtable<Character, Character>();
        dict.put(')', '(');
        dict.put('}', '{');
        dict.put(']', '[');
        Stack<Character> stack = new Stack<>();
        char ch;
        while (deque.size() > 0){
            ch = deque.poll();
            if (dict.containsValue(ch)) {
                stack.push(ch);
            }else {
                if (dict.containsKey(ch)) {
                    if (stack.size() == 0 || stack.pop() != dict.get(ch)) {
                        return false;
                    }
                }
            }

        }
        return stack.size() == 0;
    }
}
