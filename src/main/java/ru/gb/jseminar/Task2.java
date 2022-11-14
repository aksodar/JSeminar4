package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

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
        // Task2 task2 = new Task2();
        // String someString = "()[]";
        // Deque<Character> dq = new LinkedList<>();
        // for (int x = 0; x < someString.length(); x++) {
        //     dq.add(someString.charAt(x));
        // }
        // System.out.println(task2.validate(dq));



    }


    public boolean validate(Deque<Character> deque){
        // for (Character character : deque) {
        //     if (character == '('){
        //         for (Character character2 : deque) {
        //             if 
                    
        //         }
        //     }
        // }

        return false;
    }
}
