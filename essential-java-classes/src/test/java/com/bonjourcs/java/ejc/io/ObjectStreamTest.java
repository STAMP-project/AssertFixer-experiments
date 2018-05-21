package com.bonjourcs.java.ejc.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.ObjectInputStream;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/5/17
 */
public class ObjectStreamTest {

	@Test
	public void testWriteObject() throws IOException, ClassNotFoundException {
		ObjectStream.writeObject("object_file");
		MockObject mockObject = ObjectStream.readObject("object_file");
		Assert.assertEquals("OuterObject", mockObject.getObjectName());
		Assert.assertEquals("InnerObject", mockObject.getInnerName());
	}

}