package com.bonjourcs.java.jc.aggregate.reduction;

import lombok.Data;

import java.util.stream.Stream;

/**
 * @author Liang Chenghao
 * Description: object for the use of reducting
 * Date: 2018/5/14
 */
@Data
public class People {

	/**
	 * age for people
	 */
	private int age;

	/**
	 * name for people
	 */
	private String name;

	public People(int age, String name) {
		this.age = age;
		this.name = name;
	}

	/**
	 * generate a people stream
	 *
	 * @return people stream
	 */
	public static Stream<People> people() {
		return Stream.of(new People(20, "Kim"),
				new People(21, "Alvin"),
				new People(22, "Jane"),
				new People(23, "John"));
	}

}
