package com.examples.pratha.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalExamples {

	public static void main(String[] args)throws Exception {

		List<Integer> list = new ArrayList<>(List.of(10, 20, 60));

		Optional<Double> avarage = calculateAvarage(list);
		//avarage.ifPresent(System.out::println);

		
	//	list.removeAll(list);
		
		Optional<Double> avarage2 = calculateAvarage(list);
	//	avarage2.ifPresent(System.out::println);
		
		int numbers[] = {40, 50,10};
	
		
	//calculateAvarage(numbers).ifPresent(System.out::println);
	//calculateAvarage().ifPresent(System.out::println);
   // System.out.println(	calculateAvarage().orElse(0.0));
   // System.out.println(calculateAvarage().get()); // if empty thrwo nosuchelement exception
		
		//System.out.println(calculateAvarage().orElseThrow()); // in case of empty, throw nosuchelementexception 
		//System.out.println(calculateAvarage().orElseThrow(() -> new Exception("custom exception"))); // in case of empty .. will throw supplier (custom exeception)


		System.out.println(calculateAvarage().orElseGet(()-> 2.0));

	}

	private static Optional<Double> calculateAvarage(List<Integer> list) {

		int totalNumbers = list.size();
		int sum = 0;

		for (int i : list) {
			sum += i;
		}

		double avarage = sum / totalNumbers;

		//System.out.println(Optional.empty()); // prints Optional.empty
		//System.out.println(Optional.of(null)); thow NullPointerException
		
		Optional<Double> myOptional = ((Double)avarage == null) ? Optional.empty() : Optional.of(avarage);
		myOptional.ofNullable(avarage);
		
		return myOptional;
		
		//return Optional.of((double)sum / totalNumbers);

	}
	
	private static Optional<Double> calculateAvarage(int... numbers ) {
		
		//System.out.println(numbers[0]);
		int sum =0;
		if (numbers.length == 0) {
			return Optional.empty();
		} else {
			for(int num : numbers) {
				sum += num;
			}
			return Optional.of((double)sum/numbers.length);
		}
		
	}

	
	

}
