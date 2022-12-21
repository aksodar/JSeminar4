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
        String symbols = "{[()]}}{";
        Task2 fg = new Task2();
        System.out.println(fg.validate(String.valueOf(symbols)));

    }

    public boolean validate(String symbols) {

        Deque<String> result = new ArrayDeque<>(10);
        Map<String, String> etalon = new HashMap<>();
        etalon.put("(", ")");
        etalon.put("[", "]");
        etalon.put("{", "}");
        for (String i : symbols.split("")) {
            if (etalon.containsKey(i)) {
                result.add(i);
            }
            else if (etalon.containsValue(i)) {
                if (result.size() > 0) {
                    result.pollLast();
                }
            }
        }
        if (result.size() == 0){
            return true;
        }
        else return false;


    }
}