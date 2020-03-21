package com.slokam.ops.testscripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestProducts extends BaseTest {

	@Test(groups= {"regression"})
	public void verifyCreateProductsTest() {
		
		test.info("Test is started");
		
		test.pass("verifyCreateProductsTest is successful");
		
		

	}
}
