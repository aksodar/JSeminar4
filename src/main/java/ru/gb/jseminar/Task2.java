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
        Deque<Character> d1 = new ArrayDeque<Character>(Arrays.asList('(',  ')', '[' ,']'));
        Task2 t2 = new Task2();
        System.out.println(t2.validate(d1));
    }

    public boolean validate(Deque<Character> deque) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        Stack<Character> st = new Stack<>();
        while (deque.size() > 0) {
            char element = deque.poll();
            if (map.containsValue(element))
            {
                st.push(element);
            }
             else if (map.containsKey(element))
                if (st.size() == 0 || st.pop() != map.get(element)) {
                    return false;
                }
            }
            return st.size() == 0;
        }
    }
