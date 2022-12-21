package JSeminar_4.src.main.java.ru.gb.jseminar;

import java.util.*;

public class Task1 {

    // Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся
    // в обратном порядке
    // и каждый из их узлов содержит одну цифру.
    // Сложите два числа и верните сумму в виде связанного списка.
    public static void main(String[] args) throws Exception {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1, 5, 2, 3));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5, 4, 7, 7));
        Task1 sq = new Task1();
        System.out.println("Сумма = " + sq.sum(d1, d2).toString());
    }

    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
        if (d1 == null || d2 == null) {
            throw new Exception("Входные данные не заданы");
        }
        Deque<Integer> result = new ArrayDeque<>();
        int doz = 0;
        while (d1.size() > 0 || d2.size() > 0) {
            int sum = doz;
            doz = 0;
            if (d1.size() > 0) {
                sum += d1.pollFirst();
            }
            if (d2.size() > 0) {
                sum += d2.pollFirst();
            }
            if (sum >= 10) {
                sum = sum - 10;
                doz = 1;
            }
            result.offer(sum);
        }
        if (doz != 0) {
            result.offer(doz);
        }
        return result;
    }
}
