package com.bonjourcs.java.ejc.io;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/5/17
 */
public class DataStreamTest {

	@Test
	public void testWriteData() throws IOException {
		DataStream.writeData("data_stream.dat");
		DataStream.readData("data_stream.dat", 6);
	}

}