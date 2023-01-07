package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task2 {

    // Дана строка содержащая только символы '(', ')', '{', '}', '[' и ']',
    // определите, является ли входная строка логически правильной.
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

    public static void main(String[] args) throws Exception {
        String str = "{[({[()]})]}{[()]}";
        Deque<String> stDeque = new ArrayDeque<>(Arrays.asList(str.split("")));

        Task2 task = new Task2();
        System.out.println(stDeque);
        System.out.println(task.validate(stDeque));
    }

    public boolean validate(Deque<String> deque) throws Exception {
        if (deque == null) {
            throw new Exception("Входные данные пустые");
        }
        boolean result = false;

        if (deque.size() % 2 == 1) {
            return result;
        }

        boolean flag = false;
        String[] arrOpen = { "{", "[", "(" };
        String[] arrClose = { "}", "]", ")" };
        int index = -1;

        while (deque.size() > 0) {
            String tempStr = "";
            for (int i = 0; i < arrOpen.length; i++) {
                if (deque.peekFirst().equals(arrOpen[i])) {
                    index = i;
                    deque.pollFirst();
                    flag = true;
                    break;
                }
            }

            if (index == -1) {
                return result;
            }

            while (deque.size() > 0) {

                if (flag && deque.peekFirst().equals(arrClose[index])) {
                    deque.pollFirst();
                    flag = false;

                    if (deque.size() == 0 && tempStr.length() == 0) {
                        result = true;
                    }
                } else {
                    tempStr = tempStr + deque.pollFirst();

                    if (deque.size() == 0) {
                        deque = new ArrayDeque<>(Arrays.asList(tempStr.split("")));
                        break;
                    }
                }
            }
            if (deque.size() == 0) {
                result = true;
            }
        }
        return result;
    }
}
