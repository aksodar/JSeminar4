package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task2Test {
	
	@Test
	void validateSuccessful() {
		Deque<String> inputDeque = new ArrayDeque<>(Arrays.asList("(", ")", "[", "{", "}", "]", "{", "[", "]", "}"));

		boolean expected = true;
		
		boolean actual = (new Task2()).validate(inputDeque);

		Assertions.assertEquals(expected, actual);
	}

	@Test
	void StringToDequeSuccessful() {
		String input = "()[{}]{[]}";

		Deque<String> expectedDeque = new ArrayDeque<>(Arrays.asList("(", ")", "[", "{", "}", "]", "{", "[", "]", "}"));

		Deque<String> actualDeque = (new Task2()).StringToDeque(input);

		Assertions.assertIterableEquals(expectedDeque, actualDeque);
	}
}
