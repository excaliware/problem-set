package problemset;

import problemset.datastructures.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemSet {

	public static void main(String[] argv) throws Exception {

//		new Chart();
//		new Coins();
//		new Pennies();
//		new CreditCard();
//		new LeapYear();
//		new BodyMassIndex();
//		new TemperatureConverter();
//		new FizzBuzz();
//		new FactorialDemo();
//		new FibonacciDemo();
//		new FactorsDemo();
//		new PrimeNumbersDemo();
//		new PerfectNumbersDemo();
//		new PairsDemo();
//		new Exercises();
//		new DataStructures();
//		new SortSearchAlgorithms();
//		new HanoiTowers();
//		new Etc();
//		new AsciiShapes();
//		new NumSystems();
//		new KRExercises();
		new RandomNumbersDemo();

		System.exit(0);
	}

/* Auxiliary methods. */
	/**
	 * Read a string from the standard input.
	 * Read attempts repeat until a non-blank string is entered.
	 */
	static String readLine() {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		String input = null;

		do {
			try {
				input = stdin.readLine();
				if (input == null) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		} while (input.isEmpty());

		return input;
	}

	/**
	 * Read an integer from the standard input.
	 */
	static int readInt() {
		return Integer.parseInt(readLine());
	}

	/**
	 * Read a long from the standard input.
	 */
	static long readLong() {
		return Long.parseLong(readLine());
	}

	/**
	 * Read a float number from the standard input.
	 */
	static float readFloat() {
		return Float.parseFloat(readLine());
	}
}
