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
		wait.until(ExpectedConditions.visibilityOf(home.carouselOnesection));
	}
	
	public void LogIn() throws InterruptedException {
		homePage();
		home.linkLogIn.click();
		pageLoad();
		waitForVisibilityOf(login.txtUserName);
		waitForVisibilityOf(login.btnLogIn);
		login.txtUserName.sendKeys("test.ccheck.app011005@gmail.com");
		login.txtPassword.sendKeys("12345678");
		login.btnLogIn.click();
	}
	
	public void navigateUserSessionOpt() throws InterruptedException{
		pageLoad();
		// init timer Mi cuenta
		navigateMyAccount(0,myaccount.listAside);
		waitForVisibilityOf(myaccount.divPersonalData);
		// end
		// init timer mis compras
		navigateMyAccount(1,myaccount.listAside);
		waitForVisibilityOf(myaccount.orderFilter);
		// end
		// init timer
		navigateMyAccount(2,myaccount.listAside);
		waitForVisibilityOf(myaccount.myCouponsTemplate);
		// end
		// init mis tarjetas
		navigateMyAccount(4,myaccount.defaultCart); // (*)
		waitForVisibilityOf(myaccount.btnAddCard);
		// end
		// init timer mi tiempo aire
		navigateMyAccount(3,myaccount.btnAddNumber);
		waitForVisibilityOf(myaccount.btnSubmitRecharge);
		// end
	}
	
	public void addItems() throws InterruptedException{
		//search with key world
		search("sofa");
		//click random product
		plp.imgProduct_pdp.get(0).click();
		// add to cart item 1
		addtocart();
		// end
		search("laptop"); //not going to measure
		plp.imgProduct_pdp.get(0).click();
		// add to cart item 2
		addtocart();
		//end
		search("perfumes"); //not going to measure
		plp.imgProduct_pdp.get(0).click();
		// add to cart item 3
		addtocart();
		
	}
	
	public void myBag() throws InterruptedException {
		//init timer ir a bolsa
		wait.until(ExpectedConditions.elementToBeClickable(home.linkMyBag)).click();
		System.out.println("in my cart page");
		isLoadImgEnabled();
		pageLoad();
		//waitForVisibilityOf(mybag.divColumnProduct);
		waitForVisibilityOf(mybag.btnBuyNowProduct);
		wait.until(ExpectedConditions.visibilityOfAllElements(mybag.txtProductQty));
		//System.out.println("how many input qty there are: " + mybag.txtProductQty.size());
		// end
		mybag.txtProductQty.get(0).sendKeys(Keys.BACK_SPACE);
		mybag.txtProductQty.get(0).sendKeys("2");//+ Keys.TAB
		isLoadImgEnabled();
		waitForVisibilityOf(mybag.btnBuyNowProduct);
		wait.until(ExpectedConditions.visibilityOf(mybag.txtProductQty.get(1))).sendKeys(Keys.BACK_SPACE);
		mybag.txtProductQty.get(1).sendKeys("2"); //+ Keys.TAB
		isLoadImgEnabled();
		waitForVisibilityOf(mybag.btnBuyNowProduct);
		//System.out.println("how many save to later button appear: "+ mybag.btnSaveProduct.size());
		waitForVisibilityOf(mybag.btnSaveProduct.get(2));
	    mybag.btnSaveProduct.get(2).click();
	    isLoadImgEnabled();
	    waitForVisibilityOf(mybag.btnBuyNowProduct);
		scroll(home.txtSearchBar);
	} 
	
	public void oneCheckOut() throws InterruptedException {
		// init timer comprar ahora
		wait.until(ExpectedConditions.visibilityOf(mybag.btnBuyNowProduct)).click();
		isLoadImgEnabled();
		pageLoad();
		waitForVisibilityOf(checkout.txtchangeAddress);
		System.out.println("click 1-----at buy now");
		// end
		//click collect
		checkout.txtchangeAddress.click();
		isLoadImgEnabled();
		waitForVisibilityOf(checkout.btnContinue);
		checkout.btnclickCollect.click();
		waitForVisibilityOf(checkout.cmbState);
		Select state = new Select(checkout.cmbState);
		checkout.cmbState.click();
		state.selectByVisibleText("NUEVO LEÓN");
		isLoadImgEnabled();
		try { waitForVisibilityOf(checkout.containerPickUPStore);
		}catch(Exception ex) {}
		checkout.btnContinue.click();
		isLoadImgEnabled();
		//wait.until(ExpectedConditions.visibilityOf(checkout.alertChangeAddress));
		wait.until(ExpectedConditions.invisibilityOf(checkout.alertChangeAddress));
		System.out.println("click 2----- click collect");
		//end 
		//forma de pago
		wait.until(ExpectedConditions.elementToBeClickable(checkout.linkChangeCard)).click();
		isLoadImgEnabled();
		waitForVisibilityOf(checkout.btnPaymentContinue);
		checkout.txtCardExpiration.sendKeys("0924");
		checkout.txtCVV.sendKeys("345");
		checkout.btnPaymentContinue.click();
		isLoadImgEnabled();
		wait.until(ExpectedConditions.invisibilityOf(checkout.alertPayMethod));
		System.out.println("click 3----- forma de pago");
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
				System.out.println("click 4----- promotion");
			}
		}catch(Exception ex) {}
		isLoadImgEnabled();
		/* quantity
		scroll(mybag.txtProductQty.get(0));
		mybag.txtProductQty.get(0).sendKeys(Keys.BACK_SPACE + "1"+ Keys.TAB);
		isLoadImgEnabled();
		System.out.println("click 5----- quantity");
		*/
		scroll(mybag.txtProductQty.get(0));
		System.out.println("aqui");
		checkout.submitOrder.click();
		wait.until(ExpectedConditions.visibilityOf(checkout.snackBarError)).click();
		System.out.println("click 6----- finalize purchase");
		//-toTop shipping-alert m-alert__container mdc-snackbar -alertCheckout -step1 -success -toTop
		//-toTop shipping-alert m-alert__container mdc-snackbar -alertCheckout -step1 -success mdc-snackbar--open
	}
	
	public void oneCheckoutTwo() {
		waitForVisibilityOf(checkout.txtchangeAddress);
		// entrega a tu domicilio
		checkout.txtchangeAddress.click();
		isLoadImgEnabled();
		waitForVisibilityOf(checkout.btnContinue);
		wait.until(ExpectedConditions.elementToBeClickable(checkout.btnHomeDelivery)).click();
		checkout.rdoMyAddress.click();
		checkout.btnContinue.click();
		isLoadImgEnabled();
		//wait.until(ExpectedConditions.visibilityOf(checkout.alertChangeAddress));
		wait.until(ExpectedConditions.invisibilityOf(checkout.alertChangeAddress));
		// end entrega tu domicilio
		System.out.println("click 7----- predeterminado domicilio");
		//forma de pago
		wait.until(ExpectedConditions.visibilityOf(checkout.linkChangeCard)).click();
		isLoadImgEnabled();
		waitForVisibilityOf(checkout.btnPaymentContinue);
		checkout.txtCardExpiration.sendKeys("0924");
		checkout.txtCVV.sendKeys("345");
		checkout.btnPaymentContinue.click();
		isLoadImgEnabled();
		wait.until(ExpectedConditions.invisibilityOf(checkout.alertPayMethod));
		//end forma de pago
		System.out.println("click 8----- forma de pago");
		try {
		//change prmotions dropdown
			scroll(checkout.btnPromotion);
			System.out.println("scroll to promotion");
			waitForVisibilityOf(checkout.btnPromotion);
			checkout.btnPromotion.click();
			System.out.println("click at promotion link");
			isLoadImgEnabled();
			if(checkout.promoOpt.isDisplayed() != false) {
				wait.until(ExpectedConditions.elementToBeClickable(checkout.promoOpt)).click();
				System.out.println("click 9----- change promotion");
			}

		}catch(Exception ex) {}
		isLoadImgEnabled();
		// end change prmotions dropdown
		/*change quantity
		scroll(mybag.txtProductQty.get(0));
		mybag.txtProductQty.get(0).sendKeys(Keys.BACK_SPACE + "2"+ Keys.TAB);
		isLoadImgEnabled();
		/*/ 
		System.out.println("click 10-----  quantity ");
		//finalize purchase
		checkout.submitOrder.click();
		wait.until(ExpectedConditions.visibilityOf(checkout.snackBarError)).click();
		// end finalize purchase
		System.out.println("click 11----- finalize");
	}
	
	public void logOut() throws InterruptedException {
		scroll(checkout.imgLogoHome);
		checkout.imgLogoHome.click();
		homePage();
		// logout
		//cerrar sesion
		navigateMyAccount(5,home.carouselOnesection);
		//end
		homePage();
		//end logout
	}
	
	private void isLoadImgEnabled() {
		try {
			//waitForVisibilityOf(pdp.imgLoading);
			wait.until(ExpectedConditions.visibilityOf(pdp.imgLoading));
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
		wait.until(ExpectedConditions.elementToBeClickable(pdp.btnAddToCart)).click();
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
		pageLoad();
		waitForVisibilityOf(waitForElement);
	}
	
	private void search(String searchTerm) {
		wait.until(ExpectedConditions.elementToBeClickable(home.txtSearchBar)).click();
		home.txtSearchBar.clear();
		home.txtSearchBar.sendKeys(searchTerm + Keys.ENTER);
		refreshedAllAndClickable(plp.imgProduct_pdp);
		///waitForVisibilityOf(plp.imgProduct_pdp); NECESITA CAMBIARSE POR LA LISTA.
	}

}
