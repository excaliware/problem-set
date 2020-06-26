package problemset;

import java.util.Arrays;
import static java.lang.Math.pow;

import problemset.KRExercises;

class NumSystems {
	public static void main(String[] argv)
	{
		if (argv.length != 2) {
			System.err.printf("Usage: NumSystems number base\n");
			System.exit(1);
		}

		int n = 0;

		if (argv[0].startsWith("b")) {
			n = atoi(argv[0].substring(1), 2);
		} else if (argv[0].startsWith("0x")) {
			n = atoi(argv[0].substring(2), 16);
		} else if (argv[0].startsWith("0")) {
			n = atoi(argv[0].substring(1), 8);
		} else {
			n = Integer.parseInt(argv[0]);
		}
		int base = Integer.parseInt(argv[1]);
		System.out.printf("%d: %s\n", n, formatNum(n, base));
	}

	NumSystems() throws Exception {
		String line;
		int n = 10;

		System.out.printf("%d: %s\n", n, formatNum(n, 2));
		System.out.printf("%d: %s\n", n, formatNum(n, 16));

		while ((line = KRExercises.getLine()) != null) {
			try {
				n = Integer.parseInt(line);
			} catch (Exception e) {
				continue;
			}
			System.out.printf("%d: %s\n", n, formatNum(n, 2));
			System.out.printf("%d: %s\n", n, formatNum(n, 16));
		}
	}

	static int atoi(String str, int base) {
		int n = 0;
		int m = 0;
		int i = str.length() - 1;

		while (i >= 0) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				n += (c - '0') * pow(base, m);
			} else if (c >= 'a' && c <= 'f') {
				n += (c - 'a' + 10) * pow(base, m);
			}
			i--;
			m++;
		}

		return n;
	}

	static String formatNum(int num, int base) {
		if (num == 0) {
			return "0";
		}
		
		char[] buffer = new char[32];
		int i;

		for (i = 0; num > 0; i++) {
			int r = num % base;

			if (r >= 0 && r <= 9) {
				buffer[i] = (char) (r + '0');
			} else if (r >= 10 && r <= 15) {
				buffer[i] = (char) (r + 'a' - 10);
			}
			num /= base;
		}

		for (int j = 0; j < i / 2; j++) {
			char t = buffer[j];
			buffer[j] = buffer[i - j - 1];
			buffer[i - j - 1] = t;
		}

		return new String(buffer, 0, i);
	}
}
