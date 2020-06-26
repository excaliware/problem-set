package problemset;

/**
 * Most years have 365 days. But “leap years” have 366. Any year that is evenly
 * divisible by 4 but not by 100 (unless it is also evenly divisible by 400) is
 * a leap year. Put another way, any year that is evenly divisible by 4 is a
 * leap year, unless it happens to be a centennial year, in which case it must
 * also be evenly divisible by 400 in order to have 366 days. Accordingly, 1996
 * and 2000 were leap years, but 1900 was not.
 */
public class LeapYear {

	LeapYear() {
//		long year = ProblemSet.readLong();
		long[] years = new long[] {1990, 1996, 2000, 2015, 2020};

		for (long year : years) {
			System.out.printf("%d is a leap year: %b\n",
					year, isLeapYear(year));
		}
	}

	/**
	 * Check whether or not the year is a leap year.
	 */
	private boolean isLeapYear(long year) {
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0)
					return true;

				return false;
			}
			return true;
		}
		return false;
	}
}
