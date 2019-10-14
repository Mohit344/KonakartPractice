package com.website.script;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;


import com.website.constant.FindLocator;
import com.website.dataprovider.DataProviderData;
import com.website.driver.DriverClass;
import com.website.helper.CommonUtility;

import com.website.pages.HomePage;

public class HomePageScript extends DriverClass {
	FindLocator loc = new FindLocator();

	@Test(priority = 1,  dataProvider = "productdetail", dataProviderClass = DataProviderData.class)
	/**
	 * 
	 * @param productType
	 * @param productName
	 * @param productPrice
	 * @param itemName
	 * @param message
	 */
	public void click(String productType,String productName,String productPrice,String itemName,String message)
	{
		Logger log = Logger.getLogger(HomePageScript.class);
		log.info("search for the product");
		HomePage.searchProduct(productType, productName, loc, driver);
		log.info("validating the name of product");
		HomePage.validateProductName(loc, driver, productName);	
		log.info("validating the price of  product");
		HomePage.validateProductPrice(loc, driver, productPrice);
		log.info("searching for  more product");
		HomePage.SearchMoreItem(productType, itemName, loc, driver);
		log.info("validating the message");
		HomePage.validateMessage(loc, driver, message);
       
	}



}
