package com.dev.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.dev.sel.util.DriverUtil;

public class WaitCommands {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		initializeDriver("chrome");
		//driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		driver.get("http://automationpractice.com/index.php?id_product=7&controller=product");
		driver.findElement(By.id("wishlist_button")).click();
		DriverUtil.waitForElementPresence(driver, By.xpath("//p[contains(text(), 'Ymu must be logged in to')]"));
		driver.findElement(By.xpath("//p[contains(text(), 'Ymu must be logged in to')]"));
	}
	
	private static void initializeDriver(String browserName) {
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
}
