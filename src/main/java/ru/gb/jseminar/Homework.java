package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.logging.Logger;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Homework task = new Homework();
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(5,2,9));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(6,2));
        // result [0,0,1]
        Logger log = Logger.getLogger(Homework.class.getName());
        log.info(String.valueOf(task.multiple(d1,d2)));
        log.info(String.valueOf(task.sum(d1,d2)));
        

    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){
        Deque<Integer> res = new ArrayDeque<>(Arrays.asList());
        Deque<Integer> res1 = new ArrayDeque<>(Arrays.asList());
        Deque<Integer> res2 = new ArrayDeque<>(Arrays.asList());
        int d=0;
        int temp=0;
        int count=0;
        while (d2.size()>0){
            for (int i=1; i<=count; i++){                
                res1.addLast(0);
            }
           res=new ArrayDeque<>(Arrays.asList());
           for (int item : d1) {
                d=item*d2.getFirst()+temp;
                if (d>9){
                    temp=d/10;
                    d=d%10;                              
                }else {
                    temp=0;
                }
                res2.add(d);
            }
            if (temp!=0){
                res2.add(temp);            
            }
            
            d2.removeFirst();
            temp=0;
            if (res1.size()>0) {
                while (res2.size()>0){
                d=res2.pollFirst()+res1.pollFirst()+temp;
                if (d>9){
                    temp=d/10;
                    d=d%10;                              
                }else {
                    temp=0;
                }
                res.add(d);
                }
            }
            else {
                res=res2;
            }
            if (temp!=0){
                res.add(temp);            
            }
                     
            res1=res;
            
            res2=new ArrayDeque<>(Arrays.asList());
            temp=0;
            count+=1;
            for (int i=1; i<=count; i++){
                res2.addFirst(0);                
            }
        }
        return res;
    }
        
    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        Deque<Integer> res = new ArrayDeque<>(Arrays.asList());
        int d=0;
        int temp=0;
        int z=0;
        if ((d1.getLast()<0 && d2.getLast()<0)){             
            while (d1.size()>0 || d2.size()>0){
                d=0;
                if (d1.size()>0){
                    d+=Math.abs(d1.pollFirst());
                }
                if (d2.size()>0){
                    d+=Math.abs(d2.pollFirst());
                }        
                d+=temp;
                if (d>=10){
                    d=d%10;
                    temp=1;                
                }else {
                    temp=0;
                }            
                res.add(d);                                      
            }
            if (temp==1){ 
                res.add(-1);
            }
            else{
                res.removeLast();
                res.addLast(-d);
            }          
        }
        else{            
            if(d1.getLast()<0){
                z=1;
            }
            while (d1.size()>0 || d2.size()>0){
                d=0;
                if (d1.size()>0){
                    d+=Math.abs(d1.pollFirst());
                }
                d+=temp;
                if (d2.size()>0){
                    d-=Math.abs(d2.pollFirst());
                }                
                if (d<0){
                    d=10+d;
                    temp=-1;                
                }else {
                    temp=0;
                }            
                res.add(d);                                      
            }
            if(z==1){
                res.removeLast();
                res.add(-d);
            }             
        }        
        return res;
    }
    
}
