package problemset;

/**
 * Calculate the amount that user will have received in total
 * by the end of the month if that amount is doubled on every day
 * but the first, expressed as dollars and cents.
 */
public class Pennies {

	public Pennies() {
		int p;
		do {
			System.out.printf("Pennies on first day: ");
			p = ProblemSet.readInt();
		} while (p < 1);

		int d;
		do {
			System.out.printf("Days in month: ");
			d = ProblemSet.readInt();
		} while (d < 28 || d > 31);

		System.out.printf("\n%d pennies, %d days.\n", p, d);

		long total = calcPennies(p, d);

		/* Express the amount as dollars and cents. */
		System.out.printf("Total: %d\n", total);

		System.out.printf("$%s\n", formatNumber(total));
	}

	/**
	 * Calculate the amount of pennies by the end of the month.
	 *
	 * @param p Pennies on the first day
	 * @param d Days in the month
	 * @return amount of pennies by the end of the month
	 */
	long calcPennies(int p, int d) {
		long total = p;

		while (d > 0) {
			total *= 2;
			System.err.printf("%d\t", total);	/* TMP */
			d -= 1;
		}
		System.out.printf("\n");

		total -= p;	/* do not double the amount on the first day */

		return total;
	}

	/**
	 * Format the number: insert commas every three digits to the left
	 * of the decimal
	 *
	 * @param num
	 * @return the formated representation of the number
	 */
	String formatNumber(long num) {
		int nGroups = 0;
		int groups[] = new int[6];
		String numStr = new String();	/* String representation of the number */

		/* Get the cents. */
		int cents = (int) (num % 100);
		/* Remove the cents. */
		num /= 100;

		while (num / 1000 != 0) {
			groups[nGroups] = (int) (num % 1000);
			nGroups++;
			num /= 1000;
		}

		numStr += num;
		for (int i = nGroups - 1; i >= 0; i--) {
			numStr += String.format(",%d", groups[i]);
		}

		numStr += String.format(".%d", cents);

		return numStr;
	}
}
