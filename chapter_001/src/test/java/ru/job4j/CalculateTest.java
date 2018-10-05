package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Test
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *@version $Id$
 *@since 0.1
 */
public class CalculateTest {
	/**
	 *Test echo.
	 */ @Test
	public void whenTakeNameThenThreeEchoPlusName() {
		String input = "Svetlana Egorova";
		String expect = "Echo, echo, echo : Svetlana Egorova";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}