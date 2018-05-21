package com.bonjourcs.java.jc.aggregate.reduction;

import org.junit.Test;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Liang Chenghao
 * Description: more stream operation
 * Date: 2018/5/14
 */
public class PeopleTest {

	@Test
	public void testCollectToMap() {
		Map<Integer, String> ageToName = People.people()
				.collect(Collectors.toMap(People::getAge, People::getName));
		ageToName.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
	}

}