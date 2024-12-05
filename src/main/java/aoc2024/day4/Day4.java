package aoc2024.day4;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4 {

	private static List<List<String>> inputArray;

	//TODO: Might need this to be a 2d String[][] array?
	public static void populateArrays(InputStream inputStream) {
		inputArray = new ArrayList<>();
		// Check if the resource exists
		if (inputStream != null) {
			// Parse the text using a Scanner:
			try (Scanner scanner = new Scanner(inputStream)) {
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();

					ArrayList<String> row = new ArrayList<>();
					String[] elements = line.split(" ");
					for (String element : elements) {
						row.add(element);
					}
					inputArray.add(row);
				}
			} catch (Exception e) {
				System.err.println("Error reading file: " + e.getMessage());
			}
		}
	}

}
