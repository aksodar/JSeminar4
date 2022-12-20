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

    public static void main(String[] args) throws Exception {
        Task2 t2 = new Task2();
        Deque<Character> d1 = new ArrayDeque<>(Arrays.asList('(', ')', '[', ']'));
        Deque<Character> d2 = new ArrayDeque<>(Arrays.asList('(', ')'));
        Deque<Character> d3 = new ArrayDeque<>(Arrays.asList('{', '[', '(', ')', ']', '}'));
        Deque<Character> d4 = new ArrayDeque<>(Arrays.asList('(', ')', '(', ')'));
        Deque<Character> d5 = new ArrayDeque<>(Arrays.asList(')', '(', ')', '('));
        System.out.println("()[] = " + t2.validate(d1));
        System.out.println("() = " + t2.validate(d2));
        System.out.println("{[()]} = " + t2.validate(d3));
        System.out.println("()() = " + t2.validate(d4));
        System.out.println(")()( = " + t2.validate(d5));

    }

    public boolean validate(Deque<Character> deque) throws Exception {
        if (deque == null || deque.size() == 0) {
            throw new Exception("коллекция пустая");
        }
        Map<Character, Character> dct = new Hashtable<Character, Character>();
        dct.put(']', '[');
        dct.put(')', '(');
        dct.put('}', '{');
        Stack<Character> stack = new Stack<Character>();
        char symbol;
        while (deque.size() > 0) {
            symbol = deque.poll();
            if (dct.containsValue(symbol)) {
                stack.push(symbol);
            } else {
                if (dct.containsKey(symbol)) {
                    if (stack.empty() || stack.pop() != dct.get(symbol)) {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }
}
