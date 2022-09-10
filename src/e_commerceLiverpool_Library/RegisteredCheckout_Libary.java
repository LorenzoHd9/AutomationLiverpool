package e_commerceLiverpool_Library;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import e_commerceLiverpool_Pages.Checkout_Page;
import e_commerceLiverpool_Pages.Home_Page;
import e_commerceLiverpool_Pages.Login_Page;
import e_commerceLiverpool_Pages.MyAccount_Page;
import e_commerceLiverpool_Pages.MyBag_Page;
import e_commerceLiverpool_Pages.PDP_Page;
import e_commerceLiverpool_Pages.PLP_Page;

public class RegisteredCheckout_Libary extends BaseLibrary{

	private WebDriverWait wait;
	private Home_Page home;
	private Login_Page login;
	private MyAccount_Page myaccount;
	private PLP_Page plp;
	private PDP_Page pdp;
	private MyBag_Page mybag;
	private Checkout_Page checkout;
	int stepDelay = 2000;
	public RegisteredCheckout_Libary(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		home = new Home_Page(driver);
		login = new Login_Page(driver);
		pdp = new PDP_Page(driver);
		plp = new PLP_Page(driver);
		myaccount = new MyAccount_Page(driver);
		mybag = new MyBag_Page(driver);
		checkout = new Checkout_Page(driver);
	}
	
	private void homePage() throws InterruptedException {
		pageLoad();
		//wait.until(ExpectedConditions.visibilityOf(home.carouselOnesection));
		waitForVisibilityOf(home.carouselOnesection);
	}
	
	public void LogIn() throws InterruptedException {
		homePage();
		home.linkLogIn.click();
		pageLoad();
		//wait.until(ExpectedConditions.visibilityOf(login.txtUserName));
		waitForVisibilityOf(login.txtUserName);
		waitForVisibilityOf(login.btnLogIn);
		login.txtUserName.sendKeys("test.ccheck.app011005@gmail.com");
		login.txtPassword.sendKeys("12345678");
		login.btnLogIn.click();
		//wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public void navigateUserSessionOpt() throws InterruptedException{
		homePage();
		/*Mi cuenta*/
		navigateMyAccount(0,myaccount.listAside);
		waitForVisibilityOf(myaccount.divPersonalData);
		/*end*/
		home.imgLogo.click();
		homePage();
		Thread.sleep(stepDelay);
		/*Mis Compras*/
		navigateMyAccount(1,myaccount.listAside);
		waitForVisibilityOf(myaccount.orderFilter);
		/*end*/
		home.imgLogo.click();
		homePage();
		Thread.sleep(stepDelay);
		/*coupones*/
		navigateMyAccount(2,myaccount.listAside);
		waitForVisibilityOf(myaccount.myCouponsTemplate);
		/*end*/
		home.imgLogo.click();
		homePage();
		Thread.sleep(stepDelay);
		/*Mi tiempo aire*/
		navigateMyAccount(3,myaccount.btnAddNumber);
		/*end*/
		home.imgLogo.click();
		homePage();
		Thread.sleep(stepDelay);
		/*Mis Tarjetas*/
		navigateMyAccount(4,myaccount.defaultCart);
		waitForVisibilityOf(myaccount.btnAddCard);
		/*end*/
		home.imgLogo.click();
		homePage();
		Thread.sleep(stepDelay);
		/*Cerrar sesion*/
		navigateMyAccount(5,home.carouselOnesection);
		/*end*/
		Thread.sleep(stepDelay);
	}
	
	public void addItems() throws InterruptedException{
		homePage();
		//search with key world
		search("iphone");
		//click random product
		plp.imgProduct_pdp.get(0).click();
		// add to cart item 1
		addtocart();
		Thread.sleep(stepDelay);
		// add to cart item 2
		search("perfumes"); //not going to measure
		plp.imgProduct_pdp.get(0).click();
		addtocart();
		Thread.sleep(stepDelay);
		// add to cart item 3
		search("sofa"); //not going to measure
		plp.imgProduct_pdp.get(0).click();
		addtocart();
		Thread.sleep(stepDelay);
		
	}
	
