package com.dev.testng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidateMaths {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	
	@BeforeClass
	public void setup() {
		System.out.println("Before class");
	}
	

	@BeforeMethod
	public void beforeM() {
		System.out.println("Before Method");
	}
	
	@DataProvider (name = "test_add_data")
	public Object[][] dpMethod() {
	    return new Object [][] { {5, 7, 12}, {2, -6, -4}, {9, 0, 9}};
	}
	
	@DataProvider (name = "test_multiply_data")
	public Object[][] multiplyMethod() {
	    return new Object [][] { {5, 7, 35}, {8, -1, -8} };
	}

	@Test(dataProvider = "test_add_data", priority = 3)
	public void testAdd(int a, int b, int c) {
		System.out.println("Test Add");
		Maths maths = new Maths();
		int result = maths.add(a, b);
		Assert.assertEquals(result, c);
	}
	
	@Test(dataProvider = "test_multiply_data", priority = 2)
	public void testMultiply(int a, int b, int c) {
		System.out.println("Test Multiply");
		Maths maths = new Maths();
		int result = maths.multiply(a, b);
		Assert.assertEquals(result, c);
	}
	
	@Test(priority = 0)
	public void testEvenNum() {
		System.out.println("Test Even");
		Maths maths = new Maths();
		boolean result = maths.isEvenNum(126);
		Assert.assertTrue(result);
	}
	
	@Test(priority = 4, enabled = false)
	public void testOddNum() {
		System.out.println("Test Odd");
		Maths maths = new Maths();
		boolean result = maths.isEvenNum(125);
		Assert.assertFalse(result);
	}
	
	@AfterClass
	public void teardown() {
		System.out.println("After class");
	}
	

	@AfterMethod
	public void afterM() {
		System.out.println("After Method");
	}
	
	
}
