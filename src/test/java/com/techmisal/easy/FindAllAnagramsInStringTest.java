package com.techmisal.easy;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindAllAnagramsInStringTest {

	private FindAllAnagramsInString findAllAnagramsInString = new FindAllAnagramsInString();

	@Test
	public void testIsAnagram() {
		Assert.assertEquals(Arrays.asList(0, 6), findAllAnagramsInString.findAnagrams("cbaebabacd", "abc"));
		Assert.assertEquals(Arrays.asList(0, 1, 2), findAllAnagramsInString.findAnagrams("abab", "ab"));
		Assert.assertEquals(new ArrayList<>(), findAllAnagramsInString.findAnagrams("", "ab"));
	}
}
