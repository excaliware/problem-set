package problemset;

public class Exercises {

	Exercises() {

//		reverseDemo();
		bitwiseDemo();
//		sequenceSum();
	}

	/**
	 * Calculates the sum of the sequence 1 + 1/2 - 1/3 + 1/4 ...
	 */
	private void sequenceSum() {
		final double PRECISION = 0.001;
		double sum = 1;
		double oldSum = 0;
		int n = 2;

		while (Math.abs(sum - oldSum) > PRECISION) {

			oldSum = sum;
			sum += 1.0 / n;

			if (n > 0)
				n = -(n + 1);
			else
				n = -(n - 1);
		}
		System.out.printf("Sum = %f\n", sum);
	}

	private void asyncDemo() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("In a new thread.");
			}
		}).start();
	}

	/**
	 * Exchange the bit 1 with the bit 4 in the given number.
	 */
	private void bitwiseDemo() {

		int n = 35;

		System.out.println(Integer.toBinaryString(n));
		int bit1 = n >> 1 & 1;
		int bit4 = n >> 4 & 1;

		n = n & ~(1 << 1) | (bit4 << 1);
		n = n & ~(1 << 4) | (bit1 << 4);
		System.out.println(Integer.toBinaryString(n));
	}

	private void reverseDemo() {

		String str = "abcde";
		int len = str.length();
		char[] strArray = str.toCharArray();
		char temp;
		int i = 0;

		while (i < len / 2) {
			/* Swapping */
			temp = strArray[i];
			strArray[i] = strArray[len - i - 1];
			strArray[len - i - 1] = temp;
			i = i + 1;
		}
		System.out.println(new String(strArray));
	}
}
