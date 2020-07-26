package com.slokam.ops.testscripts;

import java.lang.reflect.Method;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.slokam.ops.commons.rest.Authentication;
import com.slokam.ops.commons.utils.AppUtil;

public class BaseTest {

	public static String baseUrl = "";
	public static AppUtil app = null; 
	public static String username = "";
	public static String password = "";
	public static ExtentReports extent = null;
	public static String token = "";
	public static ExtentTest test = null;
	
	@BeforeSuite
	public void init() {

		extent = new ExtentReports();
		ExtentHtmlReporter html = new ExtentHtmlReporter("Extent.html");
		extent.attachReporter(html);
		app = new AppUtil();
		baseUrl = app.getProperty("url");
		username =  app.getProperty("username");
		password =  app.getProperty("password");
		
		Authentication auth = new Authentication();
		token = auth.createSession();
		
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		String name = method.getName();
		test = extent.createTest(name);
	}
	
	
	@AfterSuite
	public void teardown() {
		extent.flush();
	}
}
