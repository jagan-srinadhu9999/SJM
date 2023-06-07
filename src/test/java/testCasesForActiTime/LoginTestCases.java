package testCasesForActiTime;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jagansolutionspvt.BasicFrameWork.BaseClass;
import jagansolutionspvt.BasicFrameWork.LoginPage;
import utilityClasses.PropertyUtility;

public class LoginTestCases extends BaseClass {
	
	
	@BeforeMethod
	public void launchBrowser() throws Exception {
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(opt);
		PropertyUtility  p=new PropertyUtility();
		driver.manage().window().maximize();
	//	driver.get("https://demo.actitime.com/login.do");
		driver.get(p.fetchProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test
	public void getLogin() throws Throwable {
		 LoginPage lp = new LoginPage(driver);
		 PropertyUtility  p=new PropertyUtility();

	//	lp.getUserId().sendKeys("admin");
		lp.getUserId().sendKeys(p.fetchProperty("un"));
	//	lp.getPassword().sendKeys("manager");
		lp.getPassword().sendKeys(p.fetchProperty("pwd"));
		lp.getSubmit().click();
		LoginPage.verfication();
		
	}

}
