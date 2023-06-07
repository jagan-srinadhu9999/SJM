package com.ExtentReports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BasicExtentReports {
	public static void main(String[] args) {
		ExtentReports extent = new ExtentReports();
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(
				System.getProperty("use.dir") + File.separator + "Reports" + File.separator + "Automationreport.html");
		htmlreporter.config().setEncoding("utf-8");
		htmlreporter.config().setDocumentTitle("Automationreport");
		htmlreporter.config().setReportName("Automation Test Results");
		htmlreporter.config().setTheme(Theme.DARK);
		

		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("AutomationTester", "jagannadha Rao");
		ExtentTest logger;

		extent.flush();

	}
}
