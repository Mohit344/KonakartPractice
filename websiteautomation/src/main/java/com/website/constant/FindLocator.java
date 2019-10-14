package com.website.constant;

import java.io.IOException;
import java.util.Properties;

import com.website.helper.CommonUtility;
import com.website.util.ReadPropertiesFile;


/**
 * Find locator class
 * @author Mohit.Jaiswal
 *
 */
public class FindLocator {


	static Properties homePageProperty;
	static Properties productdetail;

	public FindLocator() {
		try {
			
			//Assignsprop = ReadPropertiesFile.loadProperty(FileConstant.findlocator);// all the xpath to locate element .
			homePageProperty= CommonUtility.propertyFileLoad(FileConstant.findlocator);
		} catch (IOException e) {
			e.getMessage();
		}
	
	try {
		
		//Assignsprop = ReadPropertiesFile.loadProperty(FileConstant.findlocator);// all the xpath to locate element .
		productdetail= CommonUtility.propertyFileLoad(FileConstant.productdetail);
	} catch (IOException e) {
		e.getMessage();
	}
}

	
	
	
	
	public  String getlocator(String key)
	{
		String value=homePageProperty.getProperty(key);
		return value;

	}
	public  String getproperty(String key)
	{
		String value=productdetail.getProperty(key);
		return value;

	}
	
	

}
