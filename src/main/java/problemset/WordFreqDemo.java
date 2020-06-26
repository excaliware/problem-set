package problemset;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordFreqDemo {

	public WordFreqDemo(String fileName) {

		Pattern pattern = Pattern.compile("\\W+");
		Comparator<Map.Entry<String, Long>> comparator = Map.Entry.comparingByValue();
		comparator = comparator.reversed();

		try {
			Files.lines(Paths.get(fileName))
					.parallel()
					.flatMap((l) -> pattern.splitAsStream(l))
					.filter((w) -> w.length() > 0)
					.map((w) -> w.toLowerCase())
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
					.entrySet().stream()
					.sorted(comparator)
					.forEach((e) -> System.out.printf("%d %s\n", e.getValue(), e.getKey()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
