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
		Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(0, 0, 0, 2));
		Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(0, 1, 0, -1));

		Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(0, 9, 9));
		
		Deque<Integer> actualDeque = (new Homework()).sum(inputDeque1, inputDeque2);

		Assertions.assertIterableEquals(expectedDeque, actualDeque);
	}

	@Test
	void positiveSumSuccessful() {
		Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(2, 2, 3));
		Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(8, 1));

		Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(0, 4, 3));

		Deque<Integer> actualDeque = (new Homework()).positiveSum(inputDeque1, inputDeque2);

		Assertions.assertIterableEquals(expectedDeque, actualDeque);
	}

	@Test
	void subtractionSuccessful() {
		Deque<Integer> inputDeque1 = new ArrayDeque<>(Arrays.asList(8, 2, 3));
		Deque<Integer> inputDeque2 = new ArrayDeque<>(Arrays.asList(1, 4, 5));

		Deque<Integer> expectedDeque = new ArrayDeque<>(Arrays.asList(3, 1, -2));

		Deque<Integer> actualDeque = (new Homework()).subtraction(inputDeque1, inputDeque2);

		Assertions.assertIterableEquals(expectedDeque, actualDeque);
	}
}
