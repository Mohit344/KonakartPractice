package com.konakart.extentreports;



import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.konakart.constant.FileConstant;


/**
 * In this class, extent report is made
 */

public class ExtentReport   {
	static ExtentHtmlReporter reporter = new ExtentHtmlReporter(FileConstant.extentreport);
	static ExtentReports extent = new ExtentReports();

	public static void reportLog(String testname, String Failuremsg) {
	extent.attachReporter(reporter);
	ExtentTest logger = extent.createTest(testname);
	logger.log(Status.INFO, testname);
	logger.log(Status.PASS, testname);
	/*
	* logger.log(Status.FAIL, Failuremsg); logger.fail("failed script",
	* MediaEntityBuilder.createScreenCaptureFromPath("./Openmrs/Snapshot").build())
	* ;
	*/
	extent.flush();
	}
	
	
	
	
	
}
	