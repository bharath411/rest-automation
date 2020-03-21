package com.slokam.ops.commons.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.slokam.ops.testscripts.BaseTest;

public class CustomListener implements ITestListener {

	public void onTestFailure(ITestResult result) {
		//BaseTest.test.fail("test is failed");
		System.out.println("test is failed");
	}

}
