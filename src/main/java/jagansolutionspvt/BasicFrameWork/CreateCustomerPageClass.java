package jagansolutionspvt.BasicFrameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCustomerPageClass   {
	/*
	 * declarions of page webElements
	 */
	@FindBy(xpath = "//div[@id='container_tasks']")
	private WebElement task;
	
	@FindBy(css = ".addNewButton")
	private WebElement addNew;
	
	@FindBy(css = ".item.createNewCustomer")
	private WebElement addCustomer;

	@FindBy(css=".customerNameDiv input")
	private WebElement addCname;
	
	@FindBy(xpath="//div[@class='basicLightboxFooter']//div[@class='components_button withPlusIcon']")
	private WebElement createCustomer;
	
	@FindBy(css="#logoutLink")
	private WebElement logout;
	
	/*
	 * webelements or onjects initilization
	 */
	public CreateCustomerPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getTask() {
		return task;
	}

	public WebElement getAddNew() {
		return addNew;
	}

	public WebElement getAddCustomer() {
		return addCustomer;
	}

	public WebElement getAddCname() {
		return addCname;
	}

	public WebElement getCreateCustomer() {
		return createCustomer;
	}

	public WebElement getLogout() {
		return logout;
	}
	
	
}
