package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.logging.Logger;

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
        Deque<String> str = new ArrayDeque<>(Arrays.asList("(",")","[","]"));
//        Deque<String> str = new ArrayDeque<>(Arrays.asList("(",")"));
//        Deque<String> str = new ArrayDeque<>(Arrays.asList("{","[","(",")","]","}"));
//        Deque<String> str = new ArrayDeque<>(Arrays.asList("(",")","(",")"));
//        Deque<String> str = new ArrayDeque<>(Arrays.asList(")","(",")","("));
        Task2 task2 = new Task2();
        Logger log = Logger.getLogger(Task2.class.getName());
        log.info(String.valueOf(task2.validate(str)));
    }
    public static boolean examination(Deque<String> deque,String str1,String str2){
        int count1 = 0;
        int count2 = 0;
        if (deque.getFirst() == str2 || deque.getLast() == str1){
           return false;
        } else {
            for (String item:deque) {
                if (item == str1) {
                    count1++;
                } else {
                    count2++;
                }
            }
            if (count1==count2){
                return true;
            }else{
                return false;
            }
        }
    }
    public boolean validate(Deque<String> deque){
        Deque<String> parentheses1 = new ArrayDeque<>();
        Deque<String> parentheses2 = new ArrayDeque<>();
        Deque<String> parentheses3 = new ArrayDeque<>();
        for (String item:deque) {
            if(item=="("||item==")"){
                parentheses1.add(item);
            }
            if(item=="["||item=="]"){
                parentheses2.add(item);
            }
            if(item=="{"||item=="}"){
                parentheses3.add(item);
            }
        }
        Boolean bool1 = true;
        Boolean bool2 = true;
        Boolean bool3 = true;

        if(!parentheses1.isEmpty()){
            bool1=examination(parentheses1,"(",")");
        }
        if(!parentheses2.isEmpty()){
            bool2=examination(parentheses2,"[","]");
        }
        if(!parentheses3.isEmpty()){
            bool3=examination(parentheses3,"{","}");
        }
        if(bool1&bool2&bool2){
            return true;
        }else
        return false;
    }
}
