package problemset;

/**
 * Print all prime numbers in the specified range.
 */
public class PrimeNumbersDemo {

	/* Print and count prime numbers in the specified range. */
	public PrimeNumbersDemo() {

		int nPrimes = 0;
		/* Measure the execution time. */
		long startTime = System.currentTimeMillis();

		/* Find all prime numbers in the range. */
		for (int n = 2; n < 1000000; n++) {
			/* Check whether the number is prime. */
			if (isPrime(n)) {
				nPrimes++;
				System.out.printf("%d is prime\n", n);
			} else {
//				System.out.printf("%d is not prime\n", n);
			}
		}
		System.out.printf("%d prime numbers have been found.", nPrimes);
		
		/* And the execution time is... */
		System.out.printf("\nTime: %d ms.\n", System.currentTimeMillis() - startTime);
	}

	/**
	 * Check whether n is a prime number.
	 *
	 * @param a
	 * @return
	 */
	private boolean isPrime(int n) {
		
		/* 2 is a special case. */
		if (n == 2)
			return true;
		
		/* Do not check the even numbers (they are never prime except 2). */
		if (n % 2 == 0)
			return false;
		
		/* Try to divide the number by other odd numbers. */
		for (int d = 3; d < Math.sqrt(n) + 1; d += 2) {
			/* If the number can be divided without a remainder, it is not prime. */
			if (n % d == 0) {
				return false;
			}
		}
		return true;
	}
}