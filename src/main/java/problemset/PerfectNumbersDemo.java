package problemset;

/**
 * Program searches for perfect numbers.
 */
public class PerfectNumbersDemo {

	public PerfectNumbersDemo() {

		byte nPerfects = 0;

		for (int n = 2; n < 100000000; n++) {
			if (isPerfect(n)) {
				nPerfects++;
				System.out.printf("%d: %d is a perfect number.\n", nPerfects, n);
			}

				/* See the progress. */
			// if (n % 100000 == 0) System.out.printf("%d\n", n);
		}

	}

	/**
	 * Check whether the given number is perfect.
	 *
	 * @param n the given number
	 * @return true if it is perfect, false if it is not
	 */
	boolean isPerfect(int n) {

		int d = 2;
		int sum = 1;	/* any number has the factor 1 */

		/* Searching for factors. */
		while (d <= Math.sqrt(n)) {
			if (n % d == 0) {
				sum = sum + d + n / d;
			}
			d++;
//			System.out.printf("%d %d\n", n, d);
		}

		if (n == sum)
			return true;
		else
			return false;
	}
}