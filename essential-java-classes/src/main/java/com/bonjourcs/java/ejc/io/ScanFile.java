package com.bonjourcs.java.ejc.io;

import java.io.*;
import java.util.Scanner;

/**
 * @author Liang Chenghao
 * Description: use scanne to display the content of specifical file
 * Date: 2018/4/28
 */
public class ScanFile {

	/**
	 * get classpath
	 */
	private static final String path = ClassLoader.getSystemResource("").getPath();

	public static void main(String[] args) throws IOException {

		// get all content
		scanFile("file_read.txt");

		// get only numbers
		scanNumber("file_with_number.txt");

	}

	/**
	 * scan file content
	 *
	 * @param fileName file to scan
	 * @throws IOException exceptions
	 */
	private static void scanFile(String fileName) throws IOException {

		Scanner scanner = null;
		try {
			scanner = new Scanner(new BufferedReader(new FileReader(path + fileName)));

			while (scanner.hasNext()) {
				System.out.println(scanner.next());
			}
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}


	/**
	 * scan only integers
	 *
	 * @param fileName file to scan
	 * @throws IOException exceptions
	 */
	private static void scanNumber(String fileName) throws IOException {

		Scanner scanner = null;

		try {
			scanner = new Scanner(new BufferedReader(new FileReader(path + fileName)));
			while (scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					System.out.println(scanner.nextInt());
				} else {
					scanner.next();
				}
			}
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}
