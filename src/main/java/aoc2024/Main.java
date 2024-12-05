package aoc2024;

import java.io.InputStream;

import aoc2024.day1.Day1;
import aoc2024.day2.Day2;
import aoc2024.day3.Day3;
import aoc2024.day4.Day4;
import aoc2024.day5.Day5;

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

		// Day 3 File Parsing
		InputStream inputStreamDay3 = getInputStream("/aoc2024/day3/Day3.txt");
		Day3.populateArrays(inputStreamDay3);
		// Puzzle 1 Execution
		// System.out.println(Day3.puzzle1());
		// Puzzle 2 Execution
		// System.out.println(Day3.puzzle2());

		// Day 4 File Parsing
		InputStream inputStreamDay4 = getInputStream("/aoc2024/day4/Day4.txt");
		Day4.populateArrays(inputStreamDay4);
		// Puzzle 1 Execution
		// System.out.println(Day4.puzzle1());
		// Puzzle 2 Execution
		// System.out.println(Day4.puzzle2());

		// Day 5 File Parsing
		InputStream inputStreamDay5 = getInputStream("/aoc2024/day5/Day5.txt");
		Day5.populateArrays(inputStreamDay5);
		// Puzzle 1 Execution
		// System.out.println(Day5.puzzle1());
		// Puzzle 2 Execution
		// System.out.println(Day5.puzzle2());

	}

	private static InputStream getInputStream(String filePath) {
		return Main.class.getResourceAsStream(filePath);

	}

}
