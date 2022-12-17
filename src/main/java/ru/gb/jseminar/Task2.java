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
        Task2 third = new Task2();
        Deque<Character> sequence = new ArrayDeque<>(Arrays.asList('{','(','{','}',')','[',']','}'));
        System.out.println(third.validate(sequence));
    }

  
    public boolean validate(Deque<Character> deque){
        Map<Character, Character> controlDict = new Hashtable<Character, Character>();
        controlDict.put(']', '[');
        controlDict.put(')', '(');
        controlDict.put('}', '{');
        Stack<Character> stack = new Stack<>();
        char element;
        while (deque.size() > 0){
            element = deque.poll();
            if (controlDict.containsValue(element))
                stack.push(element);
            else
            if (controlDict.containsKey(element))
                if (stack.size() == 0 || stack.pop() != controlDict.get(element)) return false;
            
        }
        return stack.size() == 0;
    }
}
