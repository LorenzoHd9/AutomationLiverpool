package e_commerceLiverpool_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount_Page extends BasePage{

	@FindBy(css = "ul.m-cardBody__margin")
	public WebElement listAside;
	
	@FindBy(css = "div.miscompras__dropdownFilter")
	public WebElement orderFilter;
	
	@FindBy(css = "section.my-coupons__template")
	public WebElement myCouponsTemplate;
	
	@FindBy(xpath = "//button[contains(text(),'Agregar teléfono')]")
	public WebElement btnAddNumber;
	
	@FindBy(css = "button[class ='a-btn a-btn--primary a-airTime-end__recharge']")
	public WebElement btnSubmitRecharge;
	
	@FindBy(id = "loggedInCC")
	public WebElement btnAddCard;
	
	@FindBy(css = "div[class='m-box-form__content -personalData col-12 col-lg-5 px-4']")
	public WebElement divPersonalData;
	
	@FindBy(css = "div.popover-body")
	public WebElement divPoUPMySession;
	
	@FindBy(css = "div[class = 'm-box m-cardBox credit-cards  opc_cardadded']")
	public WebElement defaultCart;
	
	public MyAccount_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
}
