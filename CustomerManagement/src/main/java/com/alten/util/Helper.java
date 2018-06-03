package com.alten.util;

import java.util.List;

import javax.naming.ConfigurationException;

/**
 * This class provides help methods used in this application.
 */
public final class Helper {

	/**
	 * The private constructor.
	 */
	private Helper() {
	}

	/**
	 * Check if the configuration is null or not.
	 *
	 * @param object
	 *            the object
	 * @param name
	 *            the fullName
	 * @throws ConfigurationException
	 *             if the configuration is null
	 */
	public static void checkConfigNotNull(Object object, String name) throws ConfigurationException {
		if (object == null) {
			throw new ConfigurationException(String.format("%s should be provided", name));
		}
	}

	/**
	 * It checks whether a given object is null.
	 *
	 * @param object
	 *            the object to be checked
	 * @param name
	 *            the fullName of the object, used in the exception message
	 * @throws IllegalArgumentException
	 *             the exception thrown when the object is null
	 */
	public static void checkNull(Object object, String name) throws IllegalArgumentException {
		if (object == null) {
			throw new IllegalArgumentException(String.format("%s should be provided", name));
		}
	}

	/**
	 * It checks whether a given string is null or empty.
	 *
	 * @param str
	 *            the string to be checked
	 * @return true if a given string is null or empty
	 * @throws IllegalArgumentException
	 *             throws if string is null or empty
	 */
	public static boolean isNullOrEmpty(String str) throws IllegalArgumentException {
		return str == null || str.trim().isEmpty();
	}

	/**
	 * It checks whether a given string is null or empty.
	 *
	 * @param str
	 *            the string to be checked
	 * @param name
	 *            the fullName of the string, used in the exception message
	 * @throws IllegalArgumentException
	 *             the exception thrown when the given string is null or empty
	 */
	public static void checkNullOrEmpty(String str, String name) throws IllegalArgumentException {
		if (isNullOrEmpty(str)) {
			throw new IllegalArgumentException(
					String.format("%s should be valid string(not null and not empty)", name));
		}
	}

	/**
	 * Check if the value is positive.
	 *
	 * @param value
	 *            the value to be checked
	 * @param name
	 *            the fullName of the value, used in the exception message
	 * @throws IllegalArgumentException
	 *             if the value is not positive
	 */
	public static void checkPositive(Long value, String name) {

		if (value <= 0) {
			throw new IllegalArgumentException(String.format("%s should be positive", name));
		}
	}
	

	/**
	 * Check if the value is greater than or equal to zero.
	 *
	 * @param value
	 *            the value to be checked
	 * @param name
	 *            the fullName of the value, used in the exception message
	 * @throws IllegalArgumentException
	 *             if the value is not positive
	 */
	public static void checkGreaterEqualZero(Long value, String name) {

		if (value < 0) {
			throw new IllegalArgumentException(String.format("%s should be greater than or equal to zero.", name));
		}
	}

	/**
	 * Creating Enum from string without checking the case sensitivity.
	 *
	 * @param enumClass
	 *            the Enum class that are used to create the Enum
	 * @param enumStringValue
	 *            the string value to be used in creating the Enum
	 * @return Enum created from the passed enumStringValue parameter
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Enum<T>> T BuildEnumFromString(Class<T> enumClass, String enumStringValue) {
		if (enumClass == null) {
			throw new IllegalArgumentException("EnumClass value can not be null!!");
		}

		for (Enum<?> enumValue : enumClass.getEnumConstants()) {
			if (enumValue.toString().equalsIgnoreCase(enumStringValue)) {
				return (T) enumValue;
			}
		}

		StringBuilder errorMessage = new StringBuilder(enumStringValue)
				.append(" is an invalid value, Supported values are (");
		boolean firstItem = true;
		for (Enum<?> enumValue : enumClass.getEnumConstants()) {
			if (firstItem) {
				firstItem = false;
				errorMessage.append(enumValue);
			} else {
				errorMessage.append(", ").append(enumValue);
			}
		}
		errorMessage.append(").");
		throw new IllegalArgumentException(errorMessage.toString());
	}

}
