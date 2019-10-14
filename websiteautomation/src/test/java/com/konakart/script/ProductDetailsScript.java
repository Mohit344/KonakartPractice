package com.konakart.script;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.konakart.constant.FindLocator;
import com.konakart.dataprovider.DataProviderData;
import com.konakart.dataprovider.ValidatingData;
import com.konakart.driver.DriverClass;
import com.konakart.helper.CommonUtility;
import com.konakart.pages.ProductDetailsPage;

public class ProductDetailsScript extends DriverClass {
	ValidatingData data = new ValidatingData();
	FindLocator loc = new FindLocator();
	@Test(priority = 1)
	/**
	 * method name -clickOnSlideShow
	 */
	public void clickOnSlideShow()
	{
		Logger log = Logger.getLogger(ProductDetailsScript.class);
		log.info("click on the slideshow");
		ProductDetailsPage.clickOnSlideShow(loc, driver);
	}
	@Test(priority = 2,  dataProvider = "productDescription", dataProviderClass = DataProviderData.class)
	/**
	 * method name-validateProduct
	 */
	public void validateProduct(String [] productDescription)

	{
		Logger log = Logger.getLogger(ProductDetailsScript.class);
		ProductDetailsPage.productDescriptionValidation(loc, driver, productDescription);
		log.info("validated productDescriptionValidation ");
		ProductDetailsPage.productSpecificationsValidation(loc, driver);
		log.info("validated productSpecificationsValidation ");
	}
	@Test(priority = 3)
	/**
	 * method name-clickOnProductReview
	 */
	public void clickOnProductReview()
	{
		Logger log = Logger.getLogger(ProductDetailsScript.class);
		log.info("click on the product review");
		ProductDetailsPage.clickOnReview(loc, driver);		
	}
	@Test(priority = 4,  dataProvider = "productReview", dataProviderClass = DataProviderData.class)
	/**
	 * method name-productReview
	 * @param sortby
	 */
	public void productReview(String sortby)
	{
		Logger log = Logger.getLogger(ProductDetailsScript.class);
		log.info("select the review option");
		CommonUtility.selectDropdown(driver, loc.getproperty("sortReview"), 2, sortby);
		log.info("selected the review option");
		ProductDetailsPage.validateDate(1, loc, driver);	
		log.info("validated the Date in sorted format");
		ProductDetailsPage.validateRating(3, loc, driver);
		log.info("validated the rating in sorted format");


	}



}
