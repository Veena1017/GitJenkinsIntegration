package config;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.testng.ITestListener;

public class TestListeners implements ITestListener {
	ExtentReports extent = ExtebtReport.getReportObject();
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed: " + result.getName());
		test.log(Status.PASS, "Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed: " + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test execution started: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
