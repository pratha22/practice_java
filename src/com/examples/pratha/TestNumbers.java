package com.examples.pratha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class TestNumbers {

	public static void main(String[] args) {

		// int a = 120, b = 12;

		// printLastTwoDigitsOfProduct(a,b);
		
		//List<Integer> numbers = new ArrayList<>(List.of(2, 1, 5, 6, 2, 3));
		//List<Integer> numbers = new ArrayList<>(List.of(4, 3, 2));
		List<Integer> numbers = new ArrayList<Integer>(List.of(7,3,1,6,5,6));

		//List<Integer> numbers = List.of(7,3,1,6,5,6);



		findBiggestRectAreaFromBarGraph(numbers);

		// findBiggestRectAreaFromBarGraph(Arrays.asList(2,1,5,6,2,3));

	}

	private static void findBiggestRectAreaFromBarGraph(List<Integer> numbers) {

		List<Integer> areaList = new ArrayList();

		while (numbers.size() > 0) {
			int size = numbers.size();
			int smallest = numbers.get(0); // assume first is smallest
			for (int i = 0; i < size; i++)
			{
				int number = numbers.get(i);
				if (number < smallest)
				{
					smallest = number;
				}
			}
			areaList.add(smallest * size);
			final int numToRemove = smallest;
			numbers.removeIf(n -> n == numToRemove);
		}

		int biggestArea = areaList.get(0); // assume first is biggest
		for (int area : areaList) {
			if (area > biggestArea) {
				biggestArea = area;
			}
		}
		System.out.println(biggestArea);
	}
	
	
	

	private static void findBiggestRectAreaFromBarGraph2(List<Integer> numbers) {
		
		numbers.sort(null);
		
		numbers.sort(Collections.reverseOrder());

		List<Integer> areaList = new ArrayList();

		while (numbers.size() > 0) {
			int size = numbers.size();
			int smallest = numbers.get(0); // assume first is smallest
			for (int i = 0; i < size; i++)
			{
				int number = numbers.get(i);
				if (number < smallest)
				{
					smallest = number;
				}
			}
			areaList.add(smallest * size);
			final int numToRemove = smallest;
			numbers.removeIf(n -> n == numToRemove);
		}

		int biggestArea = areaList.get(0); // assume first is biggest
		for (int area : areaList) {
			if (area > biggestArea) {
				biggestArea = area;
			}
		}
		System.out.println(biggestArea);
	}
	
	

	private static void printLastTwoDigitsOfProduct(int a, int b) {

		int product;

		product = a * b;

		int lastTwoDigits = product % 100;

		System.out.println("Product : " + product + " Last two digits : " + lastTwoDigits);

		System.out.printf("%02d\n", lastTwoDigits);

		String str = String.valueOf(product);

		int len = str.length();

		str.subSequence(len - 2, len);

		System.out.println("Product : " + product + " Last two digits : " + str.subSequence(len - 2, len));

	}

}
