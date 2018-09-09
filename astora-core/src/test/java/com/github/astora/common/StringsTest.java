package com.github.astora.common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringsTest {

    @Test
    public void isNullOrEmptyShouldReturnTrueWhenStringIsNull() {
        assertEquals(true, Strings.isNullOrEmpty(null));
    }

    @Test
    public void isNullOrEmptyShouldReturnTrueWhenStringIsEmpty() {
        assertEquals(true, Strings.isNullOrEmpty(""));
    }

    @Test
    public void isNullOrEmptyShouldReturnFalseWhenStringIsBlank() {
        assertEquals(false, Strings.isNullOrEmpty(" "));
    }

    @Test
    public void isNullOrBlankShouldReturnTrueWhenStringIsNull() {
        assertEquals(true, Strings.isNullOrBlank(null));
    }

    @Test
    public void isNullOrBlankShouldReturnTrueWhenStringIsEmpty() {
        assertEquals(true, Strings.isNullOrBlank(""));
    }

    @Test
    public void isNullOrBlankShouldReturnTrueWhenStringIsBlank() {
        assertEquals(true, Strings.isNullOrBlank(" "));
    }

    @Test
    public void shouldReturnUnderlyingCharArray() {
        String str = "foo";
        char[] result = Strings.underlyingCharArray(str);

        result[0] = 'b';
        result[1] = 'a';
        result[2] = 'r';

        assertEquals("bar", str);
    }

    @Test
    public void shouldReturnEmptyString() {
        assertEquals(true, Strings.empty().isEmpty());
    }
}
