package problemset;

import java.util.Arrays;
import java.util.Random;

public class SortSearchAlgorithms {

	public SortSearchAlgorithms() {
		System.out.printf("Sort and search algorithms\n");

		//strStrDemo();
		sortDemo();
	}

	public void strStrDemo() {
		assert strStr("abcde", "a") == 0;
		assert strStr("abcde", "ab") == 0;
		assert strStr("abcde", "e") == 4;
		assert strStr("abcde", "de") == 3;
		assert strStr("abcde", "f") == -1;
		assert strStr("abcde", "ef") == -1;
		assert strStr("abcde", "za") == -1;
	}

	private void sortDemo() {
		System.out.printf("Sorting\n");
		
		int[] numbers = generateSampleData(10000000);
		int[] result = new int[numbers.length];

		// System.out.printf("Before: %s\n", Arrays.toString(numbers));

		long start = System.currentTimeMillis();

		// Arrays.sort(numbers);
		// bubbleSort(numbers);
		// selectionSort(numbers);
		// insertionSort(numbers);
		// quickSort(numbers, 0, numbers.length-1);
		mergeSort(numbers, result, 0, numbers.length);

		long end = System.currentTimeMillis();

		// System.out.printf("After: %s\n", Arrays.toString(numbers));
		System.out.printf("Elapsed time: %.3f s.\n", (end - start) / 1000.0);

		/* Ensure that the numbers are now in ascending order. */
		for (int i = 0; i < numbers.length - 1; i++)
			if (numbers[i] > numbers[i + 1])
				throw new RuntimeException("Elements are not in ascending order");

		int key = 7;
		System.out.printf("Found %d at index %d\n", key, binarySearch(key, numbers));
	}

	public void mergeSort(int[] a, int[] t, int l, int r) {
		if (r - l <= 1) {
			return;
		}

		int mid = l + (r - l) / 2;

		mergeSort(a, t, l, mid);
		mergeSort(a, t, mid, r);

		int i = l;
		int j = mid;
		int k = l;

		while (k < r) {
			if (i == mid) {
				t[k] = a[j];
				j += 1;
			} else if (j == r) {
				t[k] = a[i];
				i += 1;
			} else if (a[i] < a[j]) {
				t[k] = a[i];
				i += 1;
			} else {
				t[k] = a[j];
				j += 1;
			}
			k += 1;
		}

		i = l;
		while (i < r) {
			a[i] = t[i];
			i += 1;
		}
	}

	public void quickSort(int[] a, int l, int r) {
		if (l >= r) {
			return;
		}

		int lastSmall = l;

		swap(a, l, (int) (l + Math.random() * (r - l + 1)));

		for (int i = l+1; i <= r; i++) {
			if (a[i] < a[l]) {
				lastSmall++;
				swap(a, lastSmall, i);
			}
		}
		swap(a, l, lastSmall);

		quickSort(a, l, lastSmall-1);
		quickSort(a, lastSmall+1, r);
	}

	private void swap(int[] a, int i, int j) {
		int t = a[j];
		a[j] = a[i];
		a[i] = t;
	}

	public void quickSort2(int[] a, int l, int r) {
		if (l >= r || l < 0)
			return;

		int l0 = l;
		int r0 = r;
		int pivot = a[l];

outer:
		while (l < r) {
			while (a[r] >= pivot) {
				r = r - 1;
				if (l >= r)
					break outer;
			}
			a[l] = a[r];
			l = l + 1;
			if (l >= r)
				break;

			while (a[l] <= pivot) {
				l = l + 1;
				if (l >= r)
					break outer;
			}
			a[r] = a[l];
			r = r - 1;
			if (l >= r)
				break;
		}
		a[l] = pivot;
		quickSort2(a, l0, l - 1);
		quickSort2(a, l + 1, r0);
	}

	public void bubbleSort(int[] numbers) {

		for (int i = 0; i < numbers.length - 1; i++) {
			boolean swapped = false;

			for (int j = 0; j < numbers.length - i - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					int tmp = numbers[j + 1];
					numbers[j + 1] = numbers[j];
					numbers[j] = tmp;
					swapped = true;
				}
			}
			if (!swapped)
				break;
		}
	}

	public void selectionSort(int[] numbers) {

		for (int i = 0; i < numbers.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] < numbers[min])
					min = j;
			}
			if (min != i) {
				int tmp = numbers[i];
				numbers[i] = numbers[min];
				numbers[min] = tmp;
			}
		}
	}

	public void insertionSort(int[] numbers) {

		for (int i = 1; i < numbers.length; i++) {

			/* Find the correct position in the 'sorted' part of the array. */
			int x = numbers[i];
			int j = i - 1;

			while (j >= 0 && x < numbers[j]) {
				/* Shift the element to the right. */
				numbers[j + 1] = numbers[j];
				j = j - 1;
			}
			numbers[j + 1] = x;
		}
	}

	public int binarySearch(int key, int[] numbers) {
//		return binarySearchNonRecursive(key, numbers);
		return binarySearchRecursive(key, numbers, 0, numbers.length - 1);
	}

	private int binarySearchRecursive(int key, int[] numbers, int l, int r) {

		if (l > r)
			return -1;

		int mid = (l + r) / 2;
		if (numbers[mid] == key)
			return mid;
		else if (numbers[mid] > key)
			return binarySearchRecursive(key, numbers, l, mid - 1);
		else // if (numbers[mid] < key)
			return binarySearchRecursive(key, numbers, mid + 1, r);
	}

	private int binarySearchNonRecursive(int key, int[] numbers) {

		int l = 0;
		int r = numbers.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (numbers[mid] == key)
				return mid;
			else if (numbers[mid] > key)
				r = mid - 1;
			else if (numbers[mid] < key)
				l = mid + 1;
		}
		return -1;
	}

	/**
	 * Find occurrence of a substring in the given string.
	 * @param str the string to be searched in
	 * @param subStr the substring to search for
	 * @return the index of the first occurrence; -1 if no match
	 */
	public int strStr(final String str, final String subStr) {

		for (int i = 0; i < str.length() - subStr.length() + 1; i++) {
			int j = 0;
			for (; j < subStr.length(); j++) {
				if (str.charAt(i + j) != subStr.charAt(j))
					break;
			}
			if (j == subStr.length())
				return i;
		}
		return -1;
	}

	private int[] generateSampleData(int quantity) {

		int[] numbers = new int[quantity];
		Random rand = new Random();

		for (int i = 0; i < quantity; i++)
			numbers[i] = rand.nextInt(quantity);

		return numbers;
	}
}
