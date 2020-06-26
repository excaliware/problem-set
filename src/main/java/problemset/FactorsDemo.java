package problemset;

/**
 * Find prime factors of the given number.
 */
public class FactorsDemo {

	public FactorsDemo() {

//		printFactors(100000003253453470L);

		for (int n = 2; n <= 25; n++) {
			printFactors(n);
			System.out.printf("\n");
		}

	}

	/**
	 * Find and print prime factors of n.
	 */
	private void printFactors(long n) {

		System.out.printf("%d: ", n);

			/* First, find the factor 2, if any. */
		while (n % 2 == 0) {
			System.out.printf("2 ");
			n /= 2;
		}

			/* Now, check the odd numbers only. */
		int d = 3;
		while (n != 1) {
			while (n % d == 0) {
					/* Divide by this factor while it is possible. */
				n = n / d;
				System.out.printf("%d ", d);
			}
			d += 2;
		}
	}
}
