package ru.gb.jseminar;

import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Homework {

    //Даны два Deque представляющие два целых числа.
    //Цифры хранятся в обратном порядке,
    //и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Homework hw = new Homework();
        System.out.println(hw.multiple(new ArrayDeque<>(Arrays.asList(5,2)), new ArrayDeque<>(Arrays.asList(4))));
        // result [0,0,1]
        System.out.println(hw.sum(new ArrayDeque<>(Arrays.asList(5,2-)), new ArrayDeque<>(Arrays.asList(5))));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){
        // "Этот метод реализовал с помощью реплейсов
        StringBuilder firstValue = new StringBuilder(d1.toString().replace("[", "").replace("]", "").replace(", ", ""));
        StringBuilder secondValue = new StringBuilder(d2.toString().replace("[", "").replace("]", "").replace(", ", ""));

        Integer result = Integer.valueOf(firstValue.reverse().toString()) * Integer.valueOf(secondValue.reverse().toString());
        String stringResult = new String(result.toString());
        Deque<Integer> list = new LinkedList<Integer>();
        for (char ch: stringResult.toCharArray()){
            int number = Character.getNumericValue(ch);
            list.push(number);
        }
        
        return list;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        Deque<Integer> result = new LinkedList<Integer>();
        int maxLength = d1.size();

        if (d1.size() < d2.size()){
            maxLength = d2.size();
        }

        StringBuilder firstValue = new StringBuilder();
        StringBuilder secondValue = new StringBuilder();

        for (int i=0; i < maxLength; i++){
            try{
                if (d1.getLast() != null){
                    firstValue.append(d1.pollLast());
                }
            }
            catch (java.util.NoSuchElementException e){
                ;
            }
            try{
                if (d2.getLast() != null){
                    secondValue.append(d2.pollLast());
                }
            }
            catch (java.util.NoSuchElementException e){
                ;
            }
        }

        Integer sumValue = Integer.parseInt(firstValue.toString()) + Integer.parseInt(secondValue.toString());
        StringBuilder resultString = new StringBuilder(sumValue.toString());
        for (char ch: resultString.toString().toCharArray()){
            int number = Character.getNumericValue(ch);
            result.push(number);
        }

        System.out.println(resultString);        
        return result;
    }
}

