package com.dev.sel.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class DriverUtil {

	public static void waitForPageLoaded(WebDriver driver) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		try {
			wait.until(checkPageLoadStatus());
		} catch (Throwable error) {

		}
	}

	public static void waitForElementPresence(final WebDriver driver,
			final By locator) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(45));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Throwable error) {

		}
	}
	
	public static void waitForElementVisibility(final WebDriver driver,
			final By locator) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Throwable error) {

		}
	}
	
	public static void waitForElementClickable(final WebDriver driver,
			final By locator) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Throwable error) {

		}
	}

	private static Function<WebDriver, Boolean> checkPageLoadStatus() {
		return new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
	}
	
	private static Function<WebDriver, Boolean> myCondition(final String condition) {
		return new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (Boolean) ((JavascriptExecutor) driver).executeScript(
						"return "+condition);
			}
		};
	} 
}
