package problemset;

/**
 * Test the factorial calculation functions.
 */
public class FactorialDemo {

	public FactorialDemo() {
		
		/* Print the factorials of numbers in the given range. */
		for (int n = 0; n <= 20; n++) {
			System.out.printf("%d! = %d\n", n, factIter(n));
		}
	}

	/**
	 * Calculate factorial of the number. Recursion version.
	 */
	private long fact(long n) {

		if (n == 0)
			return 1;

		return n * fact(n - 1);
	}

	/**
	 * Calculate factorial of the number. Iteration version.
	 */
	@SuppressWarnings("unused")
	private long factIter(int n) {
		long f = 1;
		for (long i = 2; i <= n; i++) {
			f *= i;
		}
		return f;
	}
}
