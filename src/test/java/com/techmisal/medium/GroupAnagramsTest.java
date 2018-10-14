package com.techmisal.medium;

import org.junit.Assert;
import org.junit.Test;

public class GroupAnagramsTest {

	private GroupAnagrams groupAnagrams = new GroupAnagrams();

	@Test
	public void testGroupAnagrams() {
		Assert.assertEquals(3, groupAnagrams.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}).size());
	}
}
