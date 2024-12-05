package aoc2024.day1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day1 {

	private static List<Integer> column1;
	private static List<Integer> column2;

	public static void populateArrays(InputStream inputStream) {
		column1 = new ArrayList<>();
		column2 = new ArrayList<>();

		// Check if the resource exists
		if (inputStream != null) {
			// Parse the text using a Scanner:
			try (Scanner scanner = new Scanner(inputStream)) {

				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					String[] columns = line.split("\\t");
					if (columns.length >= 2) {
						// put the numbers into storage arrays so they can
						// be accessed and sorted later
						column1.add(Integer.parseInt(columns[0]));
						column2.add(Integer.parseInt(columns[1]));
					} else {
						System.out.println("Line does not have enough columns: " + line);
					}
				}
			} catch (Exception e) {
				System.err.println("Error reading file: " + e.getMessage());
			}
		} else {
			System.err.println("File not found, please check the filepath.");
		}

		Collections.sort(column1);
		Collections.sort(column2);

	}

	// Answer: 1341714
	public static int totalDistance() {
		Integer runningDistance = 0;
		for (int i = 0; i < column1.size(); i++) {
			Integer distance = Math.abs(column2.get(i) - column1.get(i));
			runningDistance = runningDistance + distance;
		}
		return runningDistance;

	}

	// Answer: 27384707
	public static int totalSimilarity() {
		// Iterate 2nd array into map where key is the # and value is the count
		// of how many times it appeared
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer num : column2) {
			if (map.containsKey(num)) { // value exists, increment count
				map.put(num, map.get(num) + 1);
			} else { // value doesn't exist, add it
				map.put(num, 1);
			}
		}

		// Iterate first array, check if map has value, multiply first array
		// value by map value, add to running sum
		int runningSimilarity = 0;
		for (Integer num : column1) {
			if (map.containsKey(num)) {
				// match from 1st array in the 2nd, multiply num by #
				// appearances
				runningSimilarity = runningSimilarity + (num * map.get(num));
			}
		}

		return runningSimilarity;
	}

}
