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
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	}
	
	public void homePage() throws InterruptedException {
		startTimer("homepage");
		pageLoad();
		waitForVisibilityOf(home.carouselOnesection);
		stopTimer(scenario);
		//wait.until(ExpectedConditions.visibilityOf(home.carouselOnesection));
		// end
	}
	
	public void carouselOneSection() throws InterruptedException {
		//init timer carousel one section
		startTimer("Carousel one section");
		navigateCarousel(home.carouselOnesection);
		//System.out.println("carousel one");
		stopTimer(scenario);
		// end
		home.imgLogo.click();
	}
	
	public void carouselTwoSection() throws InterruptedException {
		homePage();
		//init timer carousel two section
		startTimer("Carousel one section");
		navigateCarousel(home.carouselTwosection);
		stopTimer(scenario);
		// end
		//System.out.println("carousel two");
		home.imgLogo.click();
	}

	public void OnCategories() throws InterruptedException {
		homePage();
		// init timer onCategoryL1
		startTimer("Category L1");
		hoverOn(home.linkCategories);
		wait.until(ExpectedConditions.visibilityOf(home.categoryL1)).click();
		pageLoad();
		waitForVisibilityOf(plp.imgL2);
		stopTimer(scenario);
		//System.out.println("category L1");
		// end L1
		//init timer onCategoryL2
		startTimer("Category L2");
		wait.until(ExpectedConditions.visibilityOf(plp.linkL2_L4)).click();
		pageLoad();
		wait.until(ExpectedConditions.visibilityOfAllElements(plp.imgsLinkL3));
		System.out.println("category L2");
		stopTimer(scenario);
		//end L2
		//init timer onCategoryL3
		startTimer("Category L3");
		plp.linkVerTodo.click();
		pageLoad();
		wait.until(ExpectedConditions.visibilityOfAllElements(plp.imgProduct_pdp));
		//System.out.println("category L3");
		stopTimer(scenario);
		// end
	}

	public void navigateL3Filters() throws InterruptedException {
		// init timer listingView
		startTimer("Listing View");
		plp.iconListView.click();
		waitForVisibilityOf(plp.divListingView);
		//wait.until(ExpectedConditions.visibilityOfAllElements(plp.imgProduct_pdp));
		refreshedAllAndClickable(plp.imgProduct_pdp);
		//System.out.println("listing view");
		stopTimer(scenario);
		// end
		plp.iconGridView.click();
		waitForVisibilityOf(plp.divGridView);
		refreshedAllAndClickable(plp.imgProduct_pdp);
		//wait.until(ExpectedConditions.visibilityOfAllElements(plp.imgProduct_pdp));
		// init timer filterprice
		startTimer("Filter by Price");
		selectFilter(plp.chbxPrice);
		//System.out.println("by price");
		stopTimer(scenario);
		//end
		cleanFilter();
		// init timer filterpromotions
		startTimer("Filter by Discount");
		selectFilter(plp.chbxPromotion.get(4));
		//System.out.println("by discount");
		stopTimer(scenario);
		//end
		cleanFilter();
		//init timer filterbrand
		startTimer("Filter by Brand");
		selectFilter(plp.chbxBrand);
		//System.out.println("by brand");
		stopTimer(scenario);
		// end
		cleanFilter();
		// init timer filtercolor
		startTimer("Filter by Color");
		selectFilter(plp.chbxColor);
		//System.out.println("by color");
		stopTimer(scenario);
		// end
		cleanFilter();
		// init timer filterRating
		startTimer("Filter by Rating");
		selectFilter(plp.chbxRating);
		//System.out.println("by rating");
		stopTimer(scenario);
		// end
		cleanFilter();
		// init timer filtersoldBy
		startTimer("Filter by Sold By");
		selectFilter(plp.chbxSoldBy);
		//System.out.println("sold by");
		stopTimer(scenario);
		//end
		cleanFilter();
		refreshedAllAndClickable(plp.imgProduct_pdp);
	}
	
	public void navigateL3SortBy() {
		// init timer sortByRelevancia
		startTimer("Sort by relevancia");
		sortBy(0, "Relevancia");
		stopTimer(scenario);
		// end
		// init timer sortByMenorprecio
		startTimer("Sort by Menor precio");
		sortBy(2, "Menor precio");
		stopTimer(scenario);
		// end
		// init timer soldByMayorprecio
		startTimer("Sort by Mayor precio");
		sortBy(3, "Mayor precio");
		stopTimer(scenario);
		// end
		// init timer sortByCalificaciones
		startTimer("Sort by Calificaciones");
		sortBy(4, "Calificaciones");
		stopTimer(scenario);
		// end
		// init timer sortByMasVisto
		startTimer("Sort by Mas visto");
		sortBy(5, "Más visto");
		stopTimer(scenario);
		// end
		// init timer sortByMasVendido
		startTimer("Sort by Mas vendido");
		sortBy(6, "Más vendido");
		stopTimer(scenario);
		// end
	}
	
	public void onCategoryL4PDP() throws InterruptedException {
		//try{
			if(plp.linkL2_L4.isDisplayed() != false) {
				//System.out.println("Category L4 is found");
				// init timer oncategoryL4
				plp.linkL2_L4.click();
				wait.until(ExpectedConditions.visibilityOf(plp.iconL2));
				refreshedAllAndClickable(plp.imgProduct_pdp);
				System.out.println("Category L4");
				//end
				// init timer clickRandomProduct PDP
				plp.imgProduct_pdp.get(0).click();
				pageLoad();
				waitForVisibilityOf(pdp.pProductInfoCode);
				System.out.println("selected Product random PDP");
				// end
				// init timer enter zip code
				wait.until(ExpectedConditions.visibilityOf(pdp.linkEnterZipCode)).click();
				home.txtCity.sendKeys("64000"+ Keys.ENTER);
				waitForVisibilityOf(pdp.linkChangeZipcode);
				wait.until(ExpectedConditions.textToBePresentInElement(pdp.myZipCode, "C.P. 64000"));
				System.out.println("entered my zip code");
				//end 
				try {
					scrollDown();
					Thread.sleep(500);
					//System.out.println("is size displayed: "+pdp.btnSize.isDisplayed());
					if(pdp.btnSize.isDisplayed() != false) {
						// init timer elegir tamano/ talla
						wait.until(ExpectedConditions.elementToBeClickable(pdp.btnSize)).click();
						System.out.println("clicked at size button");
						refreshedAndClickable(pdp.viewerImgPDP);
						// end
					}
					else {System.out.println("not going to write in DB");}
					if(pdp.linkColor.isDisplayed() != false) {
						//init timer elegir color
						wait.until(ExpectedConditions.elementToBeClickable(pdp.linkColor)).click();
						System.out.println("clicked at color button");
						refreshedAndClickable(pdp.viewerImgPDP);
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
				//init timer availability on store
				//scroll(home.txtSearchBar);
				scrollUp();
				wait.until(ExpectedConditions.elementToBeClickable(pdp.stockStore)).click();
				System.out.println("click at stock");
				waitForVisibilityOf(pdp.selectStateStock);
				pdp.selectStateStock.click();
				waitForVisibilityOf(pdp.divAvailabilityDetails);
				pdp.closeModal.click();
				System.out.println("clicked disponibilidad en tienda");
				//end
				// init add to my bag
				wait.until(ExpectedConditions.visibilityOf(pdp.btnAddToCart)).click();
				scroll(home.txtSearchBar);
				waitForVisibilityOf(pdp.alertContainer);
				wait.until(ExpectedConditions.invisibilityOf(pdp.alertContainer));
				System.out.println("added to my shopping cart");
				// end
				scroll(pdp.btnSize);
				Thread.sleep(500);
				// init timer shared on socila media
				wait.until(ExpectedConditions.elementToBeClickable(pdp.linkShareTo)).click();
				waitForVisibilityOf(pdp.btnFacebook);
				pdp.closeCompartir.click();
				System.out.println("click at share on social media");
				//end
				// init timer look for similar products
				scrollToBottom();
				wait.until(ExpectedConditions.visibilityOf(pdp.carousel));
				scroll(pdp.carousel);
				wait.until(ExpectedConditions.visibilityOf(pdp.carousel)).click();
				refreshedAndClickable(pdp.viewerImgPDP);
				waitForVisibilityOf(pdp.pProductInfoCode);
				System.out.println("select one similar item in the carousel");
				// end
				try {
					Thread.sleep(500);
					scrollDown();
					wait.until(ExpectedConditions.visibilityOf(pdp.btnSize));
					if(pdp.btnSize.isDisplayed() != false) {
						pdp.btnSize.click();
						System.out.println("clicked at size button ultimo");
						refreshedAndClickable(pdp.viewerImgPDP);
					}
					scroll(home.txtSearchBar);
					// init timer buy now
					wait.until(ExpectedConditions.elementToBeClickable(pdp.btnBuyNow)).click();
					waitForVisibilityOf(login.txtUserName);
					System.out.println("no iniciar sesion");
					//end
					home.imgLogoBackLogin.click();
					System.out.println("back");
					home.imgLogo.click();
					homePage();
					System.out.println("home loaded");
				}catch(Exception ex) {}
			}
		//} catch(Exception ex) {}
	}
	
	public void navigateHomeLinks() throws InterruptedException {
		System.out.println("init links home");
		scroll(home.txtSearchBar);
		waitForVisibilityOf(home.linkMyBag);
		//init timer mis compras
		wait.until(ExpectedConditions.visibilityOf(home.linkMyShoppings)).click();
		pageLoad();
		waitForVisibilityOf(login.txtUserName);
		//end
		home.imgLogoBackLogin.click();
		homePage();
		//init timer mesa de regalo
		wait.until(ExpectedConditions.visibilityOf(home.linkGiftTablePage)).click();
		pageLoad();
		waitForVisibilityOf(gift.btnGotoSearchGift);
		//end 
		//init timer 
		home.linkMyCredit.click();
		pageLoad();
		waitForVisibilityOf(home.requestCard);
		// end
		// init timer tiendas
		home.linkStores.click();
		pageLoad();
		waitForVisibilityOf(stores.btnMapOpt);
		//end
		//init timer citas en tiendas
		home.inStoreAppointments.click();
		pageLoad();
		waitForVisibilityOf(login.txtUserName);
		//end
		home.imgLogoBackLogin.click();
		homePage();
		//init timer my bag
		home.linkMyBag.click();
		pageLoad();
		try {
			wait.until(ExpectedConditions.visibilityOf(mybag.btnBuyNowProduct));
			refreshedAndClickable(mybag.btnBuyNowProduct);
			waitForVisibilityOf(mybag.divColumnProduct);
			System.out.println("my bag link done");
		}catch(Exception ex) {}
		// end
		//init timer ayuda page
		wait.until(ExpectedConditions.visibilityOf(home.linkHelp)).click();
		pageLoad();
		waitForVisibilityOf(faq.linkViewAll);
		waitForVisibilityOf(faq.linkCreditoPage);
		//end
	}
	private void selectFilter(WebElement filterBy) {
		scroll(filterBy);
		filterBy.click();
		wait.until(ExpectedConditions.visibilityOf(plp.linkCleanfilters));
		refreshedAllAndClickable(plp.imgProduct_pdp);
		//wait.until(ExpectedConditions.visibilityOfAllElements(plp.imgProduct_pdp));
	}
	private void cleanFilter() throws InterruptedException {
		scroll(plp.linkCleanfilters);
		wait.until(ExpectedConditions.visibilityOf(plp.linkCleanfilters)).click();
		//refreshedAllAndClickable(plp.imgProduct_pdp);
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
