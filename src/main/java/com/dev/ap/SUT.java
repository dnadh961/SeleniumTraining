package com.dev.ap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SUT {
	
	private WebDriver driver = null;
	private Configuration config = null;
	private Browser browser = null;
	private WaitHandler waitHandler = null;
	
	public SUT() {
		initializeDriver();
	}
	
	public void terminate(){
		driver.quit();
	}

	private void initializeDriver() {
		String browserName = getConfiguration().getBrowserName();
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

	public Browser getBrowser() {
		if(browser==null){
			browser = new Browser(this);
		}
		return browser;
	}

	public Configuration getConfiguration() {
		if(config == null){
			config = new Configuration();
		}
		return config;
	}
	
	public WaitHandler handleWaits(){
		if(waitHandler == null){
			waitHandler = new WaitHandler(this);
		}
		return waitHandler;
	}
	
	public WebDriver getDriver(){
		return driver;
	}
}
