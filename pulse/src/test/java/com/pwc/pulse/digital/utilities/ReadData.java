package com.pwc.pulse.digital.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
 * Purpose of this class is to fetch values from .properties file
 */
public class ReadData {

	/*
	 * This method return the props object and it will read the the config
	 * properties file
	 */
	public Properties readPropfie() {

		// Get the user directory
		String Path = System.getProperty("user.dir");

		// Get the config.properties file from the location
		File file = new File(Path + "/src/test/resources/properties/config.properties");
		FileInputStream input = null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;

	}

	/*
	 * This method return the props object and it will read the the
	 * TestData.properties file
	 */
	public Properties readTestData() {

		// Get the user directory
		String Path = System.getProperty("user.dir");

		// Get the config.properties file from the location
		File file = new File(Path + "/src/test/resources/properties/testdata.properties");

		FileInputStream input = null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;

	}
}
