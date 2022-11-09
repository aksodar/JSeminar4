package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HomeworkTest {
	
	@Test
	void multipleSuccessful() {
		Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(2, 1));
		Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(2, 1));

		Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(4, 4, 1));
		
		Deque<Integer> actualDeque = (new Homework()).multiple(inputDeque1, inputDeque2);

		Assertions.assertIterableEquals(expectedDeque, actualDeque);
	}

	@Test
	void sumSuccessful() {
		Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(2, -1));
		Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(4, 2));

		Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(2, 1));
		
		Deque<Integer> actualDeque = (new Homework()).sum(inputDeque1, inputDeque2);

		Assertions.assertIterableEquals(expectedDeque, actualDeque);
	}
	
	@Test
	void DequeToIntSuccessful() {
		Deque<Integer> inputDeque = new ArrayDeque<>(Arrays.asList(2, -1));

		int expected = -12;

		int actual = (new Homework()).DequeToInt(inputDeque);

		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void IntToDequeSuccessful() {
		int input = -203;

		Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(3, 0, -2));

		Deque<Integer> actualDeque = (new Homework()).IntToDeque(input);

		Assertions.assertIterableEquals(expectedDeque, actualDeque);
	}
}
