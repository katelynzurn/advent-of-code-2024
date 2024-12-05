package aoc2024.day2;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {

	private static List<List<Integer>> inputArray;

	public static void populateArrays(InputStream inputStream) {
		inputArray = new ArrayList<>();
		// Check if the resource exists
		if (inputStream != null) {
			// Parse the text using a Scanner:
			try (Scanner scanner = new Scanner(inputStream)) {
				while (scanner.hasNextLine()) {
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

	// Answer: 202
	public static int calculateReportSafety() {
		int safeReportCount = 0;
		for (List<Integer> individualArray : inputArray) {
			if (isSafeReport(individualArray)) {
				// System.out.println("Array: " + individualArray.toString() + " --> true");
				safeReportCount++;
			}
		}

		return safeReportCount;
	}

	// Answer: 271
	public static int calculateReportSafetyWithDampener() {
		int safeReportCount = 0;
		for (List<Integer> individualArray : inputArray) {
			if (isSafeReport(individualArray)) {
				// System.out.println("Array: " + individualArray.toString() + " --> true");
				safeReportCount++;
			} else {
				// Loop through an remove 1 number from the list, check if safe and break if true
				// If we get through entire loop, then report unsafe
				// System.out.println("Unsafe report... parsing subset of: " + individualArray.toString());
				for (int i = 0; i < individualArray.size(); i++) {
					List<Integer> subsetList = new ArrayList<>();
					subsetList.addAll(individualArray);
					subsetList.remove(i);
					// System.out.println("Subset: " + subsetList.toString());
					if (isSafeReport(subsetList)) {
						safeReportCount++;
						break;
					}
				}
			}
		}

		return safeReportCount;
	}

	private static boolean isSafeReport(List<Integer> array) {
		boolean increasing = false;
		boolean decreasing = false;
		// go one less than the array length since we are comparing
		for (int i = 0; i < array.size() - 1; i++) {
			// check correct distance before computing increasing or decreasing
			if (correctDistance(array.get(i), array.get(i + 1))) {
				// must be all increasing or all decreasing
				if (array.get(i) < array.get(i + 1) && !decreasing) {
					increasing = true;
				} else if (array.get(i) > array.get(i + 1) && !increasing) {
					decreasing = true;
				} else {
					// increasing/decreasing conflict
					// immediately break out and return false
					return false;
				}

			} else {
				// incorrect distance
				// immediately beak out and return false
				return false;
			}
		}
		// if we get to end without breaking out on false return
		// we can return true that it is safe
		return true;
	}

	private static boolean correctDistance(int a, int b) {
		// must differ by between 1 to 3, cannot be 0 or 4
		if (Math.abs(a - b) < 4 && Math.abs(a - b) > 0) {
			return true;
		} else {
			return false;
		}
	}

}
