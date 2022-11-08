package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.logging.Logger;

public class Task0 {

    // Дан Deque состоящий из последовательности цифр.
    // Необходимо проверить, что последовательность цифр является палиндромом
    public static void main(String[] args) {
        Task0 task0 = new Task0();
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1,2,3,3,2,1));
        Logger logger = Logger.getLogger(Task0.class.getName());
        logger.info(String.valueOf(task0.checkOn(deque)));

    }


    public boolean checkOn(Deque<Integer> deque){
        int size = deque.size();
        boolean result = false;
        if (size == 2){
            if(deque.getFirst() == deque.getLast()){
                result = true;
                return result;
            }}
        else if (size == 1) return true; 
        else {
                if (deque.getFirst() == deque.getLast()){
                    deque.pollFirst();  
                    deque.pollLast();
                }
                else {
                    result = false;
                    return result;
                } 
            }
        return checkOn(deque);
    }    

    
}
