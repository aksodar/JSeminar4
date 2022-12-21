package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class HomeworkTest {

    public static void main(String[] args) throws Exception {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(3,5));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(4));
        // result [6,6,0,1]
        HomeworkTest sq = new HomeworkTest();
        System.out.println("Summa " + sq.sum(d1, d2).toString());
    }

    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null)
        {
            throw new Exception("Данные пустые");
        }
        Deque <Integer> result = new ArrayDeque<>();
        int doz = 1;
        int sum = 1;
        while (d1.size() > 0 || d2.size() > 0)
        {


            if (d1.size() > 0){
                sum *= d1.pollFirst();
            }
            if (d2.size() > 0){
                sum *= d2.peek();
            }
            if (sum >= 10){
                sum = sum % 10;
                doz = 1;
            }
            result.offer(sum);
        }
        if (doz != 1){
            result.offer(doz);
        }
        return result;
    }
}
