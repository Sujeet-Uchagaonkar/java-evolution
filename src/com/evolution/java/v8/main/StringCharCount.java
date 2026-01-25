package com.evolution.java.v8.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringCharCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String str = sc.nextLine();
		Map<Character, Long> charCount = new HashMap<>();

		str.chars().mapToObj(ch -> (char) ch).distinct().collect(Collectors.toList())
				.forEach(ch -> charCount.put(ch, getCharCount(str, ch)));
		
		charCount.entrySet().forEach(System.out::println);
		
		sc.close();
	}

	public static long getCharCount(String str, Character ch) {

		return str.chars().mapToObj(c -> (char) c).collect(Collectors.toList()).stream().filter(c -> c == ch).count();
	}

}
