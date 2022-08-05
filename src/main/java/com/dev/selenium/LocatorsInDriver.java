package com.dev.selenium;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dev.sel.util.DriverUtil;

public class LocatorsInDriver {

	private WebDriver driver;

	@BeforeMethod
	public void setUp()
	{
		initializeDriver("chrome");
	}
	
	private void initializeDriver(String browserName) {
		if ("firefox".equals(browserName)) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe" );  
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if ("chrome".equals(browserName)) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized"); // To maximize the browser
			options.addArguments("--test-type"); // To get rid off 'ignore certificate errors' message
													// options.addArguments("--kiosk"); //To enable full screen mode
			options.addArguments("chrome.switches", "--disable-extensions");
			driver = new ChromeDriver(options);
		} else if("edge".equalsIgnoreCase(browserName)) {
			System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
	}
	
	@Test
	public void byID()
	{
		driver.get("https://www.facebook.com/");
		DriverUtil.waitForPageLoaded(driver);
		WebElement emailElmt = driver.findElement(By.id("email"));
		emailElmt.sendKeys("shabari");
		System.out.println();
	}
	
	@Test
	public void byName()
	{
		driver.get("http://www.thinkvidya.com/");
		DriverUtil.waitForPageLoaded(driver);
		WebElement firstNameElmt = driver.findElement(By.name("fullName"));
		firstNameElmt.sendKeys("devendra");
		System.out.println();
	}
	
	@Test
	public void byCss()
	{
		driver.get("http://www.thinkvidya.com/");
		DriverUtil.waitForPageLoaded(driver);
		WebElement firstNameElmt = driver.findElement(By.cssSelector("input[class='mb-0'][placeholder='Name']"));
		firstNameElmt.sendKeys("devendra");
		System.out.println();
	}
	
	@Test
	public void byXpath()
	{
		driver.get("http://www.thinkvidya.com/");
		DriverUtil.waitForPageLoaded(driver);
		WebElement firstNameElmt = driver.findElement(By.xpath("//input[@class='mb-0' and @placeholder='Name']"));
		firstNameElmt.sendKeys("devendra");
		System.out.println();
	}
	
	@Test
	public void byLink()
	{
		driver.get("http://book.theautomatedtester.co.uk/");
		DriverUtil.waitForPageLoaded(driver);
		WebElement firstNameElmt = driver.findElement(By.linkText("Chapter3"));
		firstNameElmt.click();
		System.out.println();
	}
	
	@Test
	public void byPartialLink()
	{
		driver.get("http://book.theautomatedtester.co.uk/");
		DriverUtil.waitForPageLoaded(driver);
		WebElement firstNameElmt = driver.findElement(By.partialLinkText("3"));
		firstNameElmt.click();
		System.out.println();
	}
	
	@Test
	public void byClassName()
	{
		driver.get("http://www.thinkvidya.com/");
		DriverUtil.waitForPageLoaded(driver);
		WebElement mbElmt = driver.findElement(By.className("mb-0"));
		mbElmt.sendKeys("dev");
		System.out.println();
	}
	
	@Test
	public void byTag()
	{
		driver.get("http://www.thinkvidya.com/");
		DriverUtil.waitForPageLoaded(driver);
		List<WebElement> mbElmt = driver.findElements(By.tagName("input"));
		Iterator<WebElement> mbElmtI = mbElmt.iterator();
		while(mbElmtI.hasNext())
		{
			WebElement currElmt = mbElmtI.next();
			System.out.println(currElmt.getAttribute("type"));
		}
	}
	
	
	@AfterMethod
	public void close()
	{
		driver.close();
		driver.quit();
	}
	
	private void sleep(int seconds)
	{
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
