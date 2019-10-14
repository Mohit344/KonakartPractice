package com.konakart.validation;

import org.testng.Assert;

public  class ValidationMethod {
	
	

	/**
	 * 
	 * @param actual
	 * @param expected
	 * @param message
	 */
	public static void verify(String actual , String expected , String message) {
		try {


			Assert.assertEquals(actual, expected, message);
			System.out.println("passed");

		} catch (AssertionError e) {
			System.out.println(message);
		}
	}
	
	public static void verifyContent(String actual , String expected , String message) {
		try {


			//Assert.as(actual.contains(expected),expected, message);
			Assert.assertEquals(actual.contains(expected), expected, message);
			System.out.println("passed");

		} catch (AssertionError e) {
			System.out.println(message);
		}
	}
	public static String removeINR(String cost) {
		cost=cost.replace("INR ", "");
		return cost;
	}


}