	public void myBag() throws InterruptedException {
		homePage();
		wait.until(ExpectedConditions.visibilityOf(home.linkMyBag)).click();
		System.out.println("in my cart page");
		waitForVisibilityOf(pdp.imgLoading);
		wait.until(ExpectedConditions.invisibilityOf(pdp.imgLoading));
		System.out.println("page loaded");
		waitForVisibilityOf(mybag.divColumnProduct);
		waitForVisibilityOf(mybag.btnBuyNowProduct);
		wait.until(ExpectedConditions.visibilityOfAllElements(mybag.txtProductQty));
		System.out.println("how many input qty there are: " + mybag.txtProductQty.size());
		mybag.txtProductQty.get(0).sendKeys(Keys.BACK_SPACE);
		mybag.txtProductQty.get(0).sendKeys("2" + Keys.TAB);
		waitForVisibilityOf(pdp.imgLoading);
		wait.until(ExpectedConditions.invisibilityOf(pdp.imgLoading));
		wait.until(ExpectedConditions.visibilityOf(mybag.txtProductQty.get(1))).sendKeys(Keys.BACK_SPACE);
		mybag.txtProductQty.get(1).sendKeys("2"+ Keys.TAB);
		waitForVisibilityOf(pdp.imgLoading);
		wait.until(ExpectedConditions.invisibilityOf(pdp.imgLoading));
		System.out.println("how many save to later button appear: "+ mybag.btnSaveProduct.size());
		waitForVisibilityOf(mybag.btnSaveProduct.get(2));
	    mybag.btnSaveProduct.get(2).click();
		waitForVisibilityOf(pdp.imgLoading);
		wait.until(ExpectedConditions.invisibilityOf(pdp.imgLoading));
		scroll(home.txtSearchBar);
	} 
	
