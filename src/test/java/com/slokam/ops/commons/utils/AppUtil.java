package com.slokam.ops.commons.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppUtil {

	Properties props = null;

	public AppUtil() {
		File file = new File("./src/test/resources/application.properties");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			props = new Properties();
			props.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public String getProperty(String key) {
		return props.getProperty(key);
	}
}
