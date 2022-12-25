package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

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
        Deque<String> deque = new ArrayDeque<>(Arrays.asList("{","[","(",")","]","}"));
        Task2 t = new Task2();
        //System.out.println(t.validate(deque));
    }

    public boolean validate(Deque<String> deque) throws Exception {
        if (deque == null || deque.size() == 0) {
            throw new Exception("Empty collection");}
        Deque<String> temp = new ArrayDeque<>();
        for (String i : deque) {
            if (i.equals(charToString('{')) || i.equals(charToString('[')) || i.equals(charToString('('))) {
                temp.offerFirst(i);
            }
            else {
                if (!temp.isEmpty()
                        && ((temp.peekFirst().equals(charToString('{')) && i.equals(charToString('}')))
                        || (temp.peekFirst().equals(charToString('[')) && i.equals(charToString(']')))
                        || (temp.peekFirst().equals(charToString('(')) && i.equals(charToString(')'))))) {
                    temp.pollFirst();
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public  String charToString(char ch) {
        return String.valueOf(ch);
    }
}

