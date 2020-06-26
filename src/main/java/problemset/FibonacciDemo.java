package problemset;

/**
 * Demonstration of the Fibonacci calculation functions.
 */
public class FibonacciDemo {

	public FibonacciDemo() {

		int n = 46;

		System.out.printf("Calculating Fibonacci(%d)... ", n);
		System.out.println(fibonacciIter(n));
	}

	/**
	 * Calculates the nth element of the Fibonacci series. Using iteration.
	 */
	private long fibonacciIter(int n) {
		long n1 = 0;
		long n2 = 1;

		for (int i = 2; i <= n; i++) {
			long t = n1;
			n1 = n2;
			n2 = t + n2;
//			System.out.printf("%d: %d\n", i, n2);
		}
		return n2;
	}

	/**
	 * Calculates the nth element of the Fibonacci series.
	 * Implemented using recursion (very inefficient).
	 */
	@SuppressWarnings("unused")
	private long fibonacci(long n) {

		if (n == 0 || n == 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
