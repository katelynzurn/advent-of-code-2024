package aoc2024.day3;

import java.io.InputStream;
import java.util.Scanner;

public class Day3 {

	private static String input;

	public static void populateArrays(InputStream inputStream) {
		input = "";
		// Check if the resource exists
		if (inputStream != null) {
			// Parse the text using a Scanner:
			try (Scanner scanner = new Scanner(inputStream)) {
				while (scanner.hasNextLine()) { //TODO: Update this to be... has next character??
					input = "string here";
					//TODO: Fill in logic
				}
			} catch (Exception e) {
				System.err.println("Error reading file: " + e.getMessage());
			}
		}
	}

}
