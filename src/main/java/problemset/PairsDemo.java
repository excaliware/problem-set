package problemset;

/**
 * Find all pairs of numbers in a given sorted array the sum of which is equal to a given number.
 */
public class PairsDemo {

	public PairsDemo() {

		int[] nums = {1, 3, 4, 6, 7, 9, 11, 14, 16, 19};

		/* Given number. */
		int k = 20;

		/* Left/right indexes. */
		int l = 0;
		int r = nums.length - 1;

		/* First, discard too big numbers. */
		while (nums[l] + nums[r] > k)
			r--;
		
		/* Remember the new right index. */
		final int rr = r;

		while (nums[l] + nums[l + 1] <= k) {
			while (nums[l] + nums[r] > k)
				r--;

			if (nums[l] + nums[r] == k)
				System.out.printf("[%d, %d]\n", nums[l], nums[r]);

			l++;
			/* Restore the right index. */
			r = rr;
		}
	}
}
