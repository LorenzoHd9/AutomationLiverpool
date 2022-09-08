package e_commerceLiverpool_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page extends BasePage{

	@FindBy(id ="username")//test.ccheck.app011005@gmail.com
	public WebElement txtUserName;
	
	@FindBy(id = "password")//12345678
	public WebElement txtPassword;
	
	@FindBy(xpath = "//button[contains(text(),'Iniciar sesión')]")
	public WebElement btnLogIn;
	public Login_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
}
