package problemset;

import java.util.Arrays;

class RandomNumbersDemo {
	RandomNumbersDemo() {


		int nums[] = {2, 4, 0, 3, 1, 5, 6, 7, 8, 9};

		System.out.printf("%s\n", Arrays.toString(nums));
		randomise(nums);
		System.out.printf("%s\n", Arrays.toString(nums));

		char chars[] = new char[10];

		// randomPopulate(chars);
		// System.out.printf("%s\n", Arrays.toString(chars));
	}

	void randomise(int a[]) {
		int i = 0;

		while (i < a.length) {
			int r = (int) (Math.random() * (a.length - i)) + i;
			int t = a[i];
			a[i] = a[r];
			a[r] = t;
			i += 1;
		}
	}

	/** Randomly populate an array with characters.
	 * The index of the character shouldn't go
	 * to the same index of the target array.
	 * Only one of each character is allowed in the result array.
	 */
	void randomPopulate(char a[]) {
		/* Iterate over a sequence of numbers,
		 * which represent character codes when 'A' is added. */
		for (int c = 0; c < a.length; c++) {
			int i;
			while (true) {
				/* Peek a random element in the array. */
				i = (int) (Math.random() * a.length);
				/* If a[i] is not 0, get another random number. */
				if (a[i] == '\0') {
					if (i == c && i != a.length - 1) {
						continue;
					}
					a[i] = (char) (c + 'A');
					if (i == a.length - 1) {
						char t = a[i - 1];
						a[i - 1] = a[i];
						a[i] = t;
					}
					break;
				}
			}
		}
	}
}
