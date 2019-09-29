package com.maven.test.EcommereceSite.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class ReadPropertyFiles {

	private static String configFilePath          =            "./Config/Config.properties";
	private static String locatorFilePath         =            "./OR/Locator.properties" ;


	/**
	 * @constructor
	 * */

	public ReadPropertyFiles(){}




	/**
	 * Function to read config file
	 * */

	public static String readConfigFile(String keyName) throws Exception {
		BufferedReader           reader     =   new    BufferedReader(new FileReader(configFilePath));
		Properties               config       =   new    Properties();

		try {
			config.load(reader);
			String value = config.getProperty(keyName);
			reader.close();
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(keyName + "not found in Config file");
		}

	}



	/**
	 * Function to read Locator file
	 * */

	public static String readLocatorsFile(String keyName) throws Exception {
		BufferedReader           reader     =   new    BufferedReader(new FileReader(locatorFilePath));
		Properties               config       =   new    Properties();

		try {
			config.load(reader);
			String value = config.getProperty(keyName);
			reader.close();
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(keyName + "not found in Locators file");
		}


	}


}




