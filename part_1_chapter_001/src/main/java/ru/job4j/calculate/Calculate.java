package ru.job4j.calculate;
/**
 *@author Egor Novikov (e.novikov@yahoo.com)
 *Метод main выводит надпись Hello World.
 */
public class Calculate {
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	/**
	 * @param name Your name.
	 * @return Echo plus your name.
	 */
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
}