package ru.job4j.calculator;
/**
 *Конвертер валюты.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *@version $Id$
 *@since 0.1
 */

public class Converter {
	/**
	 * Конвертируем рубли в евро.
	 * @param value рубли.
	 * @return Евро.
	 */
	public double rubleToEuro(int value) {
	    return (double) value / 70; }
	/**
	 * Конвертируем евро в рубли.
	 * @param value евро.
	 * @return Рубли.
	 */
	public double euroToRuble(int value) {
		return (double) value * 70;
	}
	/**
	 * Конвертируем рубли в доллары.
	 * @param value рубли.
	 * @return Доллары.
	 */
	public double rubleToDollar(int value) {
	    return (double) value / 60; }
	/**
	 * Конвертируем доллары в рубли.
	 * @param value доллары.
	 * @return Рубли.
	 */
	public double dollarToRuble(int value) {
		return (double) value * 60;
	}
}