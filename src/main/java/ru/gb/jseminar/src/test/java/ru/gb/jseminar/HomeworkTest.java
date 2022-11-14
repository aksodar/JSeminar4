package ru.gb.jseminar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class HomeworkTest {

   @Test
     void MultipleSuccessful() {
         Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(5, 2));
         Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(4));

         Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(0, 0, 1));

         Deque<Integer> actualDeque = (new Homework()).multiple(inputDeque1, inputDeque2);

         Assertions.assertIterableEquals(expectedDeque, actualDeque);
     }
     @Test
     void MultipleSuccessful1() {
         Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(6, 2));
         Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(3, 1));

         Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(8,3,3));

         Deque<Integer> actualDeque = (new Homework()).multiple(inputDeque1, inputDeque2);

         Assertions.assertIterableEquals(expectedDeque, actualDeque);
     }
     @Test
     void sumSuccessful() {
         Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(5, -2));
         Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(5));

         Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(0, -2));

         Deque<Integer> actualDeque = (new Homework()).sum(inputDeque1, inputDeque2);

         Assertions.assertIterableEquals(expectedDeque, actualDeque);
     }

     @Test
     void sumSuccessful1() {
         Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(1, 3, 2, -1));
         Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(4, 2, 9, 1));

         Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(3,9,6));

         Deque<Integer> actualDeque = (new Homework()).sum(inputDeque1, inputDeque2);

         Assertions.assertIterableEquals(expectedDeque, actualDeque);
     }
    
}
