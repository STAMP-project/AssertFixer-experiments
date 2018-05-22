/*
 * Copyright 2013 Proofpoint Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.kairosdb.client.builder;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class DataPointTest
{

	@Test
	public void test_timestampNegative_valid()
	{
		DataPoint dataPoint = new DataPoint(-1, 3);

		assertThat(dataPoint.getTimestamp(), equalTo(-1L));
	}

	@Test
	public void test_timestampZero_valid()
	{
		DataPoint dataPoint = new DataPoint(0, 3);

		assertThat(dataPoint.getTimestamp(), equalTo(0L));
	}

	@Test
	public void test_constructor_longValue() throws DataFormatException
	{
		DataPoint dataPoint = new DataPoint(93939393, 30L);

		assertThat(dataPoint.longValue(), equalTo(30L));
		assertThat(dataPoint.getValue(), instanceOf(Long.class));
		assertThat(dataPoint.isIntegerValue(), equalTo(true));
		assertThat(dataPoint.isDoubleValue(), equalTo(false));
	}

	@Test
	public void test_constructor_doubleValue() throws DataFormatException
	{
		DataPoint dataPoint = new DataPoint(93939393, 30.3);

		assertThat(dataPoint.doubleValue(), equalTo(30.3));
		assertThat(dataPoint.getValue(), instanceOf(Double.class));
		assertThat(dataPoint.isIntegerValue(), equalTo(false));
		assertThat(dataPoint.isDoubleValue(), equalTo(true));
	}

	@Test
	public void test_constructor_integerValue() throws DataFormatException
	{
		DataPoint dataPoint = new DataPoint(93939393, 30);

		assertThat(dataPoint.longValue(), equalTo(30L));
		assertThat(dataPoint.getValue(), instanceOf(Integer.class));
		assertThat(dataPoint.isIntegerValue(), equalTo(true));
		assertThat(dataPoint.isDoubleValue(), equalTo(false));
	}

	@Test(expected = DataFormatException.class)
	public void test_longValue_wrong_type_invalid() throws DataFormatException
	{
		DataPoint dataPoint = new DataPoint(388383, "foo");

		dataPoint.longValue();
	}

	@Test(expected = DataFormatException.class)
	public void test_doubleValue_wrong_type_invalid() throws DataFormatException
	{
		DataPoint dataPoint = new DataPoint(388383, "foo");

		dataPoint.doubleValue();
	}

	@Test
	public void test_constructor_wholeValueIsDouble() throws DataFormatException
	{
		DataPoint dataPoint = new DataPoint(93939393, 5.0);

		assertThat(dataPoint.longValue(), equalTo(5L));
		assertThat(dataPoint.getValue(), instanceOf(Double.class));
		assertThat(dataPoint.isIntegerValue(), equalTo(true));
		assertThat(dataPoint.isDoubleValue(), equalTo(false));
	}

	@Test
	public void test_nullValue() throws DataFormatException
	{
		DataPoint dataPoint = new DataPoint(93939393, null);

		assertThat(dataPoint.getValue(), is(nullValue()));
		assertThat(dataPoint.isIntegerValue(), equalTo(false));
		assertThat(dataPoint.isDoubleValue(), equalTo(false));
	}

	@Test(expected = DataFormatException.class)
	public void test_nullValue_toDouble() throws DataFormatException
	{
		DataPoint dataPoint = new DataPoint(93939393, null);

		dataPoint.doubleValue();
	}

	@Test(expected = DataFormatException.class)
	public void test_nullValue_toLong() throws DataFormatException
	{
		DataPoint dataPoint = new DataPoint(93939393, null);

		dataPoint.longValue();
	}

	@Test(expected = DataFormatException.class)
	public void test_longValue_valueNull() throws DataFormatException
	{
		DataPoint dataPoint = new DataPoint(93939393, null);

		dataPoint.longValue();
	}

	@Test(expected = DataFormatException.class)
	public void test_doubleValue_valueNull() throws DataFormatException
	{
		DataPoint dataPoint = new DataPoint(93939393, null);

		dataPoint.doubleValue();
	}

	@Test(expected = DataFormatException.class)
	public void test_stringValue_valueNull() throws DataFormatException
	{
		DataPoint dataPoint = new DataPoint(93939393, null);

		dataPoint.stringValue();
	}
}