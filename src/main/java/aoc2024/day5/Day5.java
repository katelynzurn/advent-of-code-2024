package aoc2024.day5;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5 {

	private static List<List<Integer>> inputArray;

	public static void populateArrays(InputStream inputStream) {
		inputArray = new ArrayList<>();
		// Check if the resource exists
		if (inputStream != null) {
			// Parse the text using a Scanner:
			try (Scanner scanner = new Scanner(inputStream)) {
				while (scanner.hasNextLine()) {
					//TODO: Need to check white space for rules vs pages
					//How to store rules?? 
					String line = scanner.nextLine();

					ArrayList<Integer> row = new ArrayList<>();
					String[] elements = line.split(" ");
					for (String element : elements) {
						row.add(Integer.parseInt(element));
					}
					inputArray.add(row);
				}
			} catch (Exception e) {
				System.err.println("Error reading file: " + e.getMessage());
			}
		}
	}

}
