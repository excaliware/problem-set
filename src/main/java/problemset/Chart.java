package problemset;

/**
 * Program prompts a user for four non-negative integers (one for each of M
 * spotting F, F spotting M, F spotting F, and M spotting M); generate a
 * horizontal/vertical bar chart representing those.
 */
public class Chart {

	final int SCREEN_WIDTH = 80;
	final char BAR_CHAR = '#';
	/* For the vertical bars */
	final int MAX_BAR_HEIGHT = 20;
	final int BAR_WIDTH = 3;
	final String BAR = "###";
	final String BAR_EMPTY = "   ";

	Chart() {
		System.out.printf("Charts\n");

		/* Get the data from the user. */
		System.out.printf("M-F: ");
		int mf = ProblemSet.readInt();
		System.out.printf("F-M: ");
		int fm = ProblemSet.readInt();
		System.out.printf("M-M: ");
		int mm = ProblemSet.readInt();
		System.out.printf("F-F: ");
		int ff = ProblemSet.readInt();

		System.out.printf("Who is spotting whom\n");

		chartVertical(mf, fm, mm, ff);
	}

	/**
	 * Calculate the length of each bar; draw them.
	 */
	void chart(int mf, int fm, int mm, int ff) {
		int sum = mf + fm + ff + mm;

		int nPounds; /* the number of pounds representing the bar */
		if (mf == 0)
			nPounds = 0;
		else
			/*
			 * Calculate the length of the bar, which is proportional to the
			 * corresponding value and relative to the four values’ sum.
			 */
			nPounds = (int) (SCREEN_WIDTH / ((float) sum / mf));

		System.out.printf("M-F %d %d%%\n", mf, (int) ((float) mf / sum * 100));

		for (int i = 0; i < nPounds; i++) {
			System.out.print(BAR_CHAR);
		}
		System.out.printf("\n");

		if (fm == 0)
			nPounds = 0;
		else
			nPounds = (int) (SCREEN_WIDTH / ((float) sum / fm));
		System.out.printf("F-M %d %d%%\n", fm, (int) ((float) fm / sum * 100));
		for (int i = 0; i < nPounds; i++) {
			System.out.print(BAR_CHAR);
		}
		System.out.printf("\n");

		if (mm == 0)
			nPounds = 0;
		else
			nPounds = (int) (SCREEN_WIDTH / ((float) sum / mm));

		System.out.printf("M-M %d %d%%\n", mm, (int) ((float) mm / sum * 100));
		for (int i = 0; i < nPounds; i++) {
			System.out.print(BAR_CHAR);
		}
		System.out.printf("\n");

		if (ff == 0)
			nPounds = 0;
		else
			nPounds = (int) (SCREEN_WIDTH / ((float) sum / ff));
		System.out.printf("F-F %d %d%%\n", ff, (int) ((float) ff / sum * 100));
		for (int i = 0; i < nPounds; i++) {
			System.out.print(BAR_CHAR);
		}
		System.out.printf("\n");

	}

	/**
	 * Calculate the length of each bar; draw them _vertically_.
	 */
	void chartVertical(int mf, int fm, int mm, int ff) {
		int sum = mf + fm + ff + mm;
		if (sum == 0)
			return;

		System.err.printf("M-F: %d F-M: %d M-M: %d F-F: %d\n", mf, fm, mm, ff);

		mf = (int) (MAX_BAR_HEIGHT * ((float) mf / sum));
		fm = (int) (MAX_BAR_HEIGHT * ((float) fm / sum));
		mm = (int) (MAX_BAR_HEIGHT * ((float) mm / sum));
		ff = (int) (MAX_BAR_HEIGHT * ((float) ff / sum));

		System.err.printf("M-F: %d F-M: %d M-M: %d F-F: %d\n", mf, fm, mm, ff);

		for (int i = 0; i < MAX_BAR_HEIGHT; i++) {
			if (mf >= MAX_BAR_HEIGHT - i) {
				System.out.printf("%s  ", BAR);
			} else {
				System.out.printf("%s  ", BAR_EMPTY);
			}

			if (fm >= MAX_BAR_HEIGHT - i) {
				System.out.printf("%s  ", BAR);
			} else {
				System.out.printf("%s  ", BAR_EMPTY);
			}

			if (mm >= MAX_BAR_HEIGHT - i) {
				System.out.printf("%s  ", BAR);
			} else {
				System.out.printf("%s  ", BAR_EMPTY);
			}

			if (ff >= MAX_BAR_HEIGHT - i) {
				System.out.printf("%s  ", BAR);
			} else {
				System.out.printf("%s  ", BAR_EMPTY);
			}
			System.out.printf("\n");
		}

		System.out.printf("M-F  F-M  M-M  F-F\n");

	}
}
