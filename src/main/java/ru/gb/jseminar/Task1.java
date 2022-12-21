package Homework.homework4.JSeminar_4.src.main.java.ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Task1 {

    //Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    // Сложите два числа и верните сумму в виде связанного списка.
    public static void main(String[] args) throws Exception {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1,2,3));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5));
        // result [6,6,0,1]
        Task1 test = new Task1();
        System.out.println("Summa = " + test.sum(d1, d2).toString());

    }


    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1.size() == 0 && d2.size()==0){
            throw new Exception("both data are empty");
        }
        Deque result = new ArrayDeque<>();
        int doz = 0;
        while (d1.size()>0 || d2.size()>0){
            int summa = doz;
            doz = 0;
            if (d1.size()>0){
                summa = summa + d1.poll();
            }
            if (d2.size()>0){
                summa = summa + d2.poll();
            }
            if (summa >= 10){
                summa = summa - 10;
                doz = 1;
            }
            result.offer(summa);
        }
        if (doz>0){
            result.offer(doz);
        }
        return result;
    }
}
