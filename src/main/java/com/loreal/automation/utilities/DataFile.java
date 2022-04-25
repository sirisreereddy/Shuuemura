package com.loreal.automation.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.loreal.automation.base.BaseTest;
import com.loreal.automation.exceptions.DataSheetException;

public class DataFile {
	
	Logger logger = LogManager.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());	/**
	 * 
	 * @param externalSheetPath
	 * --This argument is for passing the location of the input data file
	 * @return--Returns data object array which reads properties from the input data
	 *         file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	
	public Object[][] readFromFile(String externalSheetPath) throws FileNotFoundException, IOException {
		Object[][] dataMap = (Object[][]) null;
		Properties properties = new Properties();
		String globalBrowserFlag = BaseTest.getGlobalBrowserFlag();
		String executionStatus = null;
		LinkedHashMap<String, String> linkedMap1 = new LinkedHashMap<String, String>();
		//
		InputStream is = new FileInputStream(externalSheetPath);
		properties.load(is);
		executionStatus = properties.getProperty("ExecutionStatus");
		if (executionStatus.equalsIgnoreCase("Y")) {
			for (String Key : properties.stringPropertyNames()) {
				linkedMap1.put(Key, properties.getProperty(Key));
			}

			dataMap = new Object[][] { linkedMap1.keySet().toArray(), linkedMap1.values().toArray() };
		} else if (executionStatus.trim().equalsIgnoreCase("N")) {

		} else if (properties.getProperty("Execution Status").equalsIgnoreCase("")) {
			logger.error("Please enter either Y or N for execution status");
			throw new NullPointerException("Please enter either Y or N for execution status");
		} else {
			logger.error("Please enter either Y or N for execution status");
			throw new DataSheetException("Please enter either Y or N for execution status");
		}
		return dataMap;
	}

}
