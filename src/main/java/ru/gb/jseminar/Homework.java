package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.logging.Logger;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(3,2,1));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(7,4,7));

        Deque<Integer> d3 = new ArrayDeque<>(Arrays.asList(3,2,1));
        Deque<Integer> d4 = new ArrayDeque<>(Arrays.asList(7,5,-3));

        Homework hw = new Homework();
        Logger log = Logger.getLogger(Homework.class.getName());
        log.info(String.valueOf(hw.multiple(d1, d2)));
        log.info(String.valueOf(hw.sum(d3, d4)));
    }

    // Умножьте два числа и верните произведение.
    public Integer multiple(Deque<Integer> d1, Deque<Integer> d2){
        
        int totalResult = 0;
        int digitKoeff = 0;

        while(!d2.isEmpty()){
            ArrayDeque<Integer> result = new ArrayDeque<>();
            int temp = 0;
            int tempResult = 0;
            for (int elem : d1){
                temp = elem * d2.getFirst() + temp;
                result.add(temp % 10);
                temp  = temp / 10;
            }
            if (temp > 0) {
                result.add(temp);
            }           
            int len = result.size();
            for (int i = 0; i < len; i++) {
                tempResult += result.pollFirst() * Math.pow(10, i);
            }
            totalResult += tempResult  * Math.pow(10, digitKoeff);
            digitKoeff++;
            d2.removeFirst();
        }
        return totalResult;
    }

    // Сложите два числа и верните сумму. Одно или два числа должны быть отрицательными
    public Integer sum(Deque<Integer> d3, Deque<Integer> d4){

        if ((d3.getLast() < 0 || d4.getLast() < 0) & (d3.getLast() * d4.getLast() < 0)){
            String maxABSNumber = findBiggestABSNumber(d3, d4);
            if (maxABSNumber == "Модуль ПЕРВОГО числа больше"){
                return sumCalculation(d3, d4);
            }
            else if (maxABSNumber == "Модуль ВТОРОГО числа больше"){
                return sumCalculation(d4, d3);
            }
            else if (maxABSNumber == "Числа РАВНЫ"){
                return 0;
            }
        }
        
        if ((d3.getLast() < 0 || d4.getLast() < 0) & (d3.getLast() * d4.getLast() > 0)){
            ArrayDeque<Integer> result = new ArrayDeque<>();
            int sum = 0;
            while (!d3.isEmpty() || !d4.isEmpty()){
                if (!d3.isEmpty()){
                    sum += Math.abs(d3.pollFirst());
                }
                if (!d4.isEmpty()){
                    sum += Math.abs(d4.pollFirst());
                }
                result.add(sum % 10);
                sum = sum / 10;
            }
            if(sum != 0){
                result.add(sum);
            }
            int res = 0;
            int len = result.size();
            for (int i = 0; i < len; i++) {
                res += result.pollFirst() * Math.pow(10, i);
            }
            return res * (-1);           
        }
        return 0;
    }

    private String findBiggestABSNumber(Deque<Integer> d3, Deque<Integer> d4){
        if (d3.size() > d4.size()){
            return "Модуль ПЕРВОГО числа больше";
        } else if (d4.size() > d3.size()) {
            return "Модуль ВТОРОГО числа больше";
        } else {
            int len = d3.size();
            for (int i=0; i < len; i++) {
                int n1 = d3.getLast();
                int n2 = d4.getLast();
                if (Math.abs(n1) > Math.abs(n2)){
                    return "Модуль ПЕРВОГО числа больше";
                }
                if (Math.abs(n2) > Math.abs(n1)){
                    return "Модуль ВТОРОГО числа больше";
                }
            }
        }
        return "Числа РАВНЫ";
    }

    private Integer sumCalculation(Deque<Integer> dMax, Deque<Integer> dMin){
        
        ArrayDeque<Integer> result = new ArrayDeque<>();
        int temp = 0;
        while(!dMin.isEmpty()){       
            if (Math.abs(dMax.getFirst()) >= Math.abs(dMin.getFirst())){
                result.add(Math.abs(dMax.pollFirst()) - temp - Math.abs(dMin.pollFirst()));
                temp = 0;
            }
            else {
                result.add(Math.abs(dMax.pollFirst()) + 10 - Math.abs(dMin.pollFirst()));
                temp = 1;
            }
        }
        while(!dMax.isEmpty()){
            result.add(Math.abs(dMax.pollFirst()));
        }
        int res = 0;
        int len = result.size();
        for (int i = 0; i < len; i++) {
            res += result.pollFirst() * Math.pow(10, i);
        }
        return res * (-1);
    }
}





