package problemset;

import java.io.IOException;

public class Etc {

	Etc() {

		System.out.printf("%s\n", checkSum() ? "Valid" : "Invalid");
	}

	public boolean checkSum() {
		int c;
		int n = 0;
		int oddSum = 0;
		int evenSum = 0;
		int sum = 0;
		int length = 0;

		try {
			while ((c = System.in.read()) != -1) {
				if (c == '\n') {
					break;
				} else if (!Character.isDigit(c)) {
					throw new IOException("Non-digit character provided");
				}
				length++;
				n = c - '0';

				if (length % 2 == 0) {
					evenSum += doubleDigit(n);
					oddSum += n;
				} else {
					evenSum += n;
					oddSum += doubleDigit(n);
				}
			}
			sum = length % 2 == 0 ? evenSum : oddSum;

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		return sum % 10 == 0;
	}

	private int doubleDigit(int n) {
		n *= 2;
		if (n > 9) {
			n = n % 10 + 1;
		}
		return n;
	}

	/**
	 * Read a number from stdin, parsing one character at a time.
	 */
	public int readInt() {
		int c;
		int n = 0;

		try {
			while ((c = System.in.read()) != -1) {
				if (c == '\n') {
					break;
				} else if (!Character.isDigit(c)) {
					throw new IOException("Non-digit character provided");
				}
				n = n * 10 + c - '0';
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		return n;
	}

	/**
	 * Prints the first 100 elements of the sequence 2, -3, 4, -5, 6, -7, 8, ...
	 */
	public void simpleSequence() {

		int i = 2; /* The first element. */
		int N = 100;

		System.out.printf("%d ", i);

		while (i < N) {
			if (i > 0)
				i = -(i + 1);
			else if (i < 0)
				i = -(i - 1);

			System.out.printf("%d ", i);
		}
	}

	/**
	 * Reverses digits in the given number.
	 */
	public int reverseNumber(int n) {

		System.out.printf("Origin n = %d\n", n);

		/* Convert the number to string. */
		char[] origin = String.valueOf(n).toCharArray();
		int length = origin.length;
		char[] reversed = new char[length];

		/* Reverse digits. */
		for (int i = 0; i < length; i++) {
			reversed[i] = origin[length - i - 1];
		}

		/* Convert the string to number. */
		n = Integer.parseInt(new String(reversed));
		System.out.printf("Reversed n = %d\n", n);

		return n;
	}
}
