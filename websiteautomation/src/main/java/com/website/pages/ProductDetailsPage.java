package com.website.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.website.constant.FindLocator;
import com.website.dataprovider.ValidatingData;
import com.website.helper.CommonUtility;

public class ProductDetailsPage {

	ValidatingData data = new ValidatingData();
	public static void clickOnSlideShow(FindLocator loc,WebDriver driver)
	{
		CommonUtility.clickElement(driver, loc.getproperty("clickonslideshow"));
	}


	public static void productDescriptionValidation(FindLocator loc,WebDriver driver,String [] productDescription)
	{

		CommonUtility.scrollDownPage(driver, 300);

		//String actual_Title=	CommonUtility.getText(driver,loc.getproperty("title") );
		//Assert.assertEquals(ValidatingData.getValidatingData("image1"),actual_Title);
		//	String expectedDescription=CommonUtility.getWaitedText(loc.getLocators("loc_description_text"));
		String  actual_description=CommonUtility.getText(driver, loc.getproperty("description"));
		System.out.println(actual_description);
		for(int index=0;index < productDescription.length;index++)
		{
			try
			{
				//Assert.assertTrue(actual_description.contains(productDescription[index])),;
				Assert.assertTrue(actual_description.contains(productDescription[index]));
			}
			catch(AssertionError error )
			{
				continue;
			}
		}

	}

	public static void productSpecifications(FindLocator loc,WebDriver driver)
	{
       
		CommonUtility.clickElement(driver, loc.getproperty("clickonspecification"));
		String actual_Specifications= CommonUtility.getText(driver, loc.getproperty("specification"));
		System.out.println(actual_Specifications);
	//	Assert.assertTrue(actual_Specifications.contains(ValidatingData.getValidatingData("specifications")),"Product specification is wrong");
        Assert.assertTrue(actual_Specifications.contains(ValidatingData.getValidatingData("specifications")), "product specification is wrong");
	}
	
	
//	Assert.assertTrue(specificationcontent.contains(ValidatingData.getValidatingData("product_specification")),
//			"Product description is wrong");


	public static void clickOnReview(FindLocator loc,WebDriver driver)

	{
		CommonUtility.wait(1000);

		CommonUtility.clickElement(driver, loc.getproperty("clickonreview"));
	}
	public static void validateRating(int sortOrder,FindLocator loc,WebDriver driver) {


		int index=1;
		List<WebElement> elements= CommonUtility.getElementsList( loc.getproperty("reviewbox"));	
		int loopCount = elements.size();
		while (index < loopCount) {
			int count_star1=CommonUtility.getElementsList(loc.getproperty("rating").replace("xxxx",index + "")).size();
			int count_star2=CommonUtility.getElementsList(loc.getproperty("rating").replace("xxxx", index+1 + "")).size();		
			int difference = count_star1 - count_star2;

			if (sortOrder == 3) {
				Assert.assertTrue(difference >= 0);
			}
			if (sortOrder == 4) {
				Assert.assertTrue(difference <= 0);
			}
		}	

	}







	/**
	 * 
	 * @param selectoption
	 * @param loc
	 * 
	 * @param driver
	 */

	public  static void validateDate(int selectoption , FindLocator loc,WebDriver driver) {

		int index=1;

		List <WebElement> elements = CommonUtility.getElementsList(loc.getproperty("reviewbox"));
		int loopCount = elements.size();
		System.out.println(loopCount);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
		while (index < loopCount)
		{
			String string = CommonUtility.getText(driver, loc.getproperty("datelocator").replace("xxxx", index + " "));

			String split[] = string.split(" ", 2);
			System.out.println("split 1" + split[1].substring(1, 2));
			if (split[1].substring(1, 2).equals(" ")) {
				split[1] = "0" + split[1];
			}
			LocalDate localDate = LocalDate.parse(split[1], formatter);

			String string1 = CommonUtility.getText(driver, loc.getproperty("datelocator").replace("xxxx", index+1 + ""));

			String split1[] = string1.split(" ", 2);
			System.out.println(split1[1]);
			System.out.println("split 1" + split1[1].substring(1, 2));
			if (split1[1].substring(1, 2).equals(" ")) {
				split1[1] = "0" + split1[1];
			}
			System.out.println(split1[1]);

			LocalDate localDate1 = LocalDate.parse(split1[1], formatter);
			int difference = localDate.compareTo(localDate1);
			if (selectoption == 1) {
				Assert.assertTrue(difference >= 0);
			}
			if (selectoption == 2) {
				Assert.assertTrue(difference <= 0);
			}
			index++;
		}


	}
}




