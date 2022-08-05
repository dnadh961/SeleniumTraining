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

public class MyFirstSeleniumScript {

	private static WebDriver driver = null;

	public static void main(String[] args) {
		initializeDriver("chrome");
		driver.get("https://seleniumtuitions.weebly.com/notes");
		//driver.findElement(By.partialLinkText("_Collections")).click();
		List<WebElement> links = driver.findElements(By.className("wsite-menu-item"));
		Iterator<WebElement> linksI = links.iterator();
		while(linksI.hasNext()) {
			System.out.println(linksI.next().getText());
		}
		//driver.close();
		//driver.quit();
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
