import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class HomeworkTest {

    @Test
    void multiple() {
        Homework homework = new Homework();
        Deque<Integer> first_input = new ArrayDeque<>(Arrays.asList(1,2));
        Deque<Integer> second_input = new ArrayDeque<>((Arrays.asList(2,4)));
        Deque<Integer> multiple_num = new ArrayDeque<>(Arrays.asList(2,8,8));

        Deque<Integer> actual = homework.multiple(first_input, second_input);

        Assertions.assertEquals(multiple_num, actual);
    }

    @Test
    void sum() {
        Homework homework = new Homework();
        Deque<Integer> first_input = new ArrayDeque<>(Arrays.asList(1,2));
        Deque<Integer> second_input = new ArrayDeque<>((Arrays.asList(2,4)));
        Deque<Integer> sum_num = new ArrayDeque<>(Arrays.asList(3,6));

        Deque<Integer> actual = homework.sum(first_input, second_input);

        Assertions.assertEquals(sum_num, actual);
    }
}