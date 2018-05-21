package com.bonjourcs.java.ejc.io;

import java.io.*;

/**
 * @author Liang Chenghao
 * Description: stream to read/write data
 * Date: 2018/5/17
 */
public class DataStream {

	/**
	 * write data into file
	 *
	 * @param fileName file name
	 * @throws IOException exception
	 */
	public static void writeData(String fileName) throws IOException {

		int[] ints = {1, 2, 3, 4, 5, 6};
		double[] doubles = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
		String[] strings = {"1s", "2s", "3s", "4s", "5s", "6s"};

		String classPath = ClassLoader.getSystemResource("").getPath();
		DataOutputStream dataOutputStream
				= new DataOutputStream(new BufferedOutputStream(new FileOutputStream(classPath + fileName)));

		for (int i = 0; i < ints.length; i++) {
			dataOutputStream.writeInt(ints[i]);
			dataOutputStream.writeDouble(doubles[i]);
			dataOutputStream.writeUTF(strings[i]);
		}

		dataOutputStream.close();

	}

	/**
	 * read data from file
	 *
	 * @param fileName file to read
	 * @param length   read length
	 * @throws IOException exception
	 */
	public static void readData(String fileName, int length) throws IOException {

		String classPath = ClassLoader.getSystemResource("").getPath();
		DataInputStream dataInputStream
				= new DataInputStream(new BufferedInputStream(new FileInputStream(classPath + fileName)));

		for (int i = 0; i < length; i++) {
			System.out.print("Read data: ");
			System.out.print(dataInputStream.readInt() + "\t" + dataInputStream.readDouble()
					+ "\t" + dataInputStream.readUTF() + "\n");
		}

		dataInputStream.close();
	}

}
