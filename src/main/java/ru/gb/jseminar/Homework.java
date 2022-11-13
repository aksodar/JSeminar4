package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.swing.text.MutableAttributeSet;

public class Homework {

    // Даны два Deque представляющие два целых числа. Цифры хранятся в обратном
    // порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Deque<Integer> deque1 = new ArrayDeque<>(Arrays.asList(5, 2, 1));
        Deque<Integer> deque2 = new ArrayDeque<>(Arrays.asList(2, 2));
        Deque<Integer> deque3 = new ArrayDeque<>(Arrays.asList(5, -2));
        Deque<Integer> deque4 = new ArrayDeque<>(Arrays.asList(-4));
        Homework hw = new Homework();
        Logger log = Logger.getLogger(Task0.class.getName());
        log.info(String.valueOf(hw.multiple(deque1, deque2)));
        log.info(String.valueOf(hw.sum(deque3, deque4)));
    }

    // Умножьте два числа и верните произведение в виде связанного списка.

    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) {
        ArrayDeque<Integer> array = new ArrayDeque<>();
        int firstNumber, secondNumber, multiplFirstSecondNumbers;
        firstNumber = 0;
        secondNumber = 0;
        for (int i = 0; i < d1.size() + i; i++) {
            firstNumber += d1.pollFirst() * Math.pow(10, i);
            // System.out.println(firstNumber);
        }
        for (int i = 0; i < d2.size() + i; i++) {
            secondNumber += d2.pollFirst() * Math.pow(10, i);
            // System.out.println(secondNumber);
        }
        multiplFirstSecondNumbers = firstNumber * secondNumber;
        // System.out.println(multiplFirstSecondNumbers);
        while (multiplFirstSecondNumbers / 10 != 0) {
            array.add(multiplFirstSecondNumbers % 10);
            multiplFirstSecondNumbers /= 10;
        }
        array.add(multiplFirstSecondNumbers);
        return array;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два
    // числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        ArrayDeque<Integer> array = new ArrayDeque<>();
        int firstNumber, secondNumber, negativeSign, sum;
        firstNumber = 0;
        secondNumber = 0;
        negativeSign = -1;
        for (int i = 0; i < d1.size() + i; i++) {
            if (d1.getLast() < 0) {
                negativeSign = -1;
            } else {
                negativeSign = 1;
            }
            firstNumber += Math.abs(d1.pollFirst()) * Math.pow(10, i);
        }
        firstNumber *= negativeSign;
        // System.out.println(firstNumber);
        for (int i = 0; i < d2.size() + i; i++) {
            if (d2.getLast() < 0) {
                negativeSign = -1;
            } else {
                negativeSign = 1;
            }
            secondNumber += Math.abs(d2.pollFirst()) * Math.pow(10, i);
        }
        secondNumber *= negativeSign;
        // System.out.println(secondNumber);
        sum = firstNumber + secondNumber;
        while (sum / 10 != 0) {
            array.add(Math.abs(sum % 10));
            sum /= 10;
        }
        array.add(sum);
        return array;
    }
}
