package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        System.out.printf("result %s\n", multiple(new ArrayDeque<>(Arrays.asList(5, 2)), new ArrayDeque<>(Arrays.asList(4))));
        // result [0,0,1]
        System.out.printf("result %s\n",sum(new ArrayDeque<>(Arrays.asList(5, -2)), new ArrayDeque<>(Arrays.asList(5))));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public static Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2) {

        Boolean valueSign = true;

        if (!checkDeque(d1))
            d1.offerLast(-d1.pollLast());

        if (!checkDeque(d2))
            d2.offerLast(-d2.pollLast());

        valueSign = !((!checkDeque(d1) && checkDeque(d2)) || (checkDeque(d1) && !checkDeque(d2)));

        Deque<Integer> res = new ArrayDeque<Integer>();
        Deque<Integer> d = new ArrayDeque<>(d1);

        while (d.size() > 0) {
            Deque<Integer> temp = getMult(d.pollLast(), d2);

            try {
                res = res.size() > 0 ? sum(getMult(10, res), temp) : temp;
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        if (!valueSign)
            res.offerLast(-res.pollLast());

        return res;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public static Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        Boolean validDeques = checkDeque(d1) && checkDeque(d2);

        if (!validDeques) {
            d1.offerLast(-d1.pollLast());
            d2.offerLast(-d2.pollLast());
        }
        try {
            Deque<Integer> res = getSumDeque(d1, d2);

            if (!validDeques)
                res.offerLast(-res.pollLast());

            return res;
        } catch (Exception e) {
            System.out.println(e);
        }

        if (checkDeque(d1)) {
            d2.offerLast(-d2.pollLast());

            if (checkDequeMoreValues(d1, d2)) {
                return getNonZero(getSumDeque(d1, d2));
            } else {
                Deque<Integer> nonZero=getNonZero(getDiffDeque(d2, d1)); 
                nonZero.offerLast(-nonZero.pollLast());
               return nonZero;
            }
        }
        d1.offerLast(-d1.pollLast());
        
        if(!checkDequeMoreValues(d2, d1)){
            Deque<Integer> summ =getSumDeque(d1, d2);
            summ.offerLast(-summ.pollLast());

            return summ;
        }
        Deque<Integer> diff =getDiffDeque(d2, d1);
        return  diff;
    }

    public static boolean checkDeque(Deque<Integer> d) {
        return d == null || d.size() == 0 || d.peekLast() >= 0;
    }

    public static boolean checkDequeMoreValues(Deque<Integer> d1, Deque<Integer> d2) {
        return getValues(d1) > getValues(d2);
    }

    public static Deque<Integer> getSumDeque(Deque<Integer> d1, Deque<Integer> d2) {
        if (d1 == null || d1.size() == 0 || d2 == null || d2.size() == 0) {
            return new ArrayDeque<Integer>();
        }

        ArrayDeque<Integer> result = new ArrayDeque<Integer>();
        int tmp = 0;
        int summ = 0;

        while (d1.size() > 0 || d2.size() > 0) {
            summ = 0;
            if (d1.size() > 0)
                summ = d1.poll();
            ;
            if (d2.size() > 0)
                summ += d2.poll();

            result.add((summ + tmp) % 10);

            tmp = summ / 10;
        }
        if (tmp > 0)
            result.add(tmp);

        return result;
    }

    public static Deque<Integer> getDiffDeque(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> result = new ArrayDeque<Integer>();
        int tmp = 0;
        int summ = 0;

        while (d1.size() > 0) {
            summ = tmp;
            summ = summ + d1.poll();

            if (d2.size() > 0)
                summ = summ - d2.poll();

            if (summ < 0) {
                summ = summ + 10;
                tmp = -1;
            }

            result.add(summ);
        }
        return result;
    }

    public static Deque<Integer> getMult(int num, Deque<Integer> d) {
        Deque<Integer> res = new ArrayDeque<Integer>();
        Deque<Integer> mult = new ArrayDeque<>(d);

        int tmp = 0;

        while (mult.size() > 0) {
            int multValue = mult.pollFirst() * num + tmp;

            res.add(multValue % 10);

            tmp = multValue / 10;
        }

        if (tmp > 0)
            res.add(tmp);

        return res;
    }

    public static int getValues(Deque<Integer> c) {
        Deque<Integer> d = new ArrayDeque<>(c);
        int res = 0;

        while (d.size() > 0) {
            res = d.pollLast() + res * 10;
        }

        return res;
    }

    public static Deque<Integer> getNonZero(Deque<Integer> d) {
        while (d.size() > 1) {
            if (d.peekLast() != 0)
                break;

            d.pollLast();
        }
        return d;
    }
}