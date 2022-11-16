import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.logging.Logger;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Homework hw = new Homework();
        Logger log = Logger.getLogger(Homework.class.getName());
        // result [0,0,1]
        log.info(String.valueOf(hw.multiple(new ArrayDeque<>(Arrays.asList(5,2)), new ArrayDeque<>(Arrays.asList(4)))));
        log.info(String.valueOf(hw.sum(new ArrayDeque<>(Arrays.asList(5,-2)), new ArrayDeque<>(Arrays.asList(5)))));
        // result [0,-2]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> multiple(Deque<Integer> d1, Deque<Integer> d2){
        Integer count = 1;
        boolean flag = true;
        int number_d1 = 0;
        int number_d2 = 0;
        Deque<Integer> sum_num = new ArrayDeque<>();
        for (Integer num: d1){
            number_d1 += num * count;
            count *= 10;
        }
        count = 1;
        for (Integer num: d2){
            number_d2 += num * count;
            count *= 10;
        }
        count = number_d1 * number_d2;
        while(flag){
            if (count <= 0){
                flag = false;
            }else{
                sum_num.add(count % 10);
                count /= 10;}
        }
        return sum_num;
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        Integer count = 1;
        Integer tamp = 1;
        boolean flag = true;
        int number_d1 = 0;
        int number_d2 = 0;
        Deque<Integer> multiple_num = new ArrayDeque<>();
        for (Integer num: d1){
            number_d1 += Math.abs(num) * count;
            if (num < 0){
                number_d1 *= -1;
            }
            count *= 10;
        }
        count = 1;
        for (Integer num: d2){
            number_d2 += num * count;
            if (num < 0){
                number_d1 *= -1;
            }
            count *= 10;
        }
        count = number_d1 + number_d2;
        if(count < 0){
            tamp = -1;
        }
        while(flag){
            if (count == 0){
                multiple_num.addLast(multiple_num.removeLast() * tamp);
                flag = false;
            }else if (count < 0){
                multiple_num.add(Math.abs(count % 10));
                count /= 10;}
        }
        return multiple_num;

    }
}