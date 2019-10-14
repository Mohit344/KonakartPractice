package com.konakart.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.konakart.constant.FileConstant;
import com.konakart.driver.DriverClass;

public class CommonUtility extends DriverClass{



	static WebElement element;
	/**
	 * method name -locatorsType
	 * @param locator
	 * @return
	 */
	public static WebElement locatorsType(String locator) {
		String arraylocator[] = locator.split(":", 2);

		System.out.println(arraylocator[0]);

		switch (arraylocator[0]) {
		// Find by xpath
		case "ID":
			System.out.println(arraylocator[1]);
			element = driver.findElement(By.id(arraylocator[1]));
			// element.click();

			break;
		case "XPATH":
			System.out.println(arraylocator[1]);
			element = driver.findElement(By.xpath(arraylocator[1]));

			break;
			// Find by css
		case "CSS":
			element = driver.findElement(By.cssSelector(arraylocator[1]));
			break;
			// find by class
		case "CLASSNAME":
			element = driver.findElement(By.className(arraylocator[1]));
			break;

			// find by name
		case "NAME":
			element = driver.findElement(By.name(arraylocator[1]));
			break;

			// find by link
		case "LINK":
			element = driver.findElement(By.linkText(arraylocator[1]));
			break;

			// find by partial link
		case "PARTIALLINK":
			element = driver.findElement(By.partialLinkText(arraylocator[1]));
			break;
			// find by tagName
		case "TAGNAME":
			element = driver.findElement(By.tagName(arraylocator[1]));
			break;


		}
		return element;
	}

	/**
	 * method click the Element using the fluent wait concepts ignoring the
	 * ElementClickInterceptedException.
	 * @param driver
	 * @param xpath
	 */

	public static void clickElement(WebDriver driver, final String locator) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class)
				.pollingEvery(Duration.ofMillis(FileConstant.polling_time))
				.withTimeout(Duration.ofMillis(FileConstant.time));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = locatorsType(locator);
				element.isDisplayed();
				element.click();
				return true;
			}

		});

	}






	/**
	 * 
	 * this method will text and select the items from the drop down.
	 * @param driver
	 * @param xpath
	 * @param timeOut
	 * @param text
	 */

	public static void selectDropdown(WebDriver driver, final String locator, int timeOut, final String text) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.pollingEvery(Duration.ofMillis(FileConstant.polling_time))
				.withTimeout(Duration.ofMillis(FileConstant.time));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {	
				locatorsType(locator);
				element.isDisplayed();
				Select select = new Select(element);

				select.selectByVisibleText(text);
				return true;
			}

		});
	}

	/**
	 * method click the blank fields and send the text to be entered
	 * 
	 * @param driver
	 * @param xpath
	 * @param timeOutInSeconds
	 * @param text
	 */
	public static void clickAndSendText(WebDriver driver, final String locator, int timeOutInSeconds, final String text) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class)
				.pollingEvery(Duration.ofMillis(FileConstant.polling_time))
				.withTimeout(Duration.ofMillis(FileConstant.time));

		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				locatorsType(locator);
				element.sendKeys(text);
				element.isDisplayed();
				element.click();
				return true;
			}
		});
	}

	/**
	 * method takes parameters as
	 * 
	 * @param driver
	 * @param xpath
	 * @param timeOutInSeconds
	 * @param text             and get the text of the web element
	 */
	public static String getText(WebDriver driver, final String locator) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class)
				.pollingEvery(Duration.ofMillis(FileConstant.polling_time))
				.withTimeout(Duration.ofMillis(FileConstant.time));
		return fluentWait.until(new Function<WebDriver, String>() {
			public String apply(WebDriver driver) {

				locatorsType(locator);
				element.isDisplayed();
				String text = element.getText();

				return text;
			}

		});
	}

	/**
	 * method takes parameter as
	 * 
	 * @param driver
	 * @param xpath
	 * @param text
	 * @return WebElement
	 */
	public static WebElement getElement(WebDriver driver, String locator, String text) {
		locatorsType(locator);
		element.sendKeys(text);
		return element;
	}

	/**
	 * method takes parameters as
	 * 
	 * @param driver
	 * @param XPathIsDisplayed
	 * @return a boolean value for the displayed element on the web page
	 */
	public static boolean isDisplayed(WebDriver driver, String locator) {
		boolean isDisplayed = false;
		try {
			locatorsType(locator);
			element.isDisplayed();
		} catch (Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}

	public static void clearElement(WebDriver driver, final String locator) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class)
				.pollingEvery(Duration.ofMillis(FileConstant.polling_time))
				.withTimeout(Duration.ofMillis(FileConstant.time));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				locatorsType(locator);
				element.isDisplayed();
				element.clear();
				return true;
			}
		});
	}

	/**
	 * method takes parameters as
	 * 
	 * @param driver
	 * @param xpath  and uses the explicit wait concept
	 * @return a boolean value after checking the visibility of the.
	 */
	public static boolean isElementVisible(WebDriver driver, String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, FileConstant.Expicit_Wait);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception exception) {

			return false;
		}
		return true;
	}

	/**
	 * method name-getElementsList
	 * @param locator
	 * @return
	 */

	public static List<WebElement> getElementsList(final String locator) {
		String[] loc=locator.split(":",2);
		List<WebElement> element = null;
		try {

			if(loc[0].toUpperCase().equalsIgnoreCase("CSS")) {
				element = driver.findElements(By.cssSelector(loc[1]));
			}
			else {
				element = driver.findElements(By.xpath(loc[1]));
			}


		}catch(Exception e) {
			System.out.println();

		}

		return  element;
	}



	/**
	 * the method takes parameter as
	 * 
	 * @param driver
	 * @param byResolution and scroll down the window.
	 */
	public static void scrollDownPage(WebDriver driver, int byResolution) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String scroll = "window.scrollBy(0," + byResolution + ")";
		js.executeScript(scroll);

	}

	/**
	 * method name-scrollToElement
	 * @param driver
	 * @param locator
	 */
	public static void scrollToElement(WebDriver driver, String locator) {
		//WebElement element = driver.findElement(By.xpath(xpath));
		locatorsType(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", element);
	}

	/**
	 * 
	 * method name -wait
	 */
	public static void wait(int timeOut) {
		try {
			Thread.sleep(timeOut);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * method name-getElement
	 * @param locator
	 * @return
	 */
	public static WebElement getElement(String locator) {

		locatorsType(locator);
		return element;
	}

	/**
	 * method name-mouseHover
	 * @param locator
	 */
	public static void mouseHover(String locator)
	{Actions action = new Actions(driver);
	locatorsType(locator);
	action.moveToElement(element).perform();
	}
	/**
	 * method name-propertyFileLoad
	 * @param filePath
	 * @return
	 * @throws IOException
	 */


	public static Properties propertyFileLoad(String filePath) throws IOException {
		Properties propertyFile=new Properties();
		FileInputStream input = new FileInputStream(filePath);
		propertyFile.load(input);
		return propertyFile;
	}}