package problemset;

class AsciiShapes {
	AsciiShapes() {
		for (int i = 1; i <= 8; i++) {
			for (int j = 0; j < Math.abs(4 - i); j++) {
				putc(' ');
			}
			for (int j = 0; j < 4 - Math.abs(4 - i); j++) {
				putc('#');
			}
			putc('\n');
		}
	}

	private void putc(char c) {
		System.out.print(c);
	}
}
