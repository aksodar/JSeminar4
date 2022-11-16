

import java.util.logging.Logger;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class Task1 {

    //Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    // Сложите два числа и верните сумму в виде связанного списка.
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1,2,3));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5,4,7));
        Logger log = Logger.getLogger(Task1.class.getName());
        log.info(String.valueOf(task1.sum(d1, d2)));
        
        
        // result [1,0,6,6]

    }

    public ArrayDeque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2){
        Integer tamp = 0;
        ArrayDeque<Integer> number_new = new ArrayDeque<>();
        boolean flag = true;
        while(flag){
            Integer tamp_one = d1.peek();
            Integer tamp_two = d2.peek();
            if (tamp_one == null && tamp_two == null){
                flag = false;
            }else if(tamp_one == null){;
                Integer sum = tamp_two + tamp;
                number_new.add(sum);
                tamp = 0;
            }
            else if(tamp_two == null){
                tamp_two = 0;
                Integer sum = tamp_one + tamp;
                number_new.add(sum);
                tamp = 0;
            }else{
                Integer sum = tamp_one + tamp_two + tamp;
                if(sum >= 10){
                    number_new.add(sum % 10);
                    tamp += 1;
                }else{
                    number_new.add(sum);
                }
            }
        }
        return number_new;
    }
}
