package com.website.dataprovider;

import java.io.IOException;
import java.util.Properties;

import com.website.constant.FileConstant;
import com.website.helper.CommonUtility;
import com.website.util.ReadPropertiesFile;

public class ValidatingData {
	
	static Properties Property;
	
	/**
	 * In this constructor, reading of property file is being done
	 */
	public ValidatingData() {
		try {
			
			Property=CommonUtility.propertyFileLoad(FileConstant.VALIDATION_FILE);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	/**
	 * In this method, validation data from the property file is taken
	 * 
	 * @param key
	 */
	public static String getValidatingData(String key) {
		String value = Property.getProperty(key);
		return value;
	}

}
