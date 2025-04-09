package com.examples.pratha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringExampls01 {

	public static void main(String[] args) {

		String str = "Pratha Budhrani Bhatia";
		//printOccuranceOfChar1(str);
		//printOccuranceOfChar2(str);

		printOccuranceOfChar3(str);


	}

	private static void printOccuranceOfChar3(String str) {
		/*
				Map<Object,Long> hmap = Arrays.stream(str.split(""))
			.collect(
					Collectors
					.groupingBy(s->s,LinkedHashMap::new,Collectors.counting())
					); */
				
				
				Arrays.stream(str.split(""));
		
	}

	private static void printOccuranceOfChar2(String str) {
		str = str.toLowerCase().replaceAll("\\s+", "");
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int len = str.length();

		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) +1);
		}
        

        // Print the frequencies of characters
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

		
	}

	public static void printOccuranceOfChar1(String str) {
		str = str.toLowerCase().replaceAll("\\s+", "");
;
		System.out.println(str);
		int len = str.length();
		HashSet<Character> set = new HashSet();
		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);
			if (!set.contains(ch)) {

				List list = new ArrayList();
				list.add(ch);
				set.add(ch);

				for (int j = i + 1; j < len; j++) {

					if (ch == str.charAt(j)) {
						list.add(ch);
					}

				}
				System.out.println(ch + " : " + list.size());
			}

		}
	}
}
