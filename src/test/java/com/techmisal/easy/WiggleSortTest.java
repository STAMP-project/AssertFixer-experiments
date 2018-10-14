package com.techmisal.easy;

import org.junit.Assert;
import org.junit.Test;

public class WiggleSortTest {
	private WiggleSort wigglesort = new WiggleSort();

	@Test
	public void testWiggleSort() {
		int[] testcase1 = {1, 2, 3, 4, 5, 6}; //multiple solutions
		int[] rescase1 = {1, 4, 2, 5, 3, 6}; //one chosen

		int[] testcase2 = {1, 2, 1, 1, 2, 2}; //only one solution
		int[] rescase2 = {1, 2, 1, 2, 1, 2};

		int[] testcase3 = {1, 2, 2, 3}; //no solution
		int[] rescase3 = null;

		Assert.assertEquals( rescase1, wigglesort.sort(testcase1) );
		Assert.assertEquals( rescase2, wigglesort.sort(testcase2) );
		Assert.assertEquals( rescase3, wigglesort.sort(testcase3) );
	}
}