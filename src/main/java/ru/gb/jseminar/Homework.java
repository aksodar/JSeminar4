// Задачу с умножением решил без перевода очередей в числа

// Задачу со сложением отрицательных чисел решал путём конвертации исходных
// очередей в числа, последующим сложением и разбиением полученного числа в очередь

package ru.gb.jseminar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.logging.Logger;

public class Homework {

	//Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
	// и каждый из их узлов содержит одну цифру.
	public static void main (String[] args) {
		System.out.print("\033[H\033[2J");	// Очистка консоли (работает в Windows, на остальных системах не проверял)
		System.out.flush();

		Deque<Integer> d1_1 = new ArrayDeque<>(Arrays.asList(6, 8, 5, 7, 9));
		Deque<Integer> d2_1 = new ArrayDeque<>(Arrays.asList(2, 8, 3));

		Deque<Integer> d1_2 = new ArrayDeque<>(Arrays.asList(0, 0, 0, 2));
		Deque<Integer> d2_2 = new ArrayDeque<>(Arrays.asList(0, 1, 0, -1));

		// Deque<Integer> d1 = new ArrayDeque<>();
		Logger log = Logger.getLogger(Homework.class.getName());
		Homework homework = new Homework();

		log.info(String.valueOf(homework.multiple(d1_1, d2_1)));
		log.info(String.valueOf(homework.sum(d1_2, d2_2)));
	}

	// Умножьте два числа и верните произведение в виде связанного списка.
	public Deque<Integer> multiple (Deque<Integer> d1, Deque<Integer> d2) {
		int sum = 0;
		int mul = 0;
		boolean flagFirstCycle = true;
		boolean flagFirstStep = true;
		Deque<Integer> tmp = new ArrayDeque<>();
		Deque<Integer> result = new ArrayDeque<>();

		while (!d1.isEmpty()) {
			int d1Number = d1.pollFirst();
			if (flagFirstCycle) {
				flagFirstCycle = false;
				for (int d2Number : d2) {
					mul = d1Number * d2Number;
					if (flagFirstStep) {
						flagFirstStep = false;
						result.addLast(mul % 10);
						sum += mul;
					} else {
						sum += mul;
						tmp.addLast(sum % 10);
					}
					sum /= 10;
				}
				if (sum != 0)	tmp.addLast(sum);
				sum = 0;
				flagFirstStep = true;
			} else {
				for (int d2Number : d2) {
					mul = d1Number * d2Number;

					if (!tmp.isEmpty())	sum += mul + tmp.pollFirst();
					else				sum += mul;

					if (flagFirstStep) {
						flagFirstStep = false;
						result.addLast(sum % 10);
					} else {
						tmp.addLast(sum % 10);
					}
					sum /= 10;
				}
				if (sum != 0)	tmp.addLast(sum);
				sum = 0;
				flagFirstStep = true;
			}
		}
		while (!tmp.isEmpty())	result.addLast(tmp.pollFirst());
		return result;
	}

	// Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
	public Deque<Integer> sum (Deque<Integer> d1, Deque<Integer> d2) {
		Deque<Integer> result = new ArrayDeque<>();

		if (d1.isEmpty() && d2.isEmpty())	return result;
		if (d1.isEmpty())					return d2;
		if (d2.isEmpty())					return d1;
		return IntToDeque(DequeToInt(d1) + DequeToInt(d2));
	}

	public Integer DequeToInt (Deque<Integer> d) {
		int result;
		
		if (d.isEmpty())	return 0;

		if (d.getLast() >=0) {
			result = d.pollFirst();
			int power = 1;
			while (!d.isEmpty()) {
				result += d.pollFirst() * Math.pow(10, power);
				power ++;
			}
		} else {
			result = Math.abs(d.pollFirst());
			int power = 1;
			while (!d.isEmpty()) {
				result += Math.abs(d.pollFirst()) * Math.pow(10, power);
				power ++;
			}
			result = -result;
		}
		return result;
	}

	public Deque<Integer> IntToDeque (int number) {
		Deque<Integer> result = new ArrayDeque<>();
		if (number < 0) {
			number = -number;
			while (number != 0) {
				result.addLast(number % 10);
				number /= 10;
			}
			int tmp = result.pollLast();
			result.addLast(-tmp);
		} else {
			while (number != 0) {
				result.addLast(number % 10);
				number /= 10;
			}
		}
		return result;
	}
}
