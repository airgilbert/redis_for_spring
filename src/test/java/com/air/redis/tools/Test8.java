package com.air.redis.tools;

import java.util.Arrays;
import java.util.List;

public class Test8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(18, 13, 41, 16);
		// list.stream().map((i) -> i * 3).forEach(System.out::println);
		list.sort((x, y) -> y.compareTo(x));
		list.forEach(System.out::println);
		// list.stream().map((i) -> i = i * 3).forEach(System.out::println);
		// Integer result = list.stream().map((i) -> i * 3).reduce((sum, count) -> (sum
		// += count)).get();

		// list.forEach((i) -> System.out.println(i * 3));
		// // list.forEach(System.out::println);
		// System.out.println(result);
	}

}
