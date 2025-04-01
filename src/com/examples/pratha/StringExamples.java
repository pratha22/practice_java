package com.examples.pratha;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringExamples {
	
	public static void main(String[] args) {

		List<String> listStr = Arrays.asList("Hi", "Hey", "Morning", "Good", "Hey", "Afternoon", "Night");

		// Using straem api, print unique strings in descending order
		printUniqueNamesInOrder(listStr);

	}

	private static void printUniqueNamesInOrder(List<String> listStr) {

		listStr.stream()
			.distinct()
			.sorted(Comparator.reverseOrder())
			.forEach(str -> System.out.println(str));
	}

}
