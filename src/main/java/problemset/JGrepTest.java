package problemset;

import java.lang.reflect.Field;

public class JGrepTest {
	public static void main(String[] argv) {
		String fileName = "src/main/java/problemset/WordFreqDemo.java";
		new WordFreqDemo(fileName);
//		testGetCharArray();
	}

	private static void testGetCharArray() {
		String str = "test";
		char[] a = getCharArray(str);
		a[3] = 'X';
		System.out.printf("%s\n", str);
	}

	static char[] getCharArray(String str) {
		char[] a = null;
		try {
			Field value = str.getClass().getDeclaredField("value");
			value.setAccessible(true);
			a = (char[]) value.get(str);

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return a;
	}
}
