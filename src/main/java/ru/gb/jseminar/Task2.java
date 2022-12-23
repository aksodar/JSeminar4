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
    // Входная строка логическ и правильная, если:
    // 1) Открытые скобки должны быть закрыты скобками того же типа.
    // 2) Открытые скобки должны быть закрыты в правильном порядке. Каждая закрывающая скобка имеет соответствующую
    // открытую скобку того же типа.
    // ()[] = true
    // () = true
    // {[()]} = true
    // ()() = true
    // )()( = false
    public static void main(String[] args) {

        Task2 comparisonOfBrackets = new Task2();
        Deque<Character> sequence = new ArrayDeque<>(Arrays.asList('{','(','{','}',')','[',']','}'));
        System.out.println(comparisonOfBrackets.validate(sequence));
    }
        public boolean validate(Deque<Character> deque){
            Map<Character, Character> verificationOfCorrec = new Hashtable<Character, Character>();
            verificationOfCorrec.put(']', '[');
            verificationOfCorrec.put(')', '(');
            verificationOfCorrec.put('}', '{');
            Stack<Character> stack = new Stack<>();
            char element;
            while (deque.size() > 0){
                element = deque.poll();
                if (verificationOfCorrec.containsValue(element))
                    stack.push(element);
                else
                if (verificationOfCorrec.containsKey(element))
                    if (stack.size() == 0 || stack.pop() != verificationOfCorrec.get(element)) return false;

            }
            return stack.size() == 0;
        }
    }