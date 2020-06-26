package problemset;

/**
 * Program first asks the user how much change is owed;
 * then print out the minimum number of coins which the change
 * can be made with.
 */
public class Coins {
	final int QUARTER = 25;
	final int DIME = 10;
	final int NICKEL = 5;
	final int PENNY = 1;

	Coins() {
		System.out.printf("Coins\n");

		System.out.printf("How much change is owed? ");
		/* Get the amount of money from the user. */
		float money = ProblemSet.readFloat();

		/* Convert the money to cents. */
		int change = (int) Math.round(money * 100.0);
		System.out.printf("Change: %d cents\n", change);

		/* First calculate the number of quarters. */
		int n = change / QUARTER;
		change -= n * QUARTER;
		int nCoins = n;
		System.out.printf("Quarters: %d\n", n);

		/* Calculate the number of dimes. */
		n = change / DIME;
		change -= n * DIME;
		nCoins += n;
		System.out.printf("Dimes: %d\n", n);

		/* Calculate the number of nickels. */
		n = change / NICKEL;
		change -= n * NICKEL;
		nCoins += n;
		System.out.printf("Nickels: %d\n", n);

		/* Only pennies left. */
		nCoins += change;
		System.out.printf("Pennies: %d\n", change);

		System.out.printf("\nTotal coins:\n%d\n", nCoins);
	}

}