package com.konakart.dataprovider;

import java.io.IOException;
import java.util.Properties;

import com.konakart.constant.FileConstant;
import com.konakart.helper.CommonUtility;
import com.konakart.util.ReadPropertiesFile;

public class ValidatingData {
	
	static Properties Property;
	
	/**
	 * In this constructor, reading of property file is being done
	 */
	public ValidatingData() {
		try {
			
			Property=CommonUtility.propertyFileLoad(FileConstant.validationFile);
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
