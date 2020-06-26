package problemset;

/**
 * Convert temperature from Celsius to Fahrenheit or vice versa.
 */
public class TemperatureConverter {

	public TemperatureConverter() {

		convertTemperature('f', 122);
		convertTemperature('c', 50);
	}

	/**
	 * Converts temperature from Celsius to Fahrenheit or vice versa,
	 * and prints the result.
	 *
	 * @param mode        'c' or 'f'; specifies whether the given temperature is
	 *                    represented in Celsius or Fahrenheit
	 * @param temperature a real number representing the given temperature
	 * @return the converted temperature
	 */
	private float convertTemperature(char mode, float temperature) {
		if (mode == 'f') {
			float c = f2c(temperature);
			System.out.printf("%.1f F = %.1f C\n", temperature, c);
			return c;

		} else if (mode == 'c') {
			float f = c2f(temperature);
			System.out.printf("%.1f C = %.1f F\n", temperature, f);
			return f;

		} else {
			System.err.printf("Usage: convertTemperature(MODE, TEMPERATURE)\n");
			System.err.printf("	MODE: { 'f' | 'c' }\n");
			System.err.printf("	TEMPERATURE: a real number\n");
			System.exit(1);
			return -1;
		}
	}

	/**
	 * Converts temperature from Fahrenheit to Celsius.
	 *
	 * @param f Fahrenheit temperature
	 * @return Celsious temperature
	 */
	public static float f2c(float f) {
		return (f - 32) / (9.0f / 5.0f);
	}

	/**
	 * Converts temperature from Celsius to Fahrenheit.
	 *
	 * @param c Celsius temperature
	 * @return Fahrenheit temperature
	 */
	public static float c2f(float c) {
		return c * 9 / 5 + 32;
	}
}
