package problemset;

/**
 * Program prompts the user for a credit card number and then reports whether it
 * is a valid American Express, MasterCard, or Visa card number.
 */
public class CreditCard {

	final int MASTERCARD = 16;
	final int AMEX = 15;
	final int VISA = 13;

	// Sample number: 378282246310005

	CreditCard() {
		System.out.printf("Number: ");
		long num = ProblemSet.readLong();

		while (num < 1) {
			System.out.printf("Retry: ");
			num = ProblemSet.readLong();
		}

		if (checkNumber(num))
			System.out.printf("VALID\n");
		else
			System.out.printf("INVALID\n");
	}

	/**
	 * Check if a valid credit card number was provided.
	 *
	 * @return true if the number is valid.
	 */
	private boolean checkNumber(long num) {
		/*
		 * According to Luhn’s algorithm, you can determine if a credit card
		 * number is (syntactically) valid as follows: Multiply every other
		 * digit by 2, starting with the number’s second last digit, and then
		 * add those products’ digits together. ii) Add the sum to the sum of
		 * the digits that weren’t multiplied by 2. iii) If the total’s last
		 * digit is 0 (or, put more formally, if the total modulo 10 is
		 * congruent to 0), the number is valid.
		 */

		long numCopy = num;
		boolean isEven = false;
		int sum = 0;
		int nDigits = 0;

		while (num != 0) {
			long d = num % 10;
			System.out.printf("%d\n", d);
			if (!isEven) {
				isEven = true;
				sum += d;
			} else {
				isEven = false;
				d *= 2;
				if (d > 9)
					sum += d % 10 + d / 10;
				else
					sum += d;
			}
			nDigits++;
			num /= 10;

			System.err.printf("sum = %d; ndigits = %d\t", sum, nDigits);
		}
		
		/* Sum's last digit should be 0. */
		if (sum % 10 != 0)
			return false;

		/* Check the number at the beginning (the first two digits). */
		num = numCopy / (long) Math.pow(10, nDigits - 2);
		System.err.printf("Starts with: %d\n", num);

		/* Find out and print the type of the card. */
		switch (nDigits) {
			case 15:
			/* American Express 34 or 37 */
				System.out.printf("AMEX\n");
				break;
			case 13:
			/* Visa 4 */
				System.out.printf("VISA\n");
				break;
			case 16:
			/* Visa 4; MasterCard 51, 52, 53, 54, 55 */
				if (num > 50 && num < 56)
					System.out.printf("MASTERCARD\n");
				else
					System.out.printf("VISA\n");
				break;
			default:
				return false;
		}

		return true;
	}

}
