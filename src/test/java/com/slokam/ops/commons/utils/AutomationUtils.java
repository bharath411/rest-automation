package com.slokam.ops.commons.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class AutomationUtils {

	
	public static String getRandomAlphaNumaric(int size) {
		return RandomStringUtils.randomAlphanumeric(size);
	}
	
	public static String getRandomAlphabet(int size) {
		return RandomStringUtils.randomAlphabetic(size);
	}
}
