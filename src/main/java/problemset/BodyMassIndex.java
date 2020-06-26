package problemset;

/**
 * According to the Centre for Disease Control (CDC), Body Mass Index (BMI) is a
 * “reliable indicator of body fatness for most people and is used to screen for
 * weight categories that may lead to health problems.” An adult’s BMI is a
 * function of his or her weight and height, the formula for which is w / h^2 *
 * 703, where w is weight in pounds and h is height in inches. Adults’ weights
 * can be categorised by BMI per the table below.
 * <p>
 * <pre>
 * 	BMI		Status
 * < 18.5 Underweight
 * 18.5 – 24.9 Normal
 * 25.0 – 29.9 Overweight
 * > 29.9 Obese
 * </pre>
 */
public class BodyMassIndex {

	int weight = 110;
	int heightFeet = 5;
	int heightInches = 10;
	String[] status = new String[]{"Underweight", "Normal", "Overweight",
			"Obese"};

	BodyMassIndex() {
		System.out.printf("Body Mass Index\n");

		getInput();

		/* Convert feet/inches to feet. */
		float height = heightFeet + heightInches / 12.0f;
		System.out.printf("Height: %.1f feet.\n", height);

		/* Calculate the BMI. */
		float bmi = weight / (height * height) * 7.03f;
		
		/* Find out the status which corresponds the BMI. */
		int i = 0;
		if (bmi < 18.5)
			i = 0;
		else if (bmi >= 18.5 && bmi <= 24.9)
			i = 1;
		else if (bmi >= 25.0 && bmi <= 29.9)
			i = 2;
		else if (bmi > 29.9)
			i = 3;
		else {
			System.err.println("Couldn't calculate the BMI value.");
			System.exit(1);
		}

		System.out.printf("Your BMI is %.1f. You are %s.\n", bmi, status[i]);
	}

	private void getInput() {

		System.out.printf("Weight (pounds): ");
		while ((weight = ProblemSet.readInt()) < 1) {
			System.out.printf("Wrong value. Try again.\n");
		}

		System.out.printf("Height (feet): ");
		while ((heightFeet = ProblemSet.readInt()) < 1) {
			System.out.printf("Wrong value. Try again.\n");
		}

		System.out.printf("Height (inches): ");
		while ((heightInches = ProblemSet.readInt()) < 1) {
			System.out.printf("Wrong value. Try again.\n");
		}
	}
}
