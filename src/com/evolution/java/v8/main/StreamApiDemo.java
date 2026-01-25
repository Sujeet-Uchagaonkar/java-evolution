package com.evolution.java.v8.main;

import com.evolution.java.v8.entity.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiDemo {

	public static void main(String[] args) {

		
		List<Integer> intList = new ArrayList<>();
		intList.addAll(Arrays.asList(15, 85, 66, 17, 11, 11, -26, -21));
		
		List<Integer> intListGreaterThan50 = intList.stream().filter(i -> i > 50).collect(Collectors.toList());
		System.out.println("Greater than 50 values in list: ");
		intListGreaterThan50.forEach(i -> System.out.println(i));

		List<Integer> intListMinusValues = intList.stream().filter(i -> i < 0).collect(Collectors.toList());
		System.out.println("Negative values in list: ");
		intListMinusValues.forEach(i -> System.out.println(i));
		
		List<Integer> intListPositiveValues = intList.stream().filter(i -> i>=0).collect(Collectors.toList());
		System.out.println("Positive values in list: ");
		intListPositiveValues.forEach(i -> System.out.println(i));
		
		
		Set<Integer> intUniquePositiveValues = new HashSet<>(intListPositiveValues);
		System.out.println("Positive unique values in list: ");
		intUniquePositiveValues.forEach(i -> System.out.println(i));
		
		
		

		Employee emp1 = new Employee(1, "abc");
		Employee emp2 = new Employee(2, "xyz");
		Employee emp3 = new Employee(3, "pqr");
		List<Employee> empList = new ArrayList<>(Arrays.asList(emp1, emp2, emp3));
		

		System.out.print("Employees with name contains y : ");
		empList.stream().filter(e -> e.getEmpName().contains("y")).limit(0).map(e -> e.getEmpName())
				.collect(Collectors.toList()).forEach(System.out::println);
		;

		System.out.print("Employees with emp id greater than 2 : ");
		empList.stream().filter(emp -> emp.getEmpId() > 2).map(e -> e.getEmpId()).collect(Collectors.toList())
				.forEach(System.out::println);
		
		
		
		System.out.print("Employees with name contains p : ");
		empList.stream().filter(e -> e.getEmpName().contains("p")).map(e -> e.getEmpName()).collect(Collectors.toList())
				.forEach(System.out::println);
		
		System.out.print("Employee id of xyz: ");
		empList.stream().filter(e -> e.getEmpName().equalsIgnoreCase("xyz")).map(e -> e.getEmpId()).forEach(System.out::println);;
		
		
		Map<Integer,String> empMap = new HashMap<>();
		empMap = empList.stream().collect(Collectors.toMap(e -> e.empId, e -> e.empName));
		System.out.print("Employee map values: ");
		empMap.entrySet().forEach(e -> System.out.println(e.getKey()+ " | "+e.getValue()));
		System.out.println("Does Employee map has emp with >2 id: "+empMap.entrySet().stream().anyMatch(e -> e.getKey()>3));
		System.out.println("Max key in emp map: "+Collections.max(empMap.keySet()));
		
		
		
		System.out.print("Sorted employee names : ");
		empList.stream().map(e -> e.getEmpName()).collect(Collectors.toList()).stream().sorted().forEach(System.out::println);
		
		
		
		System.out.println("Character counts for given string: ");
		String name = "Sujeet";
		Map<Character, Long> charCountMap = new HashMap<>();
		name.chars().mapToObj(c -> (char) c).distinct().collect(Collectors.toList()).forEach(
				
				ch -> charCountMap.put(ch, getCharCount(name, ch))
				);;
		
		charCountMap.entrySet().forEach(System.out::println);
		
		
		
		
		
		Stream.iterate(1, i -> i+1).filter(i -> i%3==0).limit(5).forEach(System.out::println);
		
		Stream.iterate(99, i -> i-1).limit(3).forEach(System.out::println);
		

	}

	public static long getCharCount(String str, Character c) {

		long count = str.chars().mapToObj(ch -> (char) ch).filter(ch -> (char) ch == c).count();
		//System.out.println("Count of "+c+" = "+count);
		return count;
	}

}