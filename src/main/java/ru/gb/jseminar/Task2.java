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
        Task2 t = new Task2();
        Deque<Character> staplesTrue = new ArrayDeque<>(Arrays.asList('(',')','[',']','{','[','(',')',']','}','(',')','(',')'));
        System.out.println(t.validate(staplesTrue));
        Deque<Character> staplesFalse = new ArrayDeque<>(Arrays.asList(')','(',')','('));
        System.out.println(t.validate(staplesFalse));
    }

    public boolean validate(Deque<Character> deque){
        Map<Character, Character> controlDict = new Hashtable<>();
        controlDict.put(']', '[');
        controlDict.put(')', '(');
        controlDict.put('}', '{');
        Deque<Character> stack = new ArrayDeque<>();
        char element;
        while (!deque.isEmpty()){
            element = deque.poll();
            if (controlDict.containsValue(element)){
                stack.push(element);
            }
            else
                if (controlDict.containsKey(element))
                    if (stack.size() == 0 || stack.poll() != controlDict.get(element)) return false;
        }
        return stack.size() == 0;
    }
}