	public void oneCheckOut() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(home.linkMyBag)).click();
		isLoadImgEnabled();
		wait.until(ExpectedConditions.visibilityOf(mybag.btnBuyNowProduct)).click();
		//wait.until(ExpectedConditions.invisibilityOf(pdp.imgLoading));
		isLoadImgEnabled();
		waitForVisibilityOf(checkout.txtchangeAddress);
		//click collect
		checkout.txtchangeAddress.click();
		isLoadImgEnabled();
		wait.until(ExpectedConditions.visibilityOf(checkout.btnclickCollect)).click();
		waitForVisibilityOf(checkout.cmbState);
		Select state = new Select(checkout.cmbState);
		checkout.cmbState.click();
		state.selectByVisibleText("NUEVO LEÓN");
		wait.until(ExpectedConditions.invisibilityOf(pdp.imgLoading));
		try { waitForVisibilityOf(checkout.containerPickUPStore);
		}catch(Exception ex) {}
		checkout.btnContinue.click();
		isLoadImgEnabled();
		//end click collect
		wait.until(ExpectedConditions.invisibilityOf(checkout.alertChangeAddress));
		//forma de pago
		wait.until(ExpectedConditions.visibilityOf(checkout.linkChangeCard)).click();
		isLoadImgEnabled();
		wait.until(ExpectedConditions.visibilityOf(checkout.txtCardExpiration)).sendKeys("0924");
		checkout.txtCVV.sendKeys("345");
		checkout.btnPaymentContinue.click();
		isLoadImgEnabled();
		//end forma de pago
		try {
			scroll(checkout.btnPromotion);
			System.out.println("scroll to promotion");
			waitForVisibilityOf(checkout.btnPromotion);
			checkout.btnPromotion.click();
			System.out.println("click at promotion link");
			isLoadImgEnabled();
			if(checkout.promoOpt.isDisplayed() != false) {
				waitForVisibilityOf(checkout.promoOpt);
				checkout.promoOpt.click();
				System.out.println("click at one promotion");
			}
		}catch(Exception ex) {}
		isLoadImgEnabled();
		scroll(mybag.txtProductQty.get(0));
		mybag.txtProductQty.get(0).sendKeys(Keys.BACK_SPACE + "1"+ Keys.TAB);
		isLoadImgEnabled();
		checkout.submitOrder.click();
		waitForVisibilityOf(checkout.snackBarError);
		//-toTop shipping-alert m-alert__container mdc-snackbar -alertCheckout -step1 -success -toTop
		//-toTop shipping-alert m-alert__container mdc-snackbar -alertCheckout -step1 -success mdc-snackbar--open
	}
	
	public void oneCheckoutTwo() {
		waitForVisibilityOf(checkout.txtchangeAddress);
		// entrega a tu domicilio
		checkout.txtchangeAddress.click();
		isLoadImgEnabled();
		wait.until(ExpectedConditions.visibilityOf(checkout.btnHomeDelivery)).click();
		checkout.rdoMyAddress.click();
		checkout.btnContinue.click();
		isLoadImgEnabled();
		// end entrega tu domicilio
		//forma de pago
		wait.until(ExpectedConditions.visibilityOf(checkout.linkChangeCard)).click();
		isLoadImgEnabled();
		wait.until(ExpectedConditions.visibilityOf(checkout.txtCardExpiration)).sendKeys("0924");
		checkout.txtCVV.sendKeys("345");
		checkout.btnPaymentContinue.click();
		isLoadImgEnabled();
		//end forma de pago
		try {
		//change prmotions dropdown
			scroll(checkout.btnPromotion);
			System.out.println("scroll to promotion");
			waitForVisibilityOf(checkout.btnPromotion);
			checkout.btnPromotion.click();
			System.out.println("click at promotion link");
			if(checkout.promoOpt.isDisplayed() != false) {
				wait.until(ExpectedConditions.visibilityOf(checkout.promoOpt)).click();
				System.out.println("click at one promotion");
			}

		}catch(Exception ex) {}
		isLoadImgEnabled();
		// end change prmotions dropdown
		//change quantity
		scroll(mybag.txtProductQty.get(0));
		mybag.txtProductQty.get(0).sendKeys(Keys.BACK_SPACE + "2"+ Keys.TAB);
		isLoadImgEnabled();
		// end change quantity
		//finalize purchase
		checkout.submitOrder.click();
		waitForVisibilityOf(checkout.snackBarError);
		// end finalize purchase
	}
	
	public void logOut() throws InterruptedException {
		scroll(checkout.imgLogoHome);
		checkout.imgLogoHome.click();
		homePage();
		// logout
		waitForVisibilityOf(home.userNameSession);
		hoverOn(home.userNameSession);
		waitForVisibilityOf(myaccount.divPoUPMySession);
		hoverOn(home.userNameSession);
		waitForVisibilityOf(myaccount.divPoUPMySession);
		wait.until(ExpectedConditions.visibilityOf(home.mySessionLinks.get(5))).click();
		homePage();
		//end logout
	}
	
	private void isLoadImgEnabled() {
		try {
			waitForVisibilityOf(pdp.imgLoading);
			wait.until(ExpectedConditions.invisibilityOf(pdp.imgLoading));
		}catch(Exception ex) {}
	}
	
	private void addtocart() {
		waitForVisibilityOf(pdp.pProductInfoCode);
		waitForVisibilityOf(pdp.btnAddToCart);
		try{
			scroll(pdp.divGeoLocation);
			if(pdp.btnSize.isDisplayed() != false) {
				wait.until(ExpectedConditions.visibilityOf(pdp.btnSize)).click();
				System.out.println("clicked at btn size");
			}
		}
		catch(Exception Ex) {}
		//pdp.btnAddToCart.click();
		wait.until(ExpectedConditions.visibilityOf(pdp.btnAddToCart)).click();
		scroll(home.txtSearchBar);
		waitForVisibilityOf(pdp.alertContainer);
		wait.until(ExpectedConditions.invisibilityOf(pdp.alertContainer));
	}
	
	private void navigateMyAccount(int index, WebElement waitForElement) throws InterruptedException {
		waitForVisibilityOf(home.userNameSession);
		hoverOn(home.userNameSession);
		waitForVisibilityOf(myaccount.divPoUPMySession);
		waitForVisibilityOf(home.mySessionLinks.get(index));
		System.out.println("click At: "+ home.mySessionLinks.get(index).getText());
		home.mySessionLinks.get(index).click();
		waitForVisibilityOf(waitForElement);
	}
	
	private void search(String searchTerm) {
		wait.until(ExpectedConditions.elementToBeClickable(home.txtSearchBar)).click();
		home.txtSearchBar.clear();
		home.txtSearchBar.sendKeys(searchTerm + Keys.ENTER);
		waitForVisibilityOf(plp.cmbSortBy);
		///waitForVisibilityOf(plp.imgProduct_pdp); NECESITA CAMBIARSE POR LA LISTA.
	}

}
