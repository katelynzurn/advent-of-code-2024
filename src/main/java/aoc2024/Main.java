package aoc2024;

import java.io.InputStream;

import aoc2024.day1.Day1;
import aoc2024.day2.Day2;

public class Main {

	public static void main(String[] args) {

		// Day 1 File Parsing
		InputStream inputStreamDay1 = getInputStream("/aoc2024/day1/Day1.txt");
		Day1.populateArrays(inputStreamDay1);
		// Puzzle 1 Execution
		System.out.println(Day1.totalDistance());
		// Puzzle 2 Execution
		System.out.println(Day1.totalSimilarity());

		// Day 2 File Parsing
		InputStream inputStreamDay2 = getInputStream("/aoc2024/day2/Day2.txt");
		Day2.populateArrays(inputStreamDay2);
		// Puzzle 1 Execution
		System.out.println(Day2.calculateReportSafety());
		// Puzzle 2 Execution
		System.out.println(Day2.calculateReportSafetyWithDampener());

	}

	private static InputStream getInputStream(String filePath) {
		return Main.class.getResourceAsStream(filePath);

	}

}
