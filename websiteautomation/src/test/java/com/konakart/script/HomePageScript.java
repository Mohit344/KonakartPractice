package com.konakart.script;
import org.apache.log4j.Logger;

import org.testng.annotations.Test;
import com.konakart.constant.FindLocator;
import com.konakart.dataprovider.DataProviderData;
import com.konakart.driver.DriverClass;
import com.konakart.extentreports.ExtentReport;
import com.konakart.pages.HomePage;

public class HomePageScript extends DriverClass {
	FindLocator loc = new FindLocator();

	@Test(priority = 1,  dataProvider = "homePage", dataProviderClass = DataProviderData.class)
	/**
	 * method name-searchProduct
	 * @param productType
	 * @param productName
	 * @param productPrice
	 * @param itemName
	 * @param message
	 */
	public void validateSearchedProduct(String productType,String productName,String productPrice,String itemName,String message)
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
		ExtentReport.reportLog("validateSearchedProduct", "this validateSearchedProduct method failed ");
 
	}
//	@Test(priority = 2)
//	public void closeBrowser()
//	{
//		
//		driver.quit();
//	}
//	



}
