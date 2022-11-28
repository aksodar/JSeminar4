package ru.gb.jseminar;
import java.util.logging.Logger;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Deque<Integer> d1= new ArrayDeque<>(Arrays.asList(5,2));
        Deque<Integer> d2= new ArrayDeque<>(Arrays.asList(4));
        Homework hw = new Homework();
        Logger log = Logger.getLogger(Homework.class.getName());
        log.info(String.valueOf(hw.multiple(d1, d2)));
        Deque<Integer> d3= new ArrayDeque<>(Arrays.asList(5,-2));
        Deque<Integer> d4= new ArrayDeque<>(Arrays.asList(5));
        log.info((String.valueOf((hw.sum(d3, d4)))));
        // result [0,0,1];
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){
        Deque<Integer> mult = new ArrayDeque<>();
        int number1 = 0;
        int number2 = 0;
        int multNumber = 0;
        while (d1.size() > 0) {
            number1 = number1 * 10 + d1.getLast();
            d1.removeLast();
        }
        while (d2.size() > 0) {
            number2 = number2 * 10 + d2.getLast();
            d2.removeLast();
        }
        multNumber = number1 * number2;
        while (multNumber > 0) {
            mult.addLast(multNumber%10);
            multNumber = multNumber/10;
        }

    return mult;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        Deque<Integer> sum = new ArrayDeque<>();
        int number1 = 0;
        int number2 = 0;
        int temp1 = 0;
        int temp2 = 0;
        int sumnumber = 0;
        if (d1.getLast() < 0 && d2.getLast() <0) {
            temp1 = d1.getLast() * (-1);
            temp2 = d2.getLast() * (-1);
            d1.removeLast(); d1.addLast(temp1);
            d2.removeLast(); d2.addLast(temp2);
            while (d1.size() > 0) {
                number1 = number1 * 10 + d1.getLast();
                d1.removeLast();
            }
            while (d2.size() > 0) {
                number2 = number2 * 10 + d2.getLast();
                d2.removeLast();
            }
            sumnumber = number1 + number2;
            while (sumnumber > 0) {
                sum.addLast(sumnumber%10);
                sumnumber = sumnumber/10;
            }
            temp1 = sum.getLast() * (-1);
            sum.removeLast();
            sum.addLast(temp1);
            
        } else if (d1.getLast() < 0 && d2.getLast() > 0) {
            temp1 = d1.getLast() * (-1);
            d1.removeLast(); d1.addLast(temp1);
            while (d1.size() > 0) {
                number1 = number1 * 10 + d1.getLast();
                d1.removeLast();
            }
            while (d2.size() > 0) {
                number2 = number2 * 10 + d2.getLast();
                d2.removeLast();
            }
            sumnumber = number1 - number2;
            while (sumnumber > 0) {
                sum.addLast(sumnumber%10);
                sumnumber = sumnumber/10;
            }
            temp1 = sum.getLast() * (-1);
            sum.removeLast();
            sum.addLast(temp1);
        } else {
            temp1 = d2.getLast() * (-1);
            d2.removeLast(); d2.addLast(temp1);
            while (d1.size() > 0) {
                number1 = number1 * 10 + d1.getLast();
                d1.removeLast();
            }
            while (d2.size() > 0) {
                number2 = number2 * 10 + d2.getLast();
                d2.removeLast();
            }
            sumnumber = number1 - number2;
            while (sumnumber > 0) {
                sum.addLast(sumnumber%10);
                sumnumber = sumnumber/10;
            }
        }

        return sum;
    }
}
