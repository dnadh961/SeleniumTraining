package com.dev.selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dev.sel.util.DriverUtil;

public class WebElementAPITest {

	private WebDriver driver;

	@BeforeMethod
	public void setUp()
	{
		initializeDriver("chrome");
		driver.manage().window().maximize();
	}
	
	private void initializeDriver(String browser) {
		if("chrome".equalsIgnoreCase(browser))
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);
		}
		else
		{
			driver = new FirefoxDriver();
		}
	}
	
	@Test
	public void click()
	{
		driver.get("http://www.w3schools.com/html/default.asp");
		DriverUtil.waitForElementPresence(driver, By.id("main"));
		WebElement currentWebElmt = driver.findElement(By.xpath("//a[@class='tryitbtn']"));
		currentWebElmt.click();
	}
	
	@Test
	public void clear()
	{
		driver.get("http://www.456bereastreet.com/lab/whitespace-around-text-fields/");
		waitForPageLoaded(driver);
		WebElement textElmt = driver.findElement(By.id("text-1"));
		textElmt.clear();
	}
	
	@Test
	public void sendKeys()
	{
		driver.get("http://www.456bereastreet.com/lab/whitespace-around-text-fields/");
		waitForPageLoaded(driver);
		WebElement textElmt = driver.findElement(By.id("text-1"));
		textElmt.sendKeys("Hello World");
		System.out.println();
	}
	
	@Test
	public void findElement()
	{
		driver.get("https://www.w3schools.com/html/html_exercises.asp");
		waitForPageLoaded(driver);
		WebElement getDiplomaDiv = driver.findElement(By.id("getdiploma"));
		boolean isE = getDiplomaDiv.findElement(By.linkText("Get certified")).isEnabled();
		System.out.println(isE);
	}
	
	@Test
	public void findElements()
	{
		driver.get("https://www.w3schools.com/html/html_exercises.asp");
		waitForPageLoaded(driver);
		WebElement mainDiv = driver.findElement(By.id("main"));
		List<WebElement> divCenter = mainDiv.findElements(By.tagName("a"));
		Iterator<WebElement> divCenterI = divCenter.iterator();
		while(divCenterI.hasNext())
		{
			WebElement currElmt = divCenterI.next();
			String text = currElmt.getText();
			System.out.println(text);
		}
	}
	
	@Test
	public void isEnabled()
	{
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_button_test");
		waitForPageLoaded(driver);
		driver.switchTo().frame("iframeResult");
		WebElement buttonElmt = driver.findElement(By.cssSelector("button"));
		boolean isEnabled = buttonElmt.isEnabled();
		System.out.println(isEnabled);
	}
	
	@Test
	public void isDisplayed()
	{
		driver.get("https://www.w3schools.com/html/html_exercises.asp");
		waitForPageLoaded(driver);
		WebElement mainDiv = driver.findElement(By.id("main"));
		boolean isDisplayed = mainDiv.isDisplayed();
		System.out.println(isDisplayed);
	}
	
	@Test
	public void getAttribute()
	{
		driver.get("http://automationpractice.com/index.php");
		waitForPageLoaded(driver);
		WebElement searchQueryDiv = driver.findElement(By.id("search_query_top"));
		String attrVal = searchQueryDiv.getAttribute("class");
		System.out.println(attrVal);
	}
	
	@Test
	public void getCssValue()
	{
		driver.get("http://automationpractice.com/index.php");
		waitForPageLoaded(driver);
		WebElement searchQueryDiv = driver.findElement(By.id("search_query_top"));
		String height = searchQueryDiv.getCssValue("height");
		System.out.println(height);
	}
	
	@Test
	public void getLocation()
	{
		driver.get("http://automationpractice.com/index.php");
		waitForPageLoaded(driver);
		WebElement searchQueryDiv = driver.findElement(By.id("search_query_top"));
		Point loc = searchQueryDiv.getLocation();
		System.out.println(loc.x);
		System.out.println(loc.y);
	}
	
	@Test
	public void getSize()
	{
		driver.get("http://automationpractice.com/index.php");
		waitForPageLoaded(driver);
		WebElement searchQueryDiv = driver.findElement(By.id("search_query_top"));
		Dimension dimension = searchQueryDiv.getSize();
		System.out.println(dimension.height);
		System.out.println(dimension.width);
	}
	
	@Test
	public void getText()
	{
		driver.get("http://automationpractice.com/index.php");
		waitForPageLoaded(driver);
		WebElement contactUs = driver.findElement(By.cssSelector("a[title='Contact Us']"));
		System.out.println(contactUs.getText());
	}
	
	@Test
	public void getTagName()
	{
		driver.get("http://automationpractice.com/index.php");
		waitForPageLoaded(driver);
		WebElement contactLink = driver.findElement(By.id("contact-link"));
		System.out.println(contactLink.getTagName());
	}
	
	@AfterMethod
	public void close()
	{
		driver.close();
		driver.quit();
	}
	
	private void waitForPageLoaded(WebDriver driver) {
	     ExpectedCondition<Boolean> expectation = new
	     ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
	          return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	        }
	      };

	     Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	      try {
	              wait.until(expectation);
	      } catch(Throwable error) {
	              Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");
	      }
	 }
}
