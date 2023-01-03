package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.*;
public class Task2 {
    public static void main(String[] args) throws Exception {
        Task2 T2 = new Task2();
        HashMap<String, Integer> openBrackets = new HashMap<String, Integer>() {{
            put("{", 0);
            put("[", 1);
            put("(", 2);
        }};
        HashMap<String, Integer> closeBrackets = new HashMap<String, Integer>() {{
            put("}", 0);
            put("]", 1);
            put(")", 2);
        }};


        String brackets = "{,(,{,},[,{,(,),},],),}";
        String[] strings = brackets.split(",");
        Deque<Integer> intstack = new ArrayDeque<>(Arrays.asList());
        Deque<String> stack = new ArrayDeque<>();
        main:
        for (String inLine : strings) {
//
            for (int i = 0; i < inLine.length(); i++) {
                char character = inLine.charAt(i);
                String symbol = Character.toString(character);
                if (openBrackets.containsKey(symbol)) {
                    stack.push(symbol);
                }

                else if (closeBrackets.containsKey(symbol)) {
                    if(stack.isEmpty()&&closeBrackets.containsKey(symbol)) {
                        System.out.println("Скобки расставлены не правильно.");
                        break main;
                    }
                    else if (!stack.isEmpty()) {
                        Integer NumberCheckSymbol = closeBrackets.get(symbol);
//                        System.out.print(NumberCheckSymbol + " ");
                        String firstElemFromStack = stack.pop();
                        Integer LastAddedNumberElemFromStack = openBrackets.get(firstElemFromStack);
                        intstack.offerFirst(NumberCheckSymbol);
                        intstack.offerLast(LastAddedNumberElemFromStack);
                    }
                }
            }
        }
        System.out.println(intstack);
        boolean comparisonBrackets = T2.validate(intstack);
        if (comparisonBrackets) {
            System.out.println("Скобки расставлены правильно.");
        } else {
            System.out.println("Скобки расставлены не правильно.");
        }
    }
    public boolean validate(Deque<Integer> deque) throws Exception{
        if(deque == null || deque.size() == 0) {
            throw new Exception("Коллекция пуста");
        }
        while (0 < deque.size()) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }
        return true;
    }
}

