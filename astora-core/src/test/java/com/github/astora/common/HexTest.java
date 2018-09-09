package com.github.astora.common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HexTest {

    @Test
    public void shouldConvertIntToHex() {
        assertEquals("7fffffff", Hex.toHexString(Integer.MAX_VALUE));
        assertEquals("80000000", Hex.toHexString(Integer.MIN_VALUE));
        assertEquals("00000000", Hex.toHexString(0));
    }

    @Test
    public void shouldConvertLongToHex() {
        assertEquals("7fffffffffffffff", Hex.toHexString(Long.MAX_VALUE));
        assertEquals("8000000000000000", Hex.toHexString(Long.MIN_VALUE));
        assertEquals("0000000000000000", Hex.toHexString(0L));
    }

    @Test
    public void shouldConvertByteArrayToHex() {
        assertEquals("", Hex.toHexString(new byte[0]));
        assertEquals("112233445566778899aabbccddeeff", Hex.toHexString(
                new byte[]{0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff}));
    }
}
