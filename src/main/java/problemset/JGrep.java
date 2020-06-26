package problemset;

import java.io.*;
import java.util.regex.Pattern;

class JGrep {

	static public void main(String argv[]) {

		switch (argv.length) {
			case 0:
				System.err.printf("Usage: jgrep pattern [file]\n");
				System.exit(2);
			case 1:
				new JGrep(argv[0], null);
				break;
			default:
				new JGrep(argv[0], argv[1]);
		}
	}

	JGrep(String pattern, String file) {

		BufferedReader in = null;

		try {
			if (file == null) {
				in = new BufferedReader(new InputStreamReader(System.in));
			} else {
				in = new BufferedReader(new FileReader(file));
			}
			System.exit(grep(pattern, in));

		} catch (FileNotFoundException e) {
			System.err.printf("JGrep: %s: file not found\n", file);
			System.exit(2);
		} catch (IOException e) {
			System.err.printf("JGrep: I/O error\n");
			e.printStackTrace();
			System.exit(2);
		} finally {
			if (file != null && in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.err.printf("JGrep: I/O error\n");
					e.printStackTrace();
					System.exit(2);
				}

			}
		}
	}

	private int grep(String regex, BufferedReader in) throws IOException {

		boolean found = false;
		Pattern pattern = Pattern.compile(regex);
		String line;

		while ((line = in.readLine()) != null) {
			if (pattern.matcher(line).find()) {
				found = true;
				System.out.printf("%s\n", line);
			}
		}

		return found ? 0 : 1;
	}
}
