package com.bonjourcs.java.ejc.io;

import java.io.*;
import java.util.Date;

/**
 * @author Liang Chenghao
 * Description: read/write object
 * Date: 2018/5/17
 */
public class ObjectStream {

	/**
	 * write object to file
	 *
	 * @param fileName file to save
	 */
	public static void writeObject(String fileName) throws IOException {

		String classPath = ClassLoader.getSystemResource("").getPath();
		ObjectOutputStream objectOutputStream
				= new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(classPath + fileName)));

		MockObject mockObject
				= new MockObject();
		mockObject.setObjectName("OuterObject");
		mockObject.setMarkDate(new Date(System.currentTimeMillis()));

		mockObject.setInnerObject("InnerObject", new Date(System.currentTimeMillis()));

		objectOutputStream.writeObject(mockObject);
		objectOutputStream.close();

	}

	/**
	 * read object from file
	 *
	 * @param fileName file to read object
	 * @return a MockObject instance
	 * @throws IOException            read file exception
	 * @throws ClassNotFoundException cast object exception
	 */
	public static MockObject readObject(String fileName) throws IOException, ClassNotFoundException {

		String classPath = ClassLoader.getSystemResource("").getPath();
		ObjectInputStream objectInputStream
				= new ObjectInputStream(new BufferedInputStream(new FileInputStream(classPath + fileName)));

		return (MockObject) objectInputStream.readObject();
	}

}
