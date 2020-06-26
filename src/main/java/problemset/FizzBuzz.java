package problemset;

/**
 * This program prints the numbers from 1 to 100. But for multiples of three
 * prints 'Fizz' instead of the number and for the multiples of five prints
 * 'Buzz'. For numbers which are multiples of both three and five prints
 * 'FizzBuzz'.
 */
public class FizzBuzz {

	public FizzBuzz() {

		for (int i = 1; i <= 100; i++) {

			boolean mult3 = i % 3 == 0;
			boolean mult5 = i % 5 == 0;

			if (mult3 && mult5) {
				System.out.printf("FizzBuzz ");
				continue;
			}
			if (mult3) {
				System.out.printf("Fizz ");
				continue;
			}
			if (mult5) {
				System.out.printf("Buzz ");
				continue;
			}
			System.out.printf("%d ", i);
		}
	}
}
