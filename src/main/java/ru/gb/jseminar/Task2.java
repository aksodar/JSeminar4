package ru.gb.jseminar;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
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

        Task2 task2 = new Task2();
        System.out.println(task2.validate("()[]"));
        System.out.println(task2.validate("()"));
        System.out.println(task2.validate("{[()]}"));
        System.out.println(task2.validate("()()"));
        System.out.println(task2.validate(")()("));

    }

    public boolean validate(String str) throws Exception {
        if ( str.length() == 0 ){
            throw new Exception("Введены неккоректные данные");
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        CharacterIterator it = new StringCharacterIterator(str);
        Deque<Character> deque = new LinkedList<>();

        while (it.current() != CharacterIterator.DONE)
        {
            char chCurrect = it.current();

            if (!map.containsKey(chCurrect)){
                deque.offerLast(chCurrect);
                it.next();
                continue;
            }

            if (deque.peekLast() == map.get(chCurrect))  {
                deque.pollLast();
            }
            else {
                deque.offerLast(chCurrect);
            }
            it.next();
        }

        return deque.size() == 0;
    }
}
