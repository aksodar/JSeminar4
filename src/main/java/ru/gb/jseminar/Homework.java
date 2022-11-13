package ru.gb.jseminar;

import java.util.*;
import java.util.logging.Logger;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.

    public static void main(String[] args) {
        Homework hw = new Homework();
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(3,2));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(7,4,-1));
        Deque<Integer> d3 = new ArrayDeque<>(Arrays.asList(3,2));
        Deque<Integer> d4 = new ArrayDeque<>(Arrays.asList(7,4,-1));
        Logger log = Logger.getLogger(Homework.class.getName());
        log.info(hw.multiply(d1,d2).toString());
        log.info(hw.sum(d3,d4).toString());

    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public LinkedList<Integer> multiply(Deque<Integer> d1, Deque<Integer> d2){
        LinkedList<Integer> result = new LinkedList<>();
        int digit1 = 1;
        int mult = 0;
        int sign;
        if ((d1.getLast()>0 && d2.getLast()>0) || (d1.getLast()<0 && d2.getLast()<0)){
            sign = 1;
        } else {
            sign = -1;
        }
        while (d1.size()>0) {
            int digit2 = digit1;
            Iterator<Integer> it2 = d2.iterator();
            while (it2.hasNext()){
                int tempRes = d1.getFirst()*it2.next()*digit2;
                if (tempRes > 0){
                    mult+=tempRes;
                } else{
                    mult-=tempRes;
                }
                digit2*=10;
            }
            digit1*=10;
            d1.removeFirst();
        }
        while (mult>=1){
            result.addFirst(mult%10);
            mult = mult/10;
        }
        result.set(0, result.getFirst()*sign);
        return result;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public LinkedList<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        LinkedList<Integer> result = new LinkedList<>();
        int sign = 1;
        String str1 = "";
        String str2 = "";
        while (d1.size()>0){
            str1+=d1.pollLast().toString();
        }
        while (d2.size()>0){
            str2+=d2.pollLast().toString();
        }
        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);
        int sum = num1+num2;
        if (sum<0) {
            sign = -1;
            sum = sum*sign;
        }
        while (sum>=1){
            result.addFirst(sum%10);
            sum = sum/10;
        }
        result.set(0, result.getFirst()*sign);
        return result;
    }
}
