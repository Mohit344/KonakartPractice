package com.konakart.pages;

import org.openqa.selenium.WebDriver;

import com.konakart.constant.FindLocator;
import com.konakart.helper.CommonUtility;
import com.konakart.validation.ValidationMethod;

public class HomePage {

	/**
	 * method - searchProduct
	 * @param productType
	 * @param productName
	 * @param loc
	 * @param driver
	 */
	public static void searchProduct(String productType , String productName,FindLocator loc,WebDriver driver)
	{



		CommonUtility.selectDropdown(driver, loc.getlocator("selectoption"), 2, productType);
		CommonUtility.clickAndSendText(driver, loc.getlocator("search"), 2, productName);
		CommonUtility.clickElement(driver, loc.getlocator("searchbutton"));
	}

	/**
	 * method-SearchMoreItem
	 * @param productType
	 * @param itemName
	 * @param loc
	 * @param driver
	 */
	public static void SearchMoreItem(String productType,String itemName,FindLocator loc,WebDriver driver )
	{

		CommonUtility.selectDropdown(driver, loc.getlocator("selectoption"), 2, productType);
		CommonUtility.clickAndSendText(driver, loc.getlocator("search"), 2, itemName);
		CommonUtility.clickElement(driver, loc.getlocator("searchbutton"));


	}

	/**
	 * method-validateProductName
	 * @param loc
	 * @param driver
	 * @param productName
	 */
	public static void validateProductName(FindLocator loc,WebDriver driver,String productName)
	{
		String actual_productName=CommonUtility.getText(driver, loc.getlocator("productname"));
		ValidationMethod.verify(actual_productName, productName, "not matched");

	}
	/**
	 * 
	 * method-validateProductPrice
	 * @param loc
	 * @param driver
	 * @param productPrice
	 */
	public static void   validateProductPrice(FindLocator loc,WebDriver driver,String productPrice ) {
		String actual_productPrice=CommonUtility.getText(driver, loc.getlocator("productprice"));
		System.out.println(actual_productPrice);
		ValidationMethod.verify(actual_productPrice, productPrice, "not matched");


	}
	/**
	 * method-validateMessage
	 * @param loc
	 * @param driver
	 * @param message
	 */
	public static void validateMessage(FindLocator loc,WebDriver driver,String message )
	{

		String  actual_message=CommonUtility.getText(driver,loc.getlocator("errormessage"));
		ValidationMethod.verify(actual_message, message, "not matched");
	}




}
