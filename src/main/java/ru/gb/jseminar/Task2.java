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

    public static void main(String[] args) throws Exception {
        System.out.println("Введите строку которая содержит только символы '(', ')', '{', '}', '[', ']'");
        String str = new Scanner(System.in).nextLine();

        Task2 t = new Task2();
        System.out.print(str + " = " + t.validate(t.in(str)));
    }

    public Deque<Character> in(String s) throws Exception {

        Deque<Character> d1 = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char f = s.charAt(i);
            if (f == '(' || f == ')' || f == '{' || f == '}' || f == '[' || f == ']'){
                d1.offer(f);
            }
            else {
                throw new Exception("Входные данные введены не верно.");
            }
        }
        return d1;
    }


    public boolean validate(Deque<Character> d1){
        Map<Character, Character> controlDict = new Hashtable<Character, Character>();
        controlDict.put(']', '[');
        controlDict.put(')', '(');
        controlDict.put('}', '{');
        Stack<Character> stack = new Stack<>();
        char el;
        while (d1.size() > 0){
            el = d1.poll();
            if (controlDict.containsValue(el))
                stack.push(el);
            else
            if (controlDict.containsKey(el))
                if (stack.size() == 0 || stack.pop() != controlDict.get(el)) return false;

        }
        return stack.size() == 0;
    }
}
