package ru.gb.jseminar;


import java.util.ArrayDeque;

import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Homework hw = new Homework();
        System.out.println(hw.multiple(new ArrayDeque<>(Arrays.asList(5,2)), new ArrayDeque<>(Arrays.asList(4))));
        // result [0,0,1]
       System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(2,5)), new ArrayDeque<>(Arrays.asList(1,6))));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){
        
        Deque<Integer> deque = new ArrayDeque<>();
        int k = 0;
        for (Integer i : d1) {
                int multi = i * d2.getFirst() + k;
                if(multi < 10 ){
                    deque.addLast(multi);
                }else{
                    deque.addLast(multi%10);
                    k = multi/10;
                } 
            } 
        if (k != 0 && deque.size() <= d1.size()+1) deque.addLast(k);
       return deque ;
    }

            
  
    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        Deque<Integer> deque = new ArrayDeque<>();
        int max = d1.size();
        if (max < d2.size()) max = d2.size(); 
        int max1 = max;
        int k = 0;
        int z1 = 1;
        int z2 = 1;
        if (d1.getLast() < 0) z1 = -1;
        if (d2.getLast() < 0) z2 = -1;
        if (z2 == z1){
            while (max > 0){
                if(d1.size() == 0) d1.add(0);
                if(d2.size() == 0) d2.add(0);
                int sum = Math.abs(d1.pollFirst()) + Math.abs(d2.pollFirst()) + k;
                System.out.println(sum);
                if(sum < 10 ){
                    deque.addLast(sum);
                    System.out.println(deque);
                    k = 0;
                    max--;
                }else{
                    deque.addLast(sum%10);
                    System.out.println(deque);
                    k = sum/10;
                    max--;
                }
            }
            if (k != 0 && deque.size() <= max1+1) deque.addFirst(k);
        }else{
            int sum = 0;
            while (max >0){
                if(d1.size() == 0) d1.add(0);
                if(d2.size() == 0) d2.add(0);
                int k1 = Math.abs(d1.pollFirst());
                int k2 = Math.abs(d2.pollFirst());
                
                if(z1<0 && k1<k2 && d1.size()>0){
                    sum = k1*z1-10 +k2*z2;
                    k=1;
                } else if (z1<0 && k1<k2 && d1.size()==0){
                    sum = k1*z1 + k2*z2+k;
                    k=0;
                } else if (z1>0 && k1<k2 && d1.size()>0){
                    sum = k1*z1+10 + k2*z2;
                    k=-1;
                } else if (z1>0 && k1<k2 && d1.size()==0){
                    sum = k1*z1 + k2*z2+k;
                    k=0;
                } else if (z1<0 && k1>k2 && d2.size()==0){
                    sum = k1*z1 + k2*z2+k;
                    k=0;
                } else if (z1<0 && k1>k2 && d2.size()>0){
                    sum = k1*z1 + k2*z2+10;
                    k=-1;
                } else if (z1>0 && k1>k2 && d2.size()==0){
                    sum = k1*z1 + k2*z2+k;
                    k=0;
                } else if (z1>0 && k1>k2 && d2.size()>0){
                    sum = k1*z1 + k2*z2-10;
                    k=1;
                } else if (k1 == k2){
                    sum = k1*z1 + k2*z2+k;
                    k=0;
                }
                deque.addLast(sum);
                max--;
            }
            if (deque.getLast() == 0) deque.pollLast();
        }
        
        
        
        return deque;
    }
}
