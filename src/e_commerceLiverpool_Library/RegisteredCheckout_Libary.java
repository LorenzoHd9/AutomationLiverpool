package e_commerceLiverpool_Library;

import java.io.IOException;
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
	String scenario = "registered_user_checkout_web";
	public RegisteredCheckout_Libary(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		wait = new WebDriverWait(driver, Duration.ofSeconds(45));
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
	
	public void LogIn() throws InterruptedException, IOException {
		homePage();
		startTimer(scenario,"navigate_login_Page");
		home.linkLogIn.click();
		pageLoad();
		waitForVisibilityOf(login.txtUserName);
		waitForVisibilityOf(login.btnLogIn);
		stopTimer();
		startTimer(scenario,"fill_and_login");
		login.txtUserName.sendKeys("test.ccheck.app011005@gmail.com");
		login.txtPassword.sendKeys("12345678");
		login.btnLogIn.click();
		pageLoad();
		stopTimer();
	}
	
	public void cleanCart() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(home.linkMyBag)).click();
		startTimer(scenario,"clean_cart");
		isLoadImgEnabled();
		pageLoad();
		try {
			/*wait.until(ExpectedConditions.elementToBeClickable(mybag.tabMyBag)).click();
			wait.until(ExpectedConditions.elementToBeClickable(mybag.btnDelete)).click();
			isLoadImgEnabled();refreshedAndClickable(mybag.btnDelete);mybag.btnDelete.click();
			isLoadImgEnabled(); */
			wait.until(ExpectedConditions.elementToBeClickable(mybag.tabItemSaved)).click();
			//refreshedAndClickable(mybag.btnDelete);//mybag.btnDelete.click();
			wait.until(ExpectedConditions.elementToBeClickable(mybag.btnDelete)).click();
			secureClick(home.imgLogo);//home.imgLogo.click();
			stopTimer();
			homePage();
		}
		catch(Exception ex) {
			secureClick(home.imgLogo);//home.imgLogo.click();
			homePage();
			}
		}
	
	public void navigateUserSessionOpt() throws Exception{
		startTimer(scenario,"naviagte_my_cards");
		navigateMyAccount(4,myaccount.btnAddCard); // (*)
		//waitForVisibilityOf(myaccount.btnAddCard);
		stopTimer();
		// end
		startTimer(scenario,"naviagte_my_account");
		navigateMyAccount(0,myaccount.divPersonalData);
		//waitForVisibilityOf(myaccount.divPersonalData);
		stopTimer();
		// end
		startTimer(scenario,"naviagte_my_shoppings");
		navigateMyAccount(1,myaccount.orderFilter);
		//waitForVisibilityOf(myaccount.orderFilter);
		stopTimer();
		// end
		startTimer(scenario,"naviagte_my_coupons");
		navigateMyAccount(2,myaccount.myCouponsTemplate);
		//waitForVisibilityOf(myaccount.myCouponsTemplate);
		stopTimer();
		// end
		startTimer(scenario,"naviagte_airtime_recharge");
		navigateMyAccount(3,myaccount.btnSubmitRecharge);
		//waitForVisibilityOf(myaccount.btnSubmitRecharge);
		stopTimer();
		// end
	}
	
	public void addItems() throws InterruptedException, IOException{
		startTimer(scenario,"search_item1");
		search("sofa");
		stopTimer();
		// end
		startTimer(scenario,"click_random_product1");
		plp.imgProduct_pdp.get(0).click();
		waitForVisibilityOf(pdp.pProductInfoCode);
		waitForVisibilityOf(pdp.btnAddToCart);
		stopTimer();
		// end
		startTimer(scenario,"add_to_cart_item1");
		addtocart();
		stopTimer();
		// end
		startTimer(scenario,"search_item2");
		search("laptop");
		stopTimer();
		startTimer(scenario,"click_random_product2");
		plp.imgProduct_pdp.get(0).click();
		waitForVisibilityOf(pdp.pProductInfoCode);
		waitForVisibilityOf(pdp.btnAddToCart);
		stopTimer();
		startTimer(scenario,"add_to_cart_item2");
		addtocart();
		stopTimer();
		//end
		startTimer(scenario,"search_item3");
		search("perfumes"); //not going to measure
		stopTimer();
		startTimer(scenario,"click_random_product3");
		plp.imgProduct_pdp.get(0).click();
		waitForVisibilityOf(pdp.pProductInfoCode);
		waitForVisibilityOf(pdp.btnAddToCart);
		stopTimer();
		startTimer(scenario,"add_to_cart_item3");
		addtocart();
		stopTimer();
	}
	
	public void myBag() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(home.linkMyBag)).click();
		startTimer(scenario,"navigate_to_my_bag");
		isLoadImgEnabled();
		pageLoad();
		waitForVisibilityOf(mybag.btnBuyNowProduct);
		wait.until(ExpectedConditions.visibilityOfAllElements(mybag.txtProductQty));
		stopTimer();
		// end
		startTimer(scenario,"change_quantity_item1");
		mybag.txtProductQty.get(0).sendKeys(Keys.BACK_SPACE);
		mybag.txtProductQty.get(0).sendKeys("2"+ Keys.TAB);//+ Keys.TAB
		isLoadImgEnabled();
		waitForVisibilityOf(mybag.btnBuyNowProduct);
		stopTimer();
		// end
		startTimer(scenario,"change_quantity_item2");
		wait.until(ExpectedConditions.visibilityOf(mybag.txtProductQty.get(1))).sendKeys(Keys.BACK_SPACE);
		mybag.txtProductQty.get(1).sendKeys("2"+ Keys.TAB); //+ Keys.TAB
		isLoadImgEnabled();
		waitForVisibilityOf(mybag.btnBuyNowProduct);
		stopTimer();
		// end
		try {
			System.out.println("error displayed: "+ pdp.alertCloseError.isDisplayed());
			if(pdp.alertCloseError.isDisplayed() == true) {
				pdp.alertCloseError.click();
				Thread.sleep(3000);
			}
		}
		catch(Exception ex) {}
		startTimer(scenario,"save_to_buy_later");
		waitForVisibilityOf(mybag.btnSaveProduct.get(2));
		scroll(mybag.btnSaveProduct.get(2));//mybag.divColumnProduct.click();
		secureClick(mybag.divColumnProduct);
		secureClick(mybag.btnSaveProduct.get(2));
	    //mybag.btnSaveProduct.get(2).click();
	    isLoadImgEnabled();
	    waitForVisibilityOf(mybag.btnBuyNowProduct);
		scroll(home.txtSearchBar);
		stopTimer();
	} 
	
	public void oneCheckOut() throws Exception {
		startTimer(scenario,"buy_now_item1");
		wait.until(ExpectedConditions.visibilityOf(mybag.btnBuyNowProduct)).click();
		isLoadImgEnabled();
		waitForVisibilityOf(checkout.txtchangeAddress);
		stopTimer();
		// end
		startTimer(scenario,"click_collect");
		//checkout.txtchangeAddress.click();
		secureClick(checkout.txtchangeAddress);
		isLoadImgEnabled();
		waitForVisibilityOf(checkout.btnContinue);
		checkout.btnclickCollect.click();
		waitForVisibilityOf(checkout.cmbState);
		Select state = new Select(checkout.cmbState);
		secureClick(checkout.cmbState);
		//checkout.cmbState.click();
		state.selectByVisibleText("NUEVO LEÓN");
		isLoadImgEnabled();
		try { waitForVisibilityOf(checkout.containerPickUPStore);
		}catch(Exception ex) {}
		checkout.btnContinue.click();
		isLoadImgEnabled();
		wait.until(ExpectedConditions.invisibilityOf(checkout.alertChangeAddress));
		stopTimer();
		//end
		startTimer(scenario,"pay_form1");
		wait.until(ExpectedConditions.elementToBeClickable(checkout.linkChangeCard)).click();
		isLoadImgEnabled();
		waitForVisibilityOf(checkout.btnPaymentContinue);
		checkout.txtCardExpiration.sendKeys("0924");
		checkout.txtCVV.sendKeys("345");
		checkout.btnPaymentContinue.click();
		isLoadImgEnabled();
		wait.until(ExpectedConditions.invisibilityOf(checkout.alertPayMethod));
		stopTimer();
		//end
		try {
			startTimer(scenario,"change_promotion1");
			scroll(checkout.btnPromotion);
			waitForVisibilityOf(checkout.btnPromotion);
			checkout.btnPromotion.click();
			isLoadImgEnabled();
			if(checkout.promoOpt.isDisplayed() != false) {
				waitForVisibilityOf(checkout.promoOpt);
				checkout.promoOpt.click();
				isLoadImgEnabled();
				stopTimer();
			}
		}catch(Exception ex) {}
		/* quantity
		scroll(mybag.txtProductQty.get(0));
		mybag.txtProductQty.get(0).sendKeys(Keys.BACK_SPACE + "1"+ Keys.TAB);
		isLoadImgEnabled();
		System.out.println("click 5----- quantity");
		*/
		startTimer(scenario,"finalize_purchase1");
		scroll(mybag.txtProductQty.get(0));
		checkout.submitOrder.click();
		wait.until(ExpectedConditions.visibilityOf(checkout.snackBarError)).click();
		stopTimer();
	}
	
	public void oneCheckoutTwo() throws InterruptedException, IOException {
		startTimer(scenario,"home_delivery");
		waitForVisibilityOf(checkout.txtchangeAddress);
		checkout.txtchangeAddress.click();
		isLoadImgEnabled();
		waitForVisibilityOf(checkout.btnContinue);
		wait.until(ExpectedConditions.elementToBeClickable(checkout.btnHomeDelivery)).click();
		checkout.rdoMyAddress.click();
		checkout.btnContinue.click();
		isLoadImgEnabled();
		wait.until(ExpectedConditions.invisibilityOf(checkout.alertChangeAddress));
		stopTimer();
		// end
		startTimer(scenario,"pay_form2");
		wait.until(ExpectedConditions.visibilityOf(checkout.linkChangeCard)).click();
		isLoadImgEnabled();
		waitForVisibilityOf(checkout.btnPaymentContinue);
		checkout.txtCardExpiration.sendKeys("0924");
		checkout.txtCVV.sendKeys("345");
		checkout.btnPaymentContinue.click();
		isLoadImgEnabled();
		wait.until(ExpectedConditions.invisibilityOf(checkout.alertPayMethod));
		stopTimer();
		//end
		try {
			startTimer(scenario,"change_promotion_checkout2");
			scroll(checkout.btnPromotion);
			waitForVisibilityOf(checkout.btnPromotion);
			checkout.btnPromotion.click();
			isLoadImgEnabled();
			if(checkout.promoOpt.isDisplayed() != false) {
				wait.until(ExpectedConditions.elementToBeClickable(checkout.promoOpt)).click();
				isLoadImgEnabled();
				stopTimer();
			}

		}catch(Exception ex) {}
		// end change prmotions dropdown
		/*change quantity
		scroll(mybag.txtProductQty.get(0));
		mybag.txtProductQty.get(0).sendKeys(Keys.BACK_SPACE + "2"+ Keys.TAB);
		isLoadImgEnabled();
		/*/ 
		startTimer(scenario,"finalize_purchase_checkout2");
		checkout.submitOrder.click();
		wait.until(ExpectedConditions.visibilityOf(checkout.snackBarError)).click();
		stopTimer();
	}
	
	public void logOut() throws Exception {
		startTimer(scenario,"homepage");
		scroll(checkout.imgLogoHome);
		checkout.imgLogoHome.click();
		refreshedAndClickable(home.carouselOnesection);
		stopTimer();
		startTimer(scenario,"logout");
		navigateMyAccount(5,home.carouselOnesection);
		homePage();
		stopTimer();
	}
	
	private void isLoadImgEnabled() {
		try {
			//waitForVisibilityOf(pdp.imgLoading);
			wait.until(ExpectedConditions.visibilityOf(pdp.imgLoading));
			wait.until(ExpectedConditions.invisibilityOf(pdp.imgLoading));
		}catch(Exception ex) {}
	}
	
	private void addtocart() {
		try{
			scroll(pdp.divGeoLocation);
			if(pdp.btnSize.isDisplayed() != false) {
				wait.until(ExpectedConditions.visibilityOf(pdp.btnSize)).click();
			}
		}
		catch(Exception Ex) {}
		wait.until(ExpectedConditions.elementToBeClickable(pdp.btnAddToCart)).click();
		scroll(home.txtSearchBar);
		waitForVisibilityOf(pdp.alertContainer);
		wait.until(ExpectedConditions.invisibilityOf(pdp.alertContainer));
	}
	
	private void navigateMyAccount(int index, WebElement waitForElement) throws Exception {
		waitForVisibilityOf(home.userNameSession);
		hoverOn(home.userNameSession);
		wait.until(ExpectedConditions.elementToBeClickable(myaccount.divPoUPMySession));
		//waitForVisibilityOf(myaccount.divPoUPMySession);
		wait.until(ExpectedConditions.elementToBeClickable(home.mySessionLinks.get(index)));
		//waitForVisibilityOf(home.mySessionLinks.get(index));//home.mySessionLinks.get(index).click();
		secureClick(home.mySessionLinks.get(index));
		pageLoad();
		try {
			waitForVisibilityOf(waitForElement);
		}
		catch(Exception ex) {
		}
	}
	
	private void search(String searchTerm) {
		wait.until(ExpectedConditions.elementToBeClickable(home.txtSearchBar)).click();
		home.txtSearchBar.clear();
		home.txtSearchBar.sendKeys(searchTerm + Keys.ENTER);
		refreshedAllAndClickable(plp.imgProduct_pdp);
		///waitForVisibilityOf(plp.imgProduct_pdp); NECESITA CAMBIARSE POR LA LISTA.
	}

}
