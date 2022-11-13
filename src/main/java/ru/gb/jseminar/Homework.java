package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.logging.Logger;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Deque<Integer>d1 = new ArrayDeque<>(Arrays.asList(5,2));
        Deque<Integer>d2 = new ArrayDeque<>(Arrays.asList(5,2));
        Homework homework = new Homework();
        Logger log = Logger.getLogger(Homework.class.getName());
        log.info(String.valueOf(homework.multiple(d1,d2)));
        //log.info(String.valueOf(homework.sum(d1,d2)));

    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){
        ArrayDeque<Integer> result = new ArrayDeque<>();
        ArrayDeque<Integer> result2 = new ArrayDeque<>();
        ArrayDeque<Integer> result3 = new ArrayDeque<>();
        ArrayDeque<Integer> result4 = new ArrayDeque<>();
        int sum=0;
        int mult=0;
        int i=0;
        int j=0;
        for (int item:d2) {
            for (int item2:d1) {
                sum = item * item2 + mult;
                if (sum < 10) {
                    result.add(sum);
                    mult = 0;
                } else {
                    result.add(sum % 10);
                    mult = sum / 10;
                }
            }
            if(mult!=0){
                result.add(mult);
                mult=0;
            }
            if (i!=0){
                for (int item4:result2) {
                    if (i<=j){
                    }else {
                        result3.add(result2.remove());
                    }
                    j++;
                }
            }else{
                if(d2.size()==1){
                    return result;
                }else {
                    for (int item3 : result) {
                        result2.add(result.remove());
                    }
                }
            }
            i++;
            if(i>=2){
                int sum1 = 0;
                while (!result2.isEmpty() || !result.isEmpty()) {
                    if (!result2.isEmpty()) {
                        sum1 += result2.pollFirst();
                    }
                    if (!result.isEmpty()) {
                        sum1 += result.pollFirst();
                    }
                    if (sum1 > 9) {
                        result4.add(sum1 % 10);
                        sum1 = 1;
                    } else {
                        result4.add(sum1);
                        sum1 = 0;
                    }
                }
                if (sum1 != 0) {
                    result4.add(sum1);
                }
                result4.addFirst(result3.pollFirst());
                for (int item5:result4) {
                    result2.add(result4.remove());
                }
            }
        }
        return result2;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        ArrayDeque<Integer> result = new ArrayDeque<>();
        int sum = 0;
        int dif = 0;
        if (d1.getLast() > 0 & d2.getLast() > 0) {
            while (!d1.isEmpty() || !d2.isEmpty()) {
                if (!d1.isEmpty()) {
                    sum += d1.pollFirst();
                }
                if (!d2.isEmpty()) {
                    sum += d2.pollFirst();
                }
                if (sum > 9) {
                    result.add(sum % 10);
                    sum = 1;
                } else {
                    result.add(sum);
                    sum = 0;
                }
            }
            if (sum != 0) {
                result.add(sum);
            }
            return result;
        }
        if (d1.getLast() < 0 & d2.getLast() < 0){
            int n1=d1.pollLast();
            d1.addLast(n1*-1);
            int n2=d2.pollLast();
            d2.addLast(n2*-1);
            while (!d1.isEmpty() || !d2.isEmpty()) {
                if (!d1.isEmpty()) {
                    sum += d1.pollFirst();
                }
                if (!d2.isEmpty()) {
                    sum += d2.pollFirst();
                }
                if (sum > 9) {
                    result.add(sum % 10);
                    sum = 1;
                } else {
                    result.add(sum);
                    sum = 0;
                }
            }
            if (sum != 0) {
                result.add(sum);
            }
            int n3=result.pollLast();
            result.addLast(n3*-1);
            return result;
        }
        if (d1.getLast() < 0 || d2.getLast() < 0){
            boolean positive = false;
            if(d1.getLast() < 0){
                int n1= d1.pollLast()*-1;
                d1.addLast(n1);
                positive=true;

            }else{
                int n2= d2.pollLast()*-1;
                d2.addLast(n2);
            }
            while (!d1.isEmpty() || !d2.isEmpty()) {
                if(!d1.isEmpty()){
                    sum=d1.pollFirst()-dif;
                    dif=0;
                }
                if(!d2.isEmpty()){
                    if (d2.getFirst()<=sum){
                        result.add(sum-d2.pollFirst());
                    }else {
                        result.add(sum+10-d2.pollFirst());
                        dif=1;
                    }
                }
            }
            if(result.getLast()==0){
                result.pollLast();
            }
            if(positive){
                int n3= result.pollLast()*-1;
                result.addLast(n3);
            }
            return result;
        }
        return result;
    }
}
