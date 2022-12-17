package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке, 
    // отрицательное число в последнем элементе содержит знак "-"
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) throws Exception {
        Homework hw = new Homework();
        System.out.println(hw.multiple(new ArrayDeque<>(Arrays.asList(5,2)), new ArrayDeque<>(Arrays.asList(4))));
        // result [0,0,1]
        System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5))));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) throws Exception{
        // устанавливаем знак результата, меняем знак множителей
        // цикл по элементам д1, умножаем д2 на элемент д1:
        // цикл по элементам д2, умножаем элемент д2 на д1, суммируем с сохраненным с пред операции числом 
        // единицы пишем, десятки запоминаем.   
        int sign = 1;
        if (!checkSign(d1)){
            d1 = changeSign(d1);
            if (checkSign(d2)) // д1 отр, д2 полож
                sign = -1;
            else
                d2 = changeSign(d2);    
            } 
        else
            if (!checkSign(d2)){
                sign = -1;
                d2 = changeSign(d2);
            }
        Deque<Integer> result = new ArrayDeque<Integer>();    
        Deque<Integer> mul1 = new ArrayDeque<>(d1);
        while (mul1.size()>0){
            Deque<Integer> temp = mulNumber(mul1.pollLast(), d2); 
            if (result.size() > 0){
                result = sum(mulNumber(10,result), temp);}
            else
                result = temp;     
            }
        if (sign == -1) changeSign(result);
        return result;
    }



    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2)throws Exception {
        if (checkSign(d1) && checkSign(d2)){
            return sumPositive(d1, d2);}
        if (!checkSign(d1) && !checkSign(d2)){  
                d1 = changeSign(d1);
                d2 = changeSign(d2);
                return changeSign(sumPositive(d1, d2));
            }
        if (checkSign(d1)){    
            d2 = changeSign(d2);
            if (IsFirstMore(d1, d2)){
                return remNonmeanZeros(difPositive(d1, d2));
            }
            else{
                return changeSign(remNonmeanZeros(difPositive(d2, d1)));
            }    
        }            
        
        d1 = changeSign(d1);    
        if (IsFirstMore(d2, d1))
            return difPositive(d2, d1);
        else
            return changeSign(difPositive(d1, d2));
    }

    public Deque<Integer> mulNumber(int num, Deque<Integer> queue){
        Deque<Integer> result = new ArrayDeque<Integer>();
        Deque<Integer> mult = new ArrayDeque<>(queue);
        int memo = 0;
        while (mult.size()>0){
            int temp = mult.pollFirst()*num + memo;
            result.add(temp % 10);
            memo = temp / 10;
        }
        if (memo > 0)
            result.add(memo);
        return result;
    }
    
    public Deque<Integer> sumPositive(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null)
            throw new Exception("null вместо числа"); 
        ArrayDeque<Integer> result = new ArrayDeque<Integer>();
        int memo = 0;
        int summ = 0;
            while (d1.size() > 0 || d2.size() > 0){
                summ = 0;
                if (d1.size() > 0)
                    summ = d1.poll();;
                if (d2.size() > 0)
                    summ += d2.poll();    
                result.add((summ + memo) % 10);
                memo = summ / 10;

        }
        if (memo > 0) result.add(memo);

        return result;
    }

    public Deque<Integer> difPositive(Deque<Integer> d1, Deque<Integer> d2){
        Deque<Integer> result = new ArrayDeque<Integer>();
        int memo = 0;
        int summ = 0;
            while (d1.size() > 0){
                summ = memo;
                    summ = summ + d1.poll();
                if (d2.size() > 0)
                    summ = summ - d2.poll();                     
                if (summ < 0){
                    summ = summ + 10;
                    memo = -1;
                }      
                result.add(summ);

        }
        return result;
    }

    public boolean checkSign(Deque<Integer> d) throws Exception{
        if (d == null)
            throw new Exception("пустой элемент");
        return d.peekLast() >= 0;
}

    public Deque<Integer> changeSign(Deque<Integer> d){
       
        d.offerLast(-d.pollLast());
        
       
        return d;
    }

    public boolean IsFirstMore(Deque<Integer> d1, Deque<Integer> d2){
         return getNumber(d1) > getNumber(d2);        
    }

    public int getNumber(Deque<Integer> c){
      int res = 0;
      Deque<Integer> d = new ArrayDeque<>(c);
        while (d.size()>0){
            res = d.pollLast()+ res*10;
        }
        return res;
    }

    public Deque<Integer> remNonmeanZeros(Deque<Integer> d)
    {
        while (d.size()>1){
            if (d.peekLast() == 0)
                d.pollLast();
            else              
                break;      
        }
        return d;
    }
}    