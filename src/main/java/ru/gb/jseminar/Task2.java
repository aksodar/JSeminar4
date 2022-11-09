package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Logger;

public class Task2 {

	//Дана строка содержащая только символы '(', ')', '{', '}', '[' и ']', определите,
	// является ли входная строка логически правильной.
	// Входная строка логически правильная, если:
	// 1) Открытые скобки должны быть закрыты скобками того же типа.
	// 2) Открытые скобки должны быть закрыты в правильном порядке. Каждая закрывающая скобка имеет соответствующую
	// открытую скобку того же типа.
	public static void main(String[] args) {
		System.out.print("\033[H\033[2J");	// Очистка консоли (работает в Windows, на остальных системах не проверял)
		System.out.flush();

		String inputStr = "()[{}]{[()]}";

		Logger log = Logger.getLogger(Task2.class.getName());
		Task2 task2 = new Task2();
		
		log.info(String.valueOf(task2.validate(task2.StringToDeque(inputStr))));

	}

	public boolean validate (Deque<String> deque) {
		Deque<String> roundBracket = new ArrayDeque<>();
		Deque<String> curlyBracket = new ArrayDeque<>();
		Deque<String> squareBracket = new ArrayDeque<>();

		if (deque.isEmpty())
			return false;
		while (!deque.isEmpty()) {
			String symbol = deque.pollFirst();
			
			switch (symbol) {
				case "(":
					roundBracket.addLast(symbol);
					break;
				case "{":
					curlyBracket.addLast(symbol);
					break;
				case "[":
					squareBracket.addLast(symbol);
					break;
				case ")":
					if (roundBracket.isEmpty())
						return false;
					else
						roundBracket.removeLast();
					break;
				case "}":
					if (curlyBracket.isEmpty())
						return false;
					else
						curlyBracket.removeLast();
					break;
				case "]":
					if (squareBracket.isEmpty())
						return false;
					else
						squareBracket.removeLast();
					break;
				default:
					return false;
			}
		}
		if (roundBracket.isEmpty() && curlyBracket.isEmpty() && squareBracket.isEmpty())
			return true;
		else
			return false;
	}

	public Deque<String> StringToDeque (String str) {
		Deque<String> result = new ArrayDeque<>();

		for (char item : str.toCharArray()) {
			result.addLast(String.valueOf(item));
		}
		return result;
	}
}
