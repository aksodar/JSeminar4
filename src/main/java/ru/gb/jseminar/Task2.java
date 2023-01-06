package ru.gb.jseminar;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Task2 {

    // Дана строка содержащая только символы '(', ')', '{', '}', '[' и ']',
    // определите,
    // является ли входная строка логически правильной.
    // Входная строка логически правильная, если:
    // 1) Открытые скобки должны быть закрыты скобками того же типа.
    // 2) Открытые скобки должны быть закрыты в правильном порядке. Каждая
    // закрывающая скобка имеет соответствующую
    // открытую скобку того же типа.
    // ()[] = true
    // () = true
    // {[()]} = true
    // ()() = true
    // )()( = false
    private static final Map<Character, Character> characters = new HashMap<Character, Character>() {
        {
            put('{', '}');
            put('[', ']');
            put('(', ')');
        }
    };

    public static void main(String[] args) {
        System.out.print("Введите строку, содержащий только символы '(', ')', '{', '}', '[', ']' :");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        if (checkRow(s)) {
            getValidate(s);
        }
    }

    private static void getValidate(String row) {
        System.out.printf("%s = %s\n", row, validate(row));
    }

    private static boolean validate(String str) {
        Deque<Character> charDeque = new LinkedList<>();

        for (char _char : str.toCharArray()) {
            if (Character.isMirrored(_char)) {
                if (openChar(_char)) {
                    charDeque.addLast(_char);
                } else {
                    if (charDeque.size() == 0) {
                        return false;
                    }
                    Character keyChar = getKey(_char);

                    if (keyChar == charDeque.getLast()) {
                        charDeque.removeLast();
                    } else {
                        return false;
                    }
                }
            }
        }
        return charDeque.size() == 0;
    }

    private static boolean openChar(Character c) {
        return ('(' == c || '{' == c || '[' == c);
    }

    private static boolean checkRow(String s) {
        if (s.isEmpty()) {
            System.out.println("Ошибка ввода, строка не содержит значение");
            return false;
        }

        for (Character itemChar : s.toCharArray()) {
            if (!checkChar(itemChar)) {
                System.out.println("Ошибка ввода, строка содержит не валидные символы");
                return false;
            }
        }
        return true;
    }

    private static boolean checkChar(Character c) {
        for (Map.Entry<Character, Character> item : characters.entrySet()) {
            if (c == item.getValue() || c == item.getKey()) {
                return true;
            }
        }
        return false;
    }

    private static Character getKey(Character value) {
        for (Map.Entry<Character, Character> item : characters.entrySet()) {
            if (value == item.getValue()) {
                return item.getKey();
            }
        }
        return null;
    }
}