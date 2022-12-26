package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Task2 {

    //Дана строка содержащая только символы '(', ')', '{', '}', '[' и ']', 
    //определите,
    // является ли входная строка логически правильной.
    // Входная строка логически правильная, если:
    // 1) Открытые скобки должны быть закрыты скобками того же типа.
    // 2) Открытые скобки должны быть закрыты в правильном порядке.
    // Каждая закрывающая скобка имеет соответствующую
    // открытую скобку того же типа.
    // ()[] = true
    // () = true
    // {[()]} = true
    // ()() = true
    // )()( = false

    public static void main(String[] args) throws Exception {
        
        Deque<Character> dq = new ArrayDeque<>(Arrays.asList('{','(',')','}'));
        
        
        Task2 sq = new Task2();
        System.out.println(sq.validate(dq));
    }

    public boolean validate(Deque<Character> dq) throws Exception{

        if (dq == null)  {
            throw new Exception("pusto");
        }
       
        if (dq.size()%2 != 0 || dq.peekFirst() == ')' || dq.peekFirst() == '}' || dq.peekFirst() == ']'){
            return false;
        }

        Character x = dq.pollFirst(); 
        while (dq.size() > 0){
            if (x == '('){
                if (dq.peekFirst() == ')'){
                    dq.pollFirst();
                    x = dq.pollFirst();
                }
                else if (dq.peekLast() == ')'){
                    dq.pollLast();
                    x = dq.pollFirst();
                }
                else return false;
            }
            else if (x == '{'){
                if (dq.peekFirst() == '}'){
                    dq.pollFirst();
                    x = dq.pollFirst();
                }
                else if (dq.peekLast() == '}'){
                    dq.pollLast();
                    x = dq.pollFirst();
                }
                else return false;
            }
            else if (x == '['){
                if (dq.peekFirst() == ']'){
                    dq.pollFirst();
                    x = dq.pollFirst();
                }
                else if (dq.peekLast() == ']'){
                    dq.pollLast();
                    x = dq.pollFirst();
                }
                else return false;
            }
            else return false;
        }
        if (dq.size() == 0){
            return true;
        }
        else return false;
 }
}