package e_commerceLiverpool_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_Page extends BasePage{

	@FindBy(xpath = "//label[contains(text(),'Cambiar')]")
	public WebElement txtchangeAddress;
	
	@FindBy(css = "label[class='text-shutdown-card cambiarLabelTxt text-size-card']")
	public WebElement linkChangeCard;
	
	@FindBy(id ="opc_modal_storeButton")
	public WebElement btnclickCollect;
	
	@FindBy(css = "select.mdc-select__native-control")
	public WebElement cmbState;
	
	@FindBy(css = "div.pc_pickup__addStore--store--container")
	public WebElement containerPickUPStore;
	
	@FindBy(xpath = "//button[contains(text(),'Continuar')]")
	public WebElement btnContinue;
	
	@FindBy(id ="cardExp")
	public WebElement txtCardExpiration;
	
	@FindBy(id ="cvv")
	public WebElement txtCVV;
	
	@FindBy(id ="submitForOther")
	public WebElement submitOrder;
	
	@FindBy(css = "div[class ='a-btn a-btn--action --secondary a-checkout__btnPromotion text-promotions show  ']")
	public WebElement btnPromotion;
	
	@FindBy(css = "li[class = 'a-checkout_promoListElement opc_modalPromoElement']")
	public WebElement promoOpt;
	
	@FindBy(css = "div[class='-toTop shipping-alert m-alert__container mdc-snackbar -alertCheckout -step1 -alert mdc-snackbar--open']")
	public WebElement snackBarError;
	
	@FindBy(css= "div[class='-toTop shipping-alert m-alert__container mdc-snackbar -alertCheckout -step1 -success mdc-snackbar--open']")
	public WebElement alertChangeAddress;
	
	@FindBy(id = "loggedInCC")
	public WebElement btnPaymentContinue;
	
	@FindBy(id = "opc_modal_addressButton")
	public WebElement btnHomeDelivery;
	
	@FindBy(css = "input[class='a-radio__input mdc-radio__native-control']")
	public WebElement rdoMyAddress;
	
	@FindBy(id = "opc_selectCC")
	public WebElement btnSelectCC;
	
	@FindBy(id = "promotions__banner")
	public WebElement imgLogoHome;
	
	public Checkout_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

}
