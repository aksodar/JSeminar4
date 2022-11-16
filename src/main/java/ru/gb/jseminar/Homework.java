package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Homework hw = new Homework();
        //hw.multiple(new ArrayDeque<>(Arrays.asList(5,2)), new ArrayDeque<>(Arrays.asList(4)));
        // result [0,0,1]
        //hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5)));
        // result [0,-2]
        System.out.println(hw.multiple(new ArrayDeque<>(Arrays.asList(5,2)), new ArrayDeque<>(Arrays.asList(4))));
        System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5))));

    }

    public int DequeToInt(Deque<Integer> num)
    {
        int sum = 0;
        int step = 1;
        Boolean minus = false;

        for (int i = 0; i <= num.size(); i++){            
            int curnum = num.pollFirst();
            if (curnum < 0){
                minus = true;
                curnum *= -1;
            }                            
            sum += curnum * step;
            step *= 10;
        }

        if (minus)
            sum *= -1;
            
        return sum;
    }

    public Deque<Integer> IntToDeque(int num){        
        ArrayDeque<Integer> dequeNum = new ArrayDeque<Integer>();          
        do {
            dequeNum.add(num % 10);
            num /= 10;
        } while (num / 10 != 0);        
        dequeNum.add(num);
        
        return dequeNum;
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){
        return IntToDeque(DequeToInt(d1) * DequeToInt(d2));
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        
        return IntToDeque(DequeToInt(d1) + DequeToInt(d2));
    }
}
