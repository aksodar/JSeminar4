package ru.gb.jseminar;

import java.lang.foreign.MemoryLayout.PathElement;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import javax.print.attribute.standard.Sides;

public class Homework {


// !!! 
// умножение работает только при условии что второй дек из одного элемента
// вычитание работает не совсем корректно



    //Даны два Deque представляющие два целых числа. 
    //Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        System.out.println(hw.multiple(new ArrayDeque<>(Arrays.asList(9,9)), new ArrayDeque<>(Arrays.asList(9))));
        // result [0,0,0]
        System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5))));
        // result [0,-2]
    } 

    // Умножьте два числа и верните произведение в виде связанного списка. 
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception{
        if (d1 == null || d2 == null) {
            throw new Exception("Входные данный не заданы");
        }

        Deque<Integer> result = new ArrayDeque<>(Arrays.asList(0));
        
        int y = d2.pollFirst();
        
        while (d1.size() > 0){
            
            int x = d1.pollFirst();
                    
            if (x * y > 9){
                
                int z = result.peekLast();
                z = z + (x*y)%10;
                
                if (z > 9){

                    result.pollLast();
                    result.addLast(z-10);
                    result.addLast(1);

                }
                else{
                    result.pollLast();
                    result.addLast(z);

                }
                result.addLast((x*y)/10);
            }
            else{
                int z = result.peekLast();
                z = z + x*y;
                if (z > 9){

                    result.pollLast();
                    result.addLast(z-10);
                    result.addLast(1);

                }
                else{
                    result.pollLast();
                    result.addLast(z);

                }   
                result.addLast(0);
            }
        }   
        return result;
        }
        

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception{
        if (d1 == null || d2 == null || (d1.peekLast() > 0 && d2.peekLast() > 0)) {
            throw new Exception("Входные данный не верны");
        }
        Deque<Integer> result = new ArrayDeque<>();
        if (d1.peekLast() < 0 && d2.peekLast() < 0){
            d1.addLast(d1.pollLast()*(-1));
            d2.addLast(d2.pollLast()*(-1));
            return summ(d1, d2);
        }
        else {
            while(d2.size() > 0){
                if (abs(d1.peekFirst()) >= abs(d2.peekFirst())){
                    result.add(abs(d1.pollFirst()) - abs(d2.pollFirst()));
                    }
                else{
                    result.add((abs(d1.pollFirst())+10)-abs(d2.pollFirst()));
                    d1.addFirst(abs(d1.pollFirst())-1);
                    }
                }
            while(d1.size() > 0){
                result.add(d1.pollFirst());
            }

        }
            return result;
        
    }
  
    private Integer abs(Integer peekFirst) {
        if (peekFirst<0){
            peekFirst = peekFirst*(-1);
        }
        return peekFirst;
    }

    public Deque<Integer> summ(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("Входные данный не заданы");
        }
        int ten = 0;
        Deque<Integer> result = new ArrayDeque<>();
        while (d1.size() > 0 || d2.size() > 0){
             int sum = ten;
             ten = 0;
             if (d1.size() > 0) {
                sum += d1.pollFirst();
             }
             if (d2.size() > 0) {
                sum += d2.pollFirst();
             }
             if (sum > 9){
                sum = sum - 10;
                ten = 1;
              }  
            result.offer(sum);
        }
        if (ten != 0) {
            result.offer(ten);
        }
        result.addLast(result.pollLast()*(-1));
        return result;
    }
}