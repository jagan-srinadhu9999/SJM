package jagansolutionspvt.BasicFrameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	/*
	 * declaration of elements for login page
	 */
	@FindBy(css = "input[id='username']")
	private WebElement userId;
	
	@FindBy(name = "pwd")
	private WebElement password;
	
	@FindBy(xpath = "//a[.='Login ']")
	private WebElement submit;
	protected static String name="java";
	 public static void verfication()
	 {
		System.out.println("verification sucsess"); 
	 }
	/*
	 * initilization for objects create constructor using PageFactory class inittEllements() method
	 */
	

	public LoginPage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	
	}
	
	/*
	 * utilization
	 */
	

	public WebElement getUserId() {
		

		return userId;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getSubmit() {
		return submit;
	}

}
