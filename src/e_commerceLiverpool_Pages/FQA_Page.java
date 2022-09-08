package e_commerceLiverpool_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FQA_Page extends BasePage{

	@FindBy(xpath = "//a[contains(text(),'Preguntas frecuentes')]")
	public WebElement linkFQA;
	
	@FindBy()
	public WebElement  el;
	
	public FQA_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	
}
