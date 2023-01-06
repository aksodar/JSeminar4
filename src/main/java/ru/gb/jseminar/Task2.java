package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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
    // )()( = false   ({)}

    public static void main(String[] args) throws Exception {
    Task2 dq = new Task2();
    Deque<String> list = new ArrayDeque<>(Arrays.asList("(",")","{","}","(",")"));
        System.out.println(dq.validate(list));
        System.out.println(dq.validate(new ArrayDeque<>(Arrays.asList("(",")","[","]"))));
        System.out.println(dq.validate(new ArrayDeque<>(Arrays.asList("(",")"))));
        System.out.println(dq.validate(new ArrayDeque<>(Arrays.asList("{","[","(",")","]","}"))));
        System.out.println(dq.validate(new ArrayDeque<>(Arrays.asList("(",")","(",")"))));
        System.out.println(dq.validate(new ArrayDeque<>(Arrays.asList(")","(",")","("))));
        System.out.println(dq.validate(new ArrayDeque<>(Arrays.asList("(","{",")","}"))));
    }

    public boolean validate(Deque<String> deque) throws Exception {
    if (deque == null){
        throw new Exception("no data");
    }
    Deque<String> res = new ArrayDeque<>();
    while (deque.size()>0){
        String x = deque.pollFirst();
        if (x == "(" || x== "[" || x=="{") {
            res.offer(x);
        }else {
            String r = res.pollLast();

            if (r != "{" && r != "(" && r != "["  ){
                return false;
            }
            if (x != ")" && r == "(" ){
                return false;
            }
            if (x != "}" && r == "{" ){
                return false;
            }if (x != "]" && r == "[" ){
                return false;
            }
        }
    }
        return true;
    }
}
