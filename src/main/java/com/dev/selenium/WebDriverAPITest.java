package com.dev.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverAPITest {

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
	public void get()
	{
		driver.get("http://www.w3schools.com/html/html5_draganddrop.asp");
		waitForPageLoaded(driver);
		driver.manage().window().maximize();
	}
	
	@Test
	public void findElement()
	{
		driver.get("http://www.456bereastreet.com/lab/whitespace-around-text-fields/");
		waitForPageLoaded(driver);
		driver.manage().window().maximize();
		final WebElement elmt = driver.findElement(By.id("text-1"));
		elmt.sendKeys("chanu");
		System.out.println();
	}
	
	@Test
	public void getCurrentURL()
	{
		driver.get("https://seleniumtuitions.weebly.com/notes");
		waitForPageLoaded(driver);
		driver.findElement(By.linkText("Java_Exceptions")).click();
		waitForPageLoaded(driver);
		//System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("javaexceptions"));
	}
	
	@Test
	public void getPageSource()
	{
		driver.get("http://automationpractice.com/index.php");
		waitForPageLoaded(driver);
		System.out.println(driver.getPageSource());
	}
	
	@Test
	public void getTitle()
	{
		driver.get("http://automationpractice.com/index.php");
		waitForPageLoaded(driver);
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void handleIframe()
	{
		driver.get("http://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_target");
		waitForPageLoaded(driver);
		System.out.println("Before switch: "+driver.getCurrentUrl());
		WebElement resultFrame = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(resultFrame);
		System.out.println("After switch: "+driver.getCurrentUrl());
		driver.findElement(By.xpath("//a[@target='iframe_a']")).click();
		waitForPageLoaded(driver);
		System.out.println(driver.getPageSource());
		driver.switchTo().defaultContent();
		waitForPageLoaded(driver);
		System.out.println(driver.getPageSource());
		driver.findElement(By.id("runbtn")).click();
		System.out.println();
	}
	
	@Test
	public void navigateBack()
	{
		driver.get("http://automationpractice.com/index.php");
		waitForPageLoaded(driver);
		driver.findElement(By.cssSelector("a[title='View my shopping cart']")).click();
		waitForPageLoaded(driver);
		driver.navigate().back();
	}
	
	@Test
	public void navigateForward()
	{
		driver.get("http://automationpractice.com/index.php");
		waitForPageLoaded(driver);
		driver.findElement(By.cssSelector("a[title='View my shopping cart']")).click();
		waitForPageLoaded(driver);
		driver.navigate().back();
		waitForPageLoaded(driver);
		driver.navigate().forward();
	}
	
	@Test
	public void refresh()
	{
		driver.get("https://www.youtube.com/");
		waitForPageLoaded(driver);
		driver.navigate().refresh();
		waitForPageLoaded(driver);
	}
	
	@Test
	public void navigateTo()
	{
		driver.get("https://www.youtube.com/");
		waitForPageLoaded(driver);
		driver.navigate().to("http://www.seleniumtuitions.weebly.com");
		waitForPageLoaded(driver);
	}
	
	@Test
	public void getCookie()
	{
		driver.get("https://www.facebook.com/");
		waitForPageLoaded(driver);
		driver.findElement(By.id("email")).sendKeys("dnadh961@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Tr@1ning");
		driver.findElement(By.name("login")).click();
		waitForPageLoaded(driver);
		System.out.println("c_user: "+driver.manage().getCookieNamed("c_user"));
	}
	
	@Test
	public void getCookies()
	{
		driver.get("https://www.facebook.com/");
		waitForPageLoaded(driver);
		driver.findElement(By.id("email")).sendKeys("dnadh961@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Tr@1ning");
		driver.findElement(By.name("login")).click();
		waitForPageLoaded(driver);
		System.out.println("c_user: "+driver.manage().getCookies());
	}
	
	@Test
	public void deleteCookieNamed()
	{
		driver.get("https://www.facebook.com/");
		waitForPageLoaded(driver);
		driver.findElement(By.id("email")).sendKeys("dnadh961@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Tr@1ning");
		driver.findElement(By.name("login")).click();
		waitForPageLoaded(driver);
		System.out.println("After LogIn: "+driver.manage().getCookies());
		driver.manage().deleteCookieNamed("c_user");
		System.out.println("After c_user deletion: "+driver.manage().getCookies());
		driver.navigate().refresh();
	}
	
	@Test
	public void deleteAllCookies()
	{
		driver.get("https://www.facebook.com/");
		waitForPageLoaded(driver);
		driver.findElement(By.id("email")).sendKeys("dnadh961@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Tr@1ning");
		driver.findElement(By.name("login")).click();
		waitForPageLoaded(driver);
		System.out.println("After LogIn: "+driver.manage().getCookies());
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		System.out.println();
	}
	
	@Test
	public void alertOK()
	{
		driver.get("https://techholics.weebly.com/selenium/how-to-handle-popup-in-selenium-example");
		waitForPageLoaded(driver);
		driver.findElement(By.id("alertbox")).click();
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void isAlertPresent()
	{
		boolean isAlert = true;
		driver.get("https://techholics.weebly.com/selenium/how-to-handle-popup-in-selenium-example");
		waitForPageLoaded(driver);
		driver.findElement(By.id("alertbox")).click();
		try
		{
			driver.switchTo().alert();
		}
		catch(NoAlertPresentException e)
		{
			isAlert = false;
		}
		if(isAlert)
		{
			System.out.println("alertPresent");
		}
		else
		{
			System.out.println("Alert is not there");
		}
	}
	
	@Test
	public void getAlertText()
	{
		driver.get("https://techholics.weebly.com/selenium/how-to-handle-popup-in-selenium-example");
		waitForPageLoaded(driver);
		driver.findElement(By.id("alertbox")).click();
		String textInAlertBox = driver.switchTo().alert().getText();
		System.out.println(textInAlertBox);
	}
	
	@Test
	public void getPromptText()
	{
		driver.get("https://techholics.weebly.com/selenium/how-to-handle-popup-in-selenium-example");
		waitForPageLoaded(driver);
		driver.findElement(By.name("promptbox")).click();
		String textInPromptBox = driver.switchTo().alert().getText();
		System.out.println(textInPromptBox);
	}
	
	@Test
	public void promptOK()
	{
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt1");
		waitForPageLoaded(driver);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void answerPromptText()
	{
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt1");
		waitForPageLoaded(driver);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		driver.switchTo().alert().sendKeys("Pepsi");
		driver.switchTo().alert().accept();
		System.out.println();
	}
	
	@Test
	public void getConfirmationText()
	{
		driver.get("https://techholics.weebly.com/selenium/how-to-handle-popup-in-selenium-example");
		waitForPageLoaded(driver);
		driver.findElement(By.xpath("//input[@value='confirm']")).click();
		String textInConfirmBox = driver.switchTo().alert().getText();
		System.out.println(textInConfirmBox);
	}
	
	@Test
	public void confirmOK()
	{
		driver.get("https://techholics.weebly.com/selenium/how-to-handle-popup-in-selenium-example");
		waitForPageLoaded(driver);
		driver.findElement(By.xpath("//input[@value='confirm']")).click();
		driver.switchTo().alert().accept();
		sleep(2);
		Alert confirmAlert = driver.switchTo().alert();
		if(confirmAlert.getText().contains("OK"))
		{
			System.out.println("Test is passed");
		}
		confirmAlert.accept();
		System.out.println();
	}
	
	@Test
	public void confirmCancel()
	{
		driver.get("https://techholics.weebly.com/selenium/how-to-handle-popup-in-selenium-example");
		waitForPageLoaded(driver);
		driver.findElement(By.xpath("//input[@value='confirm']")).click();
		driver.switchTo().alert().dismiss();
		sleep(2);
		Alert confirmAlert = driver.switchTo().alert();
		if(confirmAlert.getText().contains("Cancel"))
		{
			System.out.println("Test is passed");
		}
		confirmAlert.accept();
		System.out.println();
	}
	
	@Test
	public void handlePopUpWindow()
	{
		driver.get("https://techholics.weebly.com/selenium/how-to-handle-popup-in-selenium-example");
		waitForPageLoaded(driver);
		driver.findElement(By.linkText("Open a popup window")).click();
		sleep(3);
		String firstWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandleList = new ArrayList<>(windowHandles);
		String secondWinHandle = windowHandleList.get(1);
		driver.switchTo().window(secondWinHandle);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(firstWindowHandle);
		System.out.println(driver.getTitle());
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
