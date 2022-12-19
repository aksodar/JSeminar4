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
    Task2 t2 = new Task2();
        Deque<Character> brackets = new ArrayDeque<>(Arrays.asList('{','(','{','}',')','[',']','}'));
        System.out.println(t2.validate(brackets));
    }

    public boolean validate(Deque<Character> deque){
        Map<Character, Character> controlDict = new Hashtable<>(); // создаем словарь
        controlDict.put(']', '['); // заполняем словарь
        controlDict.put(')', '(');
        controlDict.put('}', '{');
        Deque<Character> stack = new ArrayDeque<>(); // создаем deque stack
        char element;                           // создаем переменную типа char
        while (!deque.isEmpty()){               // пока deque не пустой
            element = deque.poll();                     // забираем первый элемент deque и кладем в char
            if (controlDict.containsValue(element)){   // если словарь содержит значение равное char
                stack.push(element);                   // кладем этот char в stack
//            System.out.println(stack);
            }
            else                                       // иначе
            if (controlDict.containsKey(element))      // если словарь содержит ключ равный char
                if (stack.size() == 0 || stack.poll() != controlDict.get(element)) return false;
            // если (размер stack == 0 или первый элемент(извлекаем и удаляем) stack != значению по ключу char -> возвращаем false
        }
        return stack.size() == 0; // проверяем пуст ли stack
    }

}
