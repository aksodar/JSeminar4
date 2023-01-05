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
        Task2 brackets = new Task2();
        Deque<Character> T2 = new ArrayDeque<>(Arrays.asList('(', ')', '{', '}', '[', ']'));
        System.out.println(brackets.validatebrackets(T2));
    }

    public boolean validatebrackets(Deque<Character> deque){
        Map<Character, Character> bracketsrools = new Hashtable<>();
        Stack<Character> br = new Stack<>();
        bracketsrools.put(')', '(');
        bracketsrools.put('}', '{');
        bracketsrools.put(']', '[');
        char val;
        while (deque.size() > 0){
            val = deque.poll();
            if (bracketsrools.containsValue(val))
                br.push(val);
            else if (bracketsrools.containsKey(val))
                if (br.size() == 0 || br.pop() != bracketsrools.get(val)) return false;
        }
        return br.size() == 0;
    }
}

