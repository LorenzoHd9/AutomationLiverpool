package e_commerceLiverpool_Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyBag_Page extends BasePage{

	@FindBy(css = "div.t-myBag__continueToBuy button")
	public WebElement btnLoginToBuy;
	
	@FindBy(xpath = "//button[contains(text(),'Guardar para más tarde')]")
	public List<WebElement> btnSaveProduct;
	
	@FindBy(xpath = "//button[contains(text(),'Comprar ahora')]")
	public WebElement btnBuyNowProduct;
	
	@FindBy(xpath = "//button[contains(text(),'Eliminar')]")
	public WebElement btnDelete;
	
	@FindBy(css = "input.a-ProductQty__input")
	public List<WebElement> txtProductQty;
	
	@FindBy(css = "button[class='a-btn a-btn--primary a-product__buttonBuy']")
	public WebElement btnBuy;
	
	@FindBy(id ="mdc-tab-1")
	public WebElement tabMyBag;
	
	@FindBy(id = "mdc-tab-2")
	public WebElement tabItemSaved;
	
	//@FindBy(css = "div[name='columnProduct']")
	@FindBy(css = "p.description-attribute")
	public WebElement divColumnProduct;
	
	public MyBag_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
}
