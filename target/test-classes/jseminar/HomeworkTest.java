package jseminar;

import java.util.Deque;

import org.junut.jupiter.api.Test;

import ru.gb.jseminar.Homework;

import static org.junut.jupiter.api.Assertions.*;


class HomeworkTest {
    
    @Test
    void multipleSuccessful (){
    
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(5,2));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(4));
        Deque<Integer>  expected = Arrays.asList(0,0,1);

        Homework homework = new Homework();
        Deque<Integer> actual = homework.multiple(d1, d2);

        Assertions.assertEquals(expect, actual);
    }

    void sumSuccessful (){
    
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(5,-2));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5));
        Deque<Integer>  expected = Arrays.asList(0,-2);

        Homework homework = new Homework();
        Deque<Integer> actual = homework.sum(d1, d2);

        Assertions.assertEquals(expect, actual);
    }
    
}
