package com.bjs.learning.automation.SeleniumAutomation.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Listener implements ITestListener {
	 private static final String CODE1 = "{\n    \"theme\": \"standard\",\n    \"encoding\": \"utf-8\n}";
	 private static final String CODE2 = "{\n    \"protocol\": \"HTTPS\",\n    \"timelineEnabled\": false\n}";
	 
	 ExtentReports extent ;
     ExtentSparkReporter spark ;


	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("on Test Start");
		/* extent.createTest("ScreenCapture")
         .addScreenCaptureFromPath("extent.png")
         .pass(MediaEntityBuilder.createScreenCaptureFromPath("extent.png").build());
		 extent.createTest("LogLevels")
         .info("info")
         .pass("pass")
         .warning("warn")
         .skip("skip")
         .fail("fail"); */
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("on Test Success");
		extent.createTest(result.getName()).generateLog(
                Status.PASS,
                MarkupHelper.createCodeBlock(CODE1, CODE2));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("on Test Failure");
		extent.createTest(result.getName()).generateLog(
                Status.FAIL,
                MarkupHelper.createCodeBlock(CODE1, CODE2));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("on Test Skipped");
		extent.createTest(result.getName()).generateLog(
                Status.SKIP,
                MarkupHelper.createCodeBlock(CODE1, CODE2));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("On Start of Tests");
		  extent = new ExtentReports();
	      spark = new ExtentSparkReporter("target/Spark/Reports.html");
	      extent.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("on Finish");
		extent.flush();
	}

}
