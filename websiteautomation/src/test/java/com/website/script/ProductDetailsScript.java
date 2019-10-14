package com.website.script;

import org.testng.annotations.Test;

import com.website.constant.FindLocator;
import com.website.dataprovider.DataProviderData;
import com.website.dataprovider.ValidatingData;
import com.website.driver.DriverClass;
import com.website.helper.CommonUtility;
import com.website.pages.ProductDetailsPage;

public class ProductDetailsScript extends DriverClass {
	ValidatingData data = new ValidatingData();
	FindLocator loc = new FindLocator();
	@Test(priority = 1)
	public void clickOnSlideShow()
	{

		CommonUtility.clickElement(driver, loc.getproperty("clickonslideshow"));
		
	}
	@Test(priority = 2,  dataProvider = "productdescription", dataProviderClass = DataProviderData.class)
	
	public void validateProduct(String [] productDescription)
	
	{
		
		ProductDetailsPage.productDescriptionValidation(loc, driver, productDescription);
		ProductDetailsPage.productSpecifications(loc, driver);
		
		
	}
	@Test(priority = 3)
	public void clickOnProductReview()
	{
		
	CommonUtility.clickElement(driver, loc.getproperty("clickonreview"));
		
	}
	@Test(priority = 4,  dataProvider = "productReview", dataProviderClass = DataProviderData.class)
	
	public void productReview(String sortby)
	{
	System.out.println(loc.getproperty("sortReview"));
	
	CommonUtility.selectDropdown(driver, loc.getproperty("sortReview"), 2, sortby);

    ProductDetailsPage.validateDate(1, loc, driver);	
   
    ProductDetailsPage.validateRating(3, loc, driver);
		
		
	}
	
	
	
}
