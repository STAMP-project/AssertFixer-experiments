package com.techmisal.easy;

import com.techmisal.easy.ValidAnagram;
import org.junit.Assert;
import org.junit.Test;

public class ValidAnagramTest {

	private ValidAnagram validAnagram = new ValidAnagram();

	@Test
	public void testIsAnagram() {

		Assert.assertTrue(validAnagram.isAnagram("anagram", "nagaram"));
		Assert.assertFalse(validAnagram.isAnagram("rat", "car"));
		Assert.assertFalse(validAnagram.isAnagram("ccac", "aacc"));
		Assert.assertFalse(validAnagram.isAnagram("abc", "abcd"));

	}

}
