package com.dev.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Its very very important class to prepare for interviews.
 * @author Devendra
 *
 */
public class SeleniumActions {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		initializeDriver("chrome");
	}

	private void initializeDriver(String browser) {
		if ("chrome".equalsIgnoreCase(browser)) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);
		} else {
			driver = new FirefoxDriver();
		}
	}

	@Test
	public void executeJavaScript() {
		driver.get("http://www.techholics.weebly.com");
		waitForPageLoaded(driver);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("alert('hi')");
		System.out.println();
	}

	@Test
	public void clearThruJS() {
		driver.get("http://www.456bereastreet.com/lab/whitespace-around-text-fields/");
		waitForPageLoaded(driver);
		WebElement textElmt = driver.findElement(By.id("text-1"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value = 'my student'", textElmt);
	}

	@Test
	public void mouseHover() {
		driver.get("http://www.techholics.weebly.com/selenium/category/input-devices");
		waitForPageLoaded(driver);
		WebElement author = driver.findElement(By.linkText("Devendra V"));
		Actions actions = new Actions(driver);
		actions.moveToElement(author).build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}

	@Test
	public void rightClick() {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		waitForPageLoaded(driver);
		WebElement elmt = driver.findElement(By.cssSelector("span.context-menu-one"));
		Actions actions = new Actions(driver);
		actions.contextClick(elmt).build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void dragAndDrop() {
		driver.get("http://demo.guru99.com/test/drag_drop.html");

		// Element which needs to drag.
		WebElement from = driver.findElement(By.xpath("//*[@id='credit2']/a"));

		// Element on which need to drop.
		WebElement to = driver.findElement(By.xpath("//*[@id='bank']/li"));

		// Using Action class for drag and drop.
		Actions actions = new Actions(driver);

		// Dragged and dropped.
		actions.dragAndDrop(from, to).build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void doubleClick() {
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");
		waitForPageLoaded(driver);
		driver.switchTo().frame("iframeResult");
		WebElement elmt = driver.findElement(By.cssSelector("p[ondblclick]"));
		Actions actions = new Actions(driver);
		actions.doubleClick(elmt).build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void close() {
		driver.close();
		driver.quit();
	}

	private void waitForPageLoaded(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");
		}
	}
}
