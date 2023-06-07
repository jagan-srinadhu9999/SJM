package testCasesForActiTime;

import java.io.File;
import java.time.Duration;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import jagansolutionspvt.BasicFrameWork.BaseClass;
import jagansolutionspvt.BasicFrameWork.CreateCustomerPageClass;
import jagansolutionspvt.BasicFrameWork.LoginPage;

public class CreateCustomerTest extends BaseClass {

	WebDriver driver;
	ExtentReports extentreports;
	ExtentHtmlReporter htmlreporter;
	@BeforeTest
	public void getExtentReports() {
		 extentreports = new ExtentReports();
		// htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator
			//	+ "Reports" + File.separator + "AutomationReports.html");
		 htmlreporter=new ExtentHtmlReporter("./BasicFrameWork/Reports");

	htmlreporter.config().setEncoding("utf-8");
	htmlreporter.config().setDocumentTitle("Automation Reports");
	htmlreporter.config().setReportName("Automation Test Results");
	htmlreporter.config().setTheme(Theme.DARK);
	extentreports.attachReporter(htmlreporter);
	
	extentreports.setSystemInfo("Automation Tester", "jagannadharao");
	
	
	
	}

	@BeforeClass
	public void launchBrowser() {
		// System.setProperty("webdriver.chrome.driver",
		// "./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
		opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(priority = 2, dependsOnMethods = { "getLogin" })
	public void verifyCustomer() {
		CreateCustomerPageClass p = new CreateCustomerPageClass(driver);
		p.getTask().click();
		p.getAddNew().click();
		p.getAddCustomer().click();
		p.getAddCname().sendKeys("java");
		p.getCreateCustomer().click();
	}

	@Test(priority = 1)
	public void getLogin() {
		LoginPage lp = new LoginPage(driver);

		lp.getUserId().sendKeys("admin");
		lp.getPassword().sendKeys("manager");
		lp.getSubmit().click();
	}

	@AfterClass
	public void logout() {
		extentreports.flush();
		CreateCustomerPageClass p = new CreateCustomerPageClass(driver);
		p.getLogout().click();
		driver.close();
	}

}
