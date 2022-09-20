package e_commerceLiverpool_Library;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import e_commerceLiverpool_Pages.FQA_Page;
import e_commerceLiverpool_Pages.GiftRegistry_Page;
import e_commerceLiverpool_Pages.Home_Page;
import e_commerceLiverpool_Pages.Login_Page;
import e_commerceLiverpool_Pages.MyBag_Page;
import e_commerceLiverpool_Pages.PDP_Page;
import e_commerceLiverpool_Pages.PLP_Page;
import e_commerceLiverpool_Pages.StoreLocator_Page;

public class Browse_Library extends BaseLibrary{

	private Home_Page home;
	private PLP_Page plp;
	private PDP_Page pdp;
	private WebDriverWait wait;
	private Login_Page login;
	private MyBag_Page mybag;
	private GiftRegistry_Page gift;
	private StoreLocator_Page stores;
	private FQA_Page faq;
	private String scenario = "Browse";
	public Browse_Library(WebDriver driver){
		super(driver);
		home = new Home_Page(driver);
		plp = new PLP_Page(driver);
		pdp = new PDP_Page(driver);
		login = new Login_Page(driver);
		mybag = new MyBag_Page(driver);
		gift = new GiftRegistry_Page(driver);
		stores = new StoreLocator_Page(driver);
		faq = new FQA_Page(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void homePage() throws InterruptedException {
		startTimer(scenario,"homepage");
		pageLoad();
		waitForVisibilityOf(home.carouselOnesection);
		stopTimer();
		// end
	}
	
	public void carouselOneSection() throws InterruptedException {
		startTimer(scenario,"Carousel_one_section");
		navigateCarousel(home.carouselOnesection);
		stopTimer();
		home.imgLogo.click();
		homePage();
	}
	
	public void carouselTwoSection() throws InterruptedException {
		startTimer(scenario,"carousel_two_section");
		navigateCarousel(home.carouselTwosection);
		stopTimer();
	}

	public void OnCategories() throws InterruptedException {
		startTimer(scenario,"category_l1");
		hoverOn(home.linkCategories);
		Thread.sleep(500);
		hoverOn(home.linkCategories);
		wait.until(ExpectedConditions.visibilityOf(home.categoryL1)).click();
		pageLoad();
		waitForVisibilityOf(plp.imgL2);
		stopTimer();
		// end L1
		startTimer(scenario,"category_l2");
		wait.until(ExpectedConditions.visibilityOf(plp.linkL2_L4)).click();
		pageLoad();
		wait.until(ExpectedConditions.visibilityOfAllElements(plp.imgsLinkL3));
		stopTimer();
		//end L2
		startTimer(scenario,"category_l3");
		plp.linkVerTodo.click();
		pageLoad();
		wait.until(ExpectedConditions.visibilityOfAllElements(plp.imgProduct_pdp));
		stopTimer();
		// end l3
	}

	public void navigateL3Filters() throws InterruptedException {
		startTimer(scenario,"listing_view");
		plp.iconListView.click();
		waitForVisibilityOf(plp.divListingView);
		refreshedAllAndClickable(plp.imgProduct_pdp);
		stopTimer();
		// end
		plp.iconGridView.click();
		waitForVisibilityOf(plp.divGridView);
		refreshedAllAndClickable(plp.imgProduct_pdp);
		startTimer(scenario,"filter_price");
		selectFilter(plp.chbxPrice);
		stopTimer();
		//end
		startTimer(scenario,"remove_filter");
		cleanFilter();
		stopTimer();
		startTimer(scenario,"filter_discount");
		selectFilter(plp.chbxPromotion.get(4));
		stopTimer();
		//end
		startTimer(scenario,"remove_filter");
		cleanFilter();
		stopTimer();
		startTimer(scenario,"filter_brand");
		selectFilter(plp.chbxBrand);
		stopTimer();
		// end
		startTimer(scenario,"remove_filter");
		cleanFilter();
		stopTimer();
		startTimer(scenario,"filter_color");
		selectFilter(plp.chbxColor);
		stopTimer();
		// end
		startTimer(scenario,"remove_filter");
		cleanFilter();
		stopTimer();
		startTimer(scenario,"filter_rating");
		selectFilter(plp.chbxRating);
		stopTimer();
		// end
		startTimer(scenario,"remove_filter");
		cleanFilter();
		stopTimer();
		startTimer(scenario,"filter_sold_by");
		selectFilter(plp.chbxSoldBy);
		stopTimer();
		//end
		startTimer(scenario,"remove_filter");
		cleanFilter();
		refreshedAllAndClickable(plp.imgProduct_pdp);
		stopTimer();
	}
	
	public void navigateL3SortBy() {
		startTimer(scenario,"sort_relevance");
		sortBy(0, "Relevancia");
		stopTimer();
		// end
		startTimer(scenario,"sort_lowest_price");
		sortBy(2, "Menor precio");
		stopTimer();
		// end
		startTimer(scenario,"sort_highest_price");
		sortBy(3, "Mayor precio");
		stopTimer();
		// end
		startTimer(scenario,"sort_rating");
		sortBy(4, "Calificaciones");
		stopTimer();
		// end
		startTimer(scenario,"sort_most_viewed");
		sortBy(5, "Más visto");
		stopTimer();
		// end
		startTimer(scenario,"sort_most_selled");
		sortBy(6, "Más vendido");
		stopTimer();
		// end
	}
	
	public void onCategoryL4PDP() throws InterruptedException {
		//try{
		startTimer(scenario,"category_l4");
			if(plp.linkL2_L4.isDisplayed() != false) {
				plp.linkL2_L4.click();
				wait.until(ExpectedConditions.visibilityOf(plp.iconL2));
				refreshedAllAndClickable(plp.imgProduct_pdp);
				stopTimer();
				//end
				startTimer(scenario,"click_random_product");
				plp.imgProduct_pdp.get(0).click();
				pageLoad();
				waitForVisibilityOf(pdp.pProductInfoCode);
				stopTimer();
				// end
				startTimer(scenario,"change_zip_code");
				wait.until(ExpectedConditions.visibilityOf(pdp.linkEnterZipCode)).click();
				home.txtCity.sendKeys("64000"+ Keys.ENTER);
				waitForVisibilityOf(pdp.linkChangeZipcode);
				wait.until(ExpectedConditions.textToBePresentInElement(pdp.myZipCode, "C.P. 64000"));
				stopTimer();
				//end 
				try {
					startTimer(scenario,"select_size");
					scrollDown();
					Thread.sleep(500);
					if(pdp.btnSize.isDisplayed() != false) {
						wait.until(ExpectedConditions.elementToBeClickable(pdp.btnSize)).click();
						System.out.println("clicked at size button");
						refreshedAndClickable(pdp.viewerImgPDP);
						stopTimer();
						// end
					}
					else {System.out.println("not going to write in DB");}
					if(pdp.linkColor.isDisplayed() != false) {
						startTimer(scenario,"select_color");
						wait.until(ExpectedConditions.elementToBeClickable(pdp.linkColor)).click();
						System.out.println("clicked at color button");
						refreshedAndClickable(pdp.viewerImgPDP);
						stopTimer();
						//end
					}
					else {System.out.println("not goint to write in DB");}					/*
					if(pdp.txtProductQty.isDisplayed() != false) {
						//init timer change quantity
						pdp.txtProductQty.sendKeys(Keys.BACK_SPACE + "2"+ Keys.TAB);
						wait.until(ExpectedConditions.textToBePresentInElementValue(pdp.txtProductQty, "2"));
						System.out.println("change quantity");
						//duda
						//end
					}*/
				}catch(Exception ex) {}
				//scroll(home.txtSearchBar);
				scrollUp();
				startTimer(scenario,"check_availability");
				wait.until(ExpectedConditions.elementToBeClickable(pdp.stockStore)).click();
				waitForVisibilityOf(pdp.selectStateStock);
				pdp.selectStateStock.click();
				waitForVisibilityOf(pdp.divAvailabilityDetails);
				pdp.closeModal.click();
				stopTimer();
				// end
				startTimer(scenario,"add_to_cart");
				wait.until(ExpectedConditions.visibilityOf(pdp.btnAddToCart)).click();
				scroll(home.txtSearchBar);
				waitForVisibilityOf(pdp.alertContainer);
				wait.until(ExpectedConditions.invisibilityOf(pdp.alertContainer));
				stopTimer();
				// end
				startTimer(scenario,"share_social_media");
				scroll(pdp.btnSize);
				Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(pdp.linkShareTo)).click();
				waitForVisibilityOf(pdp.btnFacebook);
				pdp.closeCompartir.click();
				stopTimer();
				//end
				startTimer(scenario,"carousel_related_products");
				scrollToBottom();
				wait.until(ExpectedConditions.visibilityOf(pdp.carousel));
				scroll(pdp.carousel);
				wait.until(ExpectedConditions.visibilityOf(pdp.carousel)).click();
				refreshedAndClickable(pdp.viewerImgPDP);
				waitForVisibilityOf(pdp.pProductInfoCode);
				stopTimer();
				// end
				try {
					Thread.sleep(500);
					scrollDown();
					wait.until(ExpectedConditions.visibilityOf(pdp.btnSize));
					if(pdp.btnSize.isDisplayed() != false) {
						pdp.btnSize.click();
						refreshedAndClickable(pdp.viewerImgPDP);
					}
					startTimer(scenario,"buy_now");
					scroll(home.txtSearchBar);
					wait.until(ExpectedConditions.elementToBeClickable(pdp.btnBuyNow)).click();
					waitForVisibilityOf(login.txtUserName);
					stopTimer();
					// end
					home.imgLogoBackLogin.click();
					home.imgLogo.click();
					homePage();
				}catch(Exception ex) {}
			}
		//} catch(Exception ex) {}
	}
	
	public void navigateHomeLinks() throws InterruptedException {
		startTimer(scenario,"navigate_my_orders");
		//scroll(home.txtSearchBar);
		scrollUp();
		waitForVisibilityOf(home.linkMyBag);
		wait.until(ExpectedConditions.visibilityOf(home.linkMyShoppings)).click();
		pageLoad();
		waitForVisibilityOf(login.txtUserName);
		stopTimer();
		// end
		home.imgLogoBackLogin.click();
		homePage();
		startTimer(scenario,"navigate_gift_table");
		wait.until(ExpectedConditions.visibilityOf(home.linkGiftTablePage)).click();
		pageLoad();
		waitForVisibilityOf(gift.btnGotoSearchGift);
		stopTimer();
		// end
		startTimer(scenario,"navigate_my_credit");
		home.linkMyCredit.click();
		pageLoad();
		waitForVisibilityOf(home.requestCard);
		stopTimer();
		// end
		startTimer(scenario,"navigate_my_stores");
		home.linkStores.click();
		pageLoad();
		waitForVisibilityOf(stores.btnMapOpt);
		stopTimer();
		// end
		startTimer(scenario,"navigate_store_appointments");
		home.inStoreAppointments.click();
		pageLoad();
		waitForVisibilityOf(login.txtUserName);
		stopTimer();
		// end
		home.imgLogoBackLogin.click();
		homePage();
		startTimer(scenario,"navigate_my_bag");
		home.linkMyBag.click();
		pageLoad();
		try {
			wait.until(ExpectedConditions.visibilityOf(mybag.btnBuyNowProduct));
			refreshedAndClickable(mybag.btnBuyNowProduct);
			waitForVisibilityOf(mybag.divColumnProduct);
		}catch(Exception ex) {}
		stopTimer();
		// end
		startTimer(scenario,"navigate_help");
		wait.until(ExpectedConditions.visibilityOf(home.linkHelp)).click();
		pageLoad();
		waitForVisibilityOf(faq.linkViewAll);
		waitForVisibilityOf(faq.linkCreditoPage);
		stopTimer();
	}
	
	private void selectFilter(WebElement filterBy) {
		scroll(filterBy);
		filterBy.click();
		wait.until(ExpectedConditions.visibilityOf(plp.linkCleanfilters));
		refreshedAllAndClickable(plp.imgProduct_pdp);
	}
	
	private void cleanFilter() throws InterruptedException {
		scroll(plp.linkCleanfilters);
		wait.until(ExpectedConditions.visibilityOf(plp.linkCleanfilters)).click();
		Thread.sleep(1500);
	}
	
	private void navigateCarousel(WebElement carouselSection) throws InterruptedException {
		scroll(carouselSection);
		carouselSection.click();
		try {
			pageLoad();
			refreshedAndClickable(pdp.pProductInfoCode);
			
		}catch(Exception e){}
	}
	
	private void sortBy(int index, String sortBy) {
		plp.cmbSortBy.click();
		plp.dropDownItems.get(index).click();
		wait.until(ExpectedConditions.textToBePresentInElement(plp.cmbSortBy, sortBy));
		System.out.println("combo: "+plp.cmbSortBy.getText());
		refreshedAllAndClickable(plp.imgProduct_pdp);
	}
	
}
