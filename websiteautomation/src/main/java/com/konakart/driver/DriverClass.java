package com.konakart.driver;



import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.konakart.constant.FileConstant;
import com.konakart.helper.CommonUtility;

public class DriverClass {
	/**
	 * switch case is created for the browsers-chrome,firefox.
	 * 
	 * @throws IOException
	 */
	public static WebDriver driver;// remove it when use the extent report
public Properties promote;
	@BeforeTest
	public void configSetup() throws IOException {
   promote= CommonUtility.propertyFileLoad(FileConstant.config);
		
		if (promote.getProperty("runmode").equalsIgnoreCase("grid")) {

			driver = BaseClassGrid.getDriver(promote.getProperty("webdrivername"));
		} else {

			switch (promote.getProperty("webdrivername")) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", FileConstant.chromeexe);
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", FileConstant.firefoxexe);
				driver = new FirefoxDriver();
				break;
			case "ie":
				System.setProperty("webdriver.ie.driver", FileConstant.ieexe);
				driver = new InternetExplorerDriver();
				break;
			}

		}
		driver.get(promote.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(FileConstant.implicit_wait, TimeUnit.SECONDS);

	}

	
	@AfterTest
	public void endReport() {
		driver.quit();// quit the webdriver
	}
}
