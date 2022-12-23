package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

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
        Task2 signs = new Task2();
        Deque<Character> stringSymbols = new ArrayDeque<>(Arrays.asList('{','(','{','}',')','[',']','}'));
        System.out.println(signs.validate(stringSymbols));
    }


    public boolean validate(Deque<Character> deque){
        Map<Character, Character> val = new Hashtable<Character, Character>();
        val.put(']', '[');
        val.put(')', '(');
        val.put('}', '{');
        Stack<Character> stack = new Stack<>();
        char element;
        while (deque.size() > 0){
            element = deque.poll();
            if (val.containsValue(element))
                stack.push(element);
            else
            if (val.containsKey(element))
                if (stack.size() == 0 || stack.pop() != val.get(element)) return false;

        }
        return stack.size() == 0;
    }
}
