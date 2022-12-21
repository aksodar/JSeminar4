package JSeminar_4.src.main.java.ru.gb.jseminar;
import java.util.*;

public class Task0 {
    // Дан Deque состоящий из последовательности цифр
    // Необходимо проверить, что последовательность цифр является полиндромом.
    public static void main(String[] args) throws Exception {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1,2,3,2,1));
        Task0 polindrom = new Task0();
        System.out.println(polindrom.checkOn(deque)); 
    }

    public boolean checkOn(Deque<Integer> deque) throws Exception {
        if(deque == null || deque.size() == 0){
            System.out.println("");
            throw new Exception("Коллекция пустая");
        }
        while(deque.size()>1){
            if(!deque.pollFirst().equals(deque.pollLast())){
                return false;
            }            
        }
        return true;
    }
}
