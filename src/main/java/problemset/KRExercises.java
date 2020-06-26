package problemset;

import java.io.IOException;

public class KRExercises {

	/** Maximum input line size. */
	public static final int MAXLINE = 1000;

	public static final int EOF = -1;

	public KRExercises() throws Exception {

		System.out.printf("%d\n", atoi("123"));
		processText();
		//inToOut();
		//countCharacters();
		//printWordPerLine();
		//countEachDigit();
		//printLengthsHistogramHor();
		//printLengthsHistogramVert();
		//printFreqHistogramHor();
		//printFreqHistogramVert();
		//printLongestLine();
		//demoTrailingSpaces();
		//removeComments();

	}

	/**
	 * Simple text filter.
	 *
	 * @throws IOException
	 */

	public void processText() throws IOException {

		String line;

		/* Get lines of text until EOF. */
		while ((line = getLine()) != null) {

			/* Process the line. */
			line = unescape(line);

			System.out.printf("%s\n", line);
		}
	}

	/**
	 * Removes escape sequences from a raw line; print in their place the
	 * corresponding special character.
	 * @param str
	 */
	public String unescape(String str) {

		int len = str.length();
		char[] result = new char[len];
		int j = 0;	/* index of the result array */

		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);

			/* Check whether it is an escape sequence. */
			if (ch == '\\') {
				i++;
				if (i >= len) {
					result[j] = '\\';
					break;
				}
				ch = str.charAt(i);
				switch (ch) {
					case 't':
						result[j] = '\t';
						break;
					case 'n':
						result[j] = '\n';
						break;
					default:
					/* Not an escape sequence. */
						result[j] = '\\';
						result[++j] = ch;
				}
			} else {
				/* Other character. */
				result[j] = ch;
			}
			j ++;
		}
		return new String(result);
	}

	/**
	 * Converts string to integer.
	 *
	 * @param line
	 * @return
	 */
	public int atoi(String line) {

		int n = 0;

		for (int i = 0; i < line.length(); ++i) {

			char ch = line.charAt(i);
			if (ch < '0' || ch > '9')
				throw new Error("Not a numeric character in the string.");

			n = 10 * n + (ch - '0');
		}

		return n;
	}

	/**
	 * Removes all occurrences of any character in chars from the str.
	 */
	public String squeezeStr(String str, String chars) {

		char[] result = new char[str.length()];
		int k = 0;
		boolean found = false;

		for (int i = 0; i < str.length(); ++i) {

			char c = str.charAt(i);
			for (int j = 0; j < chars.length(); ++j) {

				if (c == chars.charAt(j)) {
					found = true;
					break;
				}
			}
			if (found) {
				found = false;
				continue;
			}
			result[k] = c;
			++k;
		}

		return new String(result, 0, k);
	}

	/**
	 * Removes all occurrences of the character c from the string str.
	 *
	 * @param c
	 */
	public String squeeze(String str, char c) {

		int len = str.length();
		char[] result = new char[len];
		int j = 0;

		for (int i = 0; i < len; ++i) {

			char curChar = str.charAt(i);
			if (curChar == c)
				/* Don't include the this character into the new string. */
				continue;
			result[j] = curChar;
			++j;
		}

		return new String(result, 0, j);
	}

	/**
	 * Removes comments from a C code in the standard input.
	 *
	 * @throws IOException
	 */
	public void removeComments() throws IOException {

		boolean openingSlash = false;
		boolean closingAsterisk = false;
		boolean inComment = false;
		boolean inQuote = false;

		int c;
		while ((c = System.in.read()) != EOF) {

			if (!inComment && !inQuote) {
				if (c == '/') {
					openingSlash = true;
					continue;
				}
				if (openingSlash) {
					openingSlash = false;
					if (c == '*') {
						inComment = true;
					} else {
						System.out.write('/');
						System.out.write(c);
					}
					continue;
				}
			} else if (inComment) {
				if (c == '*') {
					closingAsterisk = true;
					continue;
				}
				if (closingAsterisk) {
					closingAsterisk = false;
					if (c == '/') {
						inComment = false;
					}
				}
				continue; /* Ignore the content of the comment. */
			}
			System.out.write(c);

			if (c == '"')
				if (inQuote)
					inQuote = false;
				else
					inQuote = true;
		}
	}

	/**
	 * 'Folds' long input lines into two or more shorter lines after the last
	 * non-blank character that occurs before the n-th column of input.
	 *
	 * @param line
	 */
	public void fold(String line) {

		final int MAX_COL = 12;
		final int TAB_WIDTH = 8;

		for (int offset = 0; offset < line.length(); offset += MAX_COL) {

			/* Last line. */
			if (offset + MAX_COL >= line.length()) {
				System.out.printf(line.substring(offset));
				break;
			}
			int end = offset + MAX_COL;

			char[] str = line.toCharArray();

			/* Discard trailing blanks and tabs. */
			while (str[end] == ' ' || str[end] == '\t') {

				/* Do not print empty lines. */
				if (end <= offset)
					continue;

				--end;
			}
			/* Consider tab width. */
			int nChars = 0;
			for (int i = offset; i < end; ++i) {

				++nChars;
				if (str[i] == '\t') {
					int r = nChars % TAB_WIDTH;
					for (int j = 0; j < TAB_WIDTH - r - 1; ++j) {
						--end;
						++nChars;
					}
					continue;
				}
			}

			System.out.printf("%s\n", line.substring(offset, end));
		}
	}

	/**
	 * Replaces tabs in the input with the proper number of blanks to space to
	 * the next tab stop.
	 *
	 * @param line
	 * @throws IOException
	 */
	public void detab(String line) throws IOException {
		final int TAB_WIDTH = 8;
		int nChars = 0; /* number of characters in the current line */

		for (char c : line.toCharArray()) {
			if (c == '\t') {
				int r = (nChars + TAB_WIDTH) % TAB_WIDTH;
				for (int i = 0; i < TAB_WIDTH - r; ++i) {
					System.out.write(' ');
					++nChars;
				}
			} else {
				/* Not a tab */
				if (c == '\n') {
					nChars = 0;
				} else {
					++nChars;
				}
				System.out.write(c);
			}
		}
	}

	/**
	 * Replaces strings of blanks by the minimum number of tabs and blanks to
	 * achieve the same spacing.
	 *
	 * @param line
	 * @throws IOException
	 */
	public void entab(String line) throws IOException {
		final int TAB_WIDTH = 8;
		int nChars = 0; /* number of characters in the current line */
		int nBlanks = 0;
		boolean inBlank = false;

		for (char c : line.toCharArray()) {
			if (c == ' ') {
				++nBlanks;
				if (!inBlank)
					inBlank = true;
				continue;
			}
			if (inBlank) {

				if (nBlanks == 1) {
					nBlanks = 0;
					inBlank = false;
					System.out.write(' ');
					System.out.write(c);
					nChars += 2;
					continue;
				}

				int nCharsRemain = nChars % TAB_WIDTH;
				if (nCharsRemain + nBlanks < TAB_WIDTH)
					for (int i = 0; i < nBlanks; ++i) {
						System.out.write(' ');
						++nChars;
					}

				else if (nCharsRemain + nBlanks == TAB_WIDTH) {
					System.out.write('\t');
					++nChars;
				} else {
					/* nCharRemain + nBlanks > TAB_WIDTH */
					int nTabs = (nCharsRemain + nBlanks) / TAB_WIDTH;
					for (int i = 0; i < nTabs; ++i) {
						System.out.write('\t');
						int r = nChars % TAB_WIDTH;
						for (int j = 0; j < TAB_WIDTH - r; ++j)
							++nChars;
					}

					int nBlanksRemain = (nCharsRemain + nBlanks) % TAB_WIDTH;
					for (int i = 0; i < nBlanksRemain; ++i) {
						System.out.write(' ');
						++nChars;
					}
				}
				nBlanks = 0;
				inBlank = false;
			}

			if (c == '\t') {
				System.out.write('\t');
				int r = nChars % TAB_WIDTH;
				for (int i = 0; i < TAB_WIDTH - r; ++i)
					++nChars;
			} else {
				/* any other non-blank character */
				++nChars;
				System.out.write(c);
			}
		}

	}

	public void demoTrailingSpaces() throws IOException {
		String line;

		while ((line = getLine()) != null) {
			System.out.printf("Original: %s\n", line);
			String processed = removeTrailingSpaces(line);

			/* Check whether the line is completely blank. If so, discard it. */
			if (processed.length() == 0)
				continue;
			System.out.printf("Processed: %s\n", processed);
		}
	}

	/**
	 * Removes trailing blanks and tabs from a character string.
	 *
	 * @param str
	 */
	public String removeTrailingSpaces(String str) {

		char[] origin = str.toCharArray();
		int len = str.length();
		int nSpaces = 0;

		for (int i = len - 1; i >= 0; --i) {
			if (origin[i] == ' ' || origin[i] == '\t') {
				++nSpaces;
			} else {
				/* not a blank/tab */
				if (nSpaces == 0)
					return str;
				else
					return new String(origin, 0, len - nSpaces);
			}
		}
		return str;
	}

	/**
	 * Reverses the characters in the string.
	 *
	 * @param str
	 *            a string to reverse.
	 */
	public String reverse(String str) {

		int len = str.length();
		char[] origin = str.toCharArray();
		char[] reversed = new char[len];
		int i = 0;

		while (i < len) {
			reversed[i] = origin[len - i - 1];
			++i;
		}
		return new String(reversed);
	}

	/**
	 * Prints the longest input line.
	 */
	public void printLongestLine() throws IOException {

		String line; /* current input line */
		String longestLine = null; /* saves the longest line */
		int max = 0; /* maximum length seen so far */

		while ((line = getLine()) != null) {
			if (line.length() > max) {
				max = line.length();
				longestLine = copyLine(line);
			}
		}
		if (max > 0)
			System.out.printf("The longest line: %s", longestLine);
	}

	/**
	 * Copies a string from src.
	 *
	 * @return a new String, which is the copy of src.
	 */
	public String copyLine(String src) {

		char[] s = new char[MAXLINE];
		int i = 0;

		while (i < src.length()) {
			s[i] = src.charAt(i);
			++i;
		}
		return new String(s, 0, i);
	}

	/**
	 * Reads a line of text from the standard input.
	 *
	 * @return the next line (excluding \n, \r), or <code>null</code> if the EOF
	 *         is reached.
	 * @throws IOException
	 */
	public static String getLine() throws IOException {

		int i = 0;
		int c;
		char[] line = new char[MAXLINE];

		while ((c = System.in.read()) != EOF) {
			if (c == '\n' || c == '\r')
				break;
			line[i] = (char) c;
			++i;
		}

		if (c == EOF && i == 0) {
			return null;
		}

		return new String(line, 0, i);
	}

	public int pow(int base, int n) {

		int p = 1;

		while (n > 0) {
			p *= base;
			--n;
		}
		return p;
	}

	/**
	 * Prints a histogram (vertical) of frequencies of different characters in
	 * its in input.
	 */
	public void printFreqHistogramVert() throws IOException {

		final int HEIGHT = 25;
		final int WIDTH = 80;
		final int BAR_WIDTH = 2;
		final int BAR_SPACE = 1;
		final int MAX_BARS = 22;
		final int BAR = '#';
		final int EMPTY = ' ';
		final int LOWER = 97;
		final int UPPER = 123;
		int[] frequencies = new int[UPPER + 1];

		int c;
		/* Count the number of occurrences of each character. */
		while ((c = System.in.read()) != EOF) {
			++frequencies[c];
		}

		/* Find the maximum frequency. */
		int max = frequencies[1];
		for (int i = 2; i < frequencies.length; ++i)
			if (max < frequencies[i])
				max = frequencies[i];

		/* Draw the histogram vertically. */
		for (int n = max; n > 0; --n) {

			/* Print the y axis. */
			System.out.printf("%2d|", n);

			for (int i = LOWER; i < UPPER; ++i) {
				if (frequencies[i] >= n)
					System.out.printf(" %c ", BAR);
				else
					System.out.printf(" %c ", EMPTY);
			}
			System.out.write('\n');
		}

		/* Print the labels representing the number of occurrences. */
		System.out.printf("   ");
		for (int i = LOWER; i < UPPER; ++i)
			System.out.printf("%2d ", frequencies[i]);
		System.out.println();

		/* Print the x axis labels. */
		System.out.printf("   ");
		for (int i = LOWER; i < UPPER; ++i)
			System.out.printf("%2c ", i);
		System.out.println();
	}

	/**
	 * Prints a histogram (horizontal) of frequencies of different characters in
	 * its in input.
	 *
	 * @throws IOException
	 */
	public void printFreqHistogramHor() throws IOException {

		final int WIDTH = 80;
		final int HEIGHT = 25;
		final int MAX_BARS = 22;
		final int BAR = '#';
		final int BAR_WIDTH = WIDTH - 3; /* 3 columns for the y axis label */
		final int LOWER = 32;
		final int UPPER = 127;
		int[] frequencies = new int[UPPER + 1];

		int c;
		/* Count the number of occurrences of each character. */
		while ((c = System.in.read()) != EOF) {
			++frequencies[c];
		}

		/* Draw the histogram horizontally. */
		for (c = LOWER + 66; c <= UPPER - 15; ++c) {

			/* Print the character label and its value. */
			System.out.printf("%2c[%2d]", c, frequencies[c]);

			/* Draw a horizontal bar representing the number of occurrences. */
			for (int j = 0; j < frequencies[c]; ++j) {
				System.out.write(BAR);
			}
			System.out.write('\n');

		}
	}

	/**
	 * Prints a histogram (vertical) of the lengths of words in its input.
	 *
	 * @throws IOException
	 */
	public void printLengthsHistogramVert() throws IOException {

		int c;
		int current = 0;
		boolean inWord = false;
		final int HEIGHT = 25;
		final int WIDTH = 80;
		final int BAR_WIDTH = 2;
		final int BAR_SPACE = 1;
		final int MAX_BARS = 22;
		final int BAR = '#';
		final int EMPTY = ' ';
		int[] lengths = new int[MAX_BARS];

		/* Calculate the length of words in input. */
		while ((c = System.in.read()) != EOF) {
			if (Character.isWhitespace(c)) {
				if (inWord) {
					inWord = false;
					++lengths[current];
					current = 0;
				}
			} else {
				/* Not a space. */
				if (!inWord) {
					inWord = true;
				}
				++current;
			}
		}

		/* Find the maximum length. */
		int max = lengths[1];
		for (int i = 2; i < lengths.length; ++i)
			if (max < lengths[i])
				max = lengths[i];

		/* Draw the histogram vertically. */
		for (int n = max; n > 0; --n) {

			/* Print the y axis. */
			System.out.printf("%2d|", n);

			for (int j = 1; j < MAX_BARS; ++j) {
				if (lengths[j] >= n)
					System.out.printf(" %c ", BAR);
				else
					System.out.printf(" %c ", EMPTY);
			}
			System.out.write('\n');
		}

		/* Print the labels representing the number of occurrences. */
		for (int i = 0; i < MAX_BARS; ++i)
			System.out.printf("%2d ", lengths[i]);
		System.out.println();

		/* Print the x axis labels. */
		for (int i = 0; i < MAX_BARS; ++i)
			System.out.printf("%2d ", i);
		System.out.println();
	}

	/**
	 * Prints a histogram (horizontal) of the lengths of words in its input.
	 *
	 * @throws IOException
	 */
	public void printLengthsHistogramHor() throws IOException {

		boolean inWord = false;
		int current = 0;
		final int HEIGHT = 25;
		int[] lengths = new int[HEIGHT];
		final int BAR = '#';

		int c;
		/* Calculate the length of words in input. */
		while ((c = System.in.read()) != EOF) {
			if (Character.isWhitespace(c)) {
				if (inWord) {
					inWord = false;
					++lengths[current];
					current = 0;
				}
			} else {
				/* Not a space. */
				if (!inWord) {
					inWord = true;
				}
				++current;
			}
		}

		/* Draw the histogram horizontally. */
		for (int i = 1; i < HEIGHT; ++i) {
			System.out.printf("%2d[%2d]", i, lengths[i]);
			for (int j = 0; j < lengths[i]; ++j) {
				System.out.write(BAR);
			}
			System.out.write('\n');
		}
	}

	/**
	 * Counts the number of occurences of each digit, of white space characters
	 * (blank, tab, newline), and of all other characters.
	 *
	 * @throws IOException
	 */
	public void countEachDigit() throws IOException {

		int c;
		int nOthers = 0;
		int nSpaces = 0;
		int[] nDigits = new int[10];

		while ((c = System.in.read()) != EOF) {

			if (c == '\n' || c == '\t' || c == ' ') {
				++nSpaces;
			} else if (c >= '0' && c <= '9') {
				++nDigits[c - '0'];
			} else {
				++nOthers;
			}
		}
		System.out.printf("Digits: ");

		for (int i = 0; i < 10; ++i) {
			System.out.printf(" %d", nDigits[i]);
		}
		System.out.printf("\nSpaces: %d; Others: %d\n", nSpaces, nOthers);

	}

	/**
	 * Prints its input one word per line.
	 *
	 * @throws IOException
	 */
	public void printWordPerLine() throws IOException {
		int c = '\0';
		boolean inWord = false; /* is inside a word */

		while ((c = System.in.read()) != EOF) {
			if (!Character.isWhitespace(c)) {
				/* Is not a space */
				System.out.write(c);
				if (!inWord) {
					inWord = true;
				}

			} else {
				/* Is a space */
				if (inWord) {
					System.out.write('\n');
					inWord = false;
				}
			}
		}
	}

	/**
	 * Copies its input to its output, replacing each string of one or more
	 * blanks by a single blank.
	 *
	 * @throws Exception
	 */
	public void inToOut() throws Exception {

		int c;
		boolean inBlank = false;

		while ((c = System.in.read()) != EOF) {
			if (c == ' ') {
				if (!inBlank) {
					System.out.write(c);
					inBlank = true;
				}
			} else {
				/* Not a blank */
				System.out.write(c);
				inBlank = false;
			}
		}
	}

	/**
	 * Counts characters, tabs, blanks, words, and lines in input.
	 *
	 * @throws Exception
	 */
	public void countCharacters() throws Exception {

		int c;
		int nc = 0; /* characters */
		int nl = 0; /* newlines */
		int nt = 0; /* tabs */
		int nb = 0; /* blanks */
		int nw = 0; /* words */
		boolean inWord = false; /* is inside a word */

		while ((c = System.in.read()) != EOF) {
			++nc;
			if (!Character.isWhitespace(c)) {
				/* Is not a space */
				if (!inWord) {
					++nw;
					inWord = true;
				}
			} else {
				/* Is a space */
				if (c == '\n') {
					++nl;
				} else if (c == '\t') {
					++nt;
				} else if (c == ' ') {
					++nb;
				}

				inWord = false;
			}
		}
		System.out.printf("nc: %d\tnt: %d\tnb: %d\tnl: %d\tnw: %d\n", nc, nt, nb, nl, nw);
	}
}
