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
	int stepdelay = 0;
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
		//init timer homePage no login
		pageLoad();
		wait.until(ExpectedConditions.visibilityOf(home.carouselOnesection));
		// end
	}
	
	public void carouselOneSection() throws InterruptedException {
		//init timer carousel one section
		navigateCarousel(home.carouselOnesection);
		System.out.println("carousel one");
		// end
		home.imgLogo.click();
	}
	
	public void carouselTwoSection() throws InterruptedException {
		homePage();
		//init timer carousel two section
		navigateCarousel(home.carouselTwosection);
		// end
		System.out.println("carousel two");
	}

	public void OnCategories() throws InterruptedException {
		// init timer onCategoryL1
		hoverOn(home.linkCategories);
		wait.until(ExpectedConditions.visibilityOf(home.categoryL1)).click();
		pageLoad();
		waitForVisibilityOf(plp.imgL2);
		System.out.println("category L1");
		// end L1
		//init timer onCategoryL2
		wait.until(ExpectedConditions.visibilityOf(plp.linkL2_L4)).click();
		pageLoad();
		wait.until(ExpectedConditions.visibilityOfAllElements(plp.imgsLinkL3));
		System.out.println("category L2");
		//end L2
		//init timer onCategoryL3
		plp.linkVerTodo.click();
		pageLoad();
		wait.until(ExpectedConditions.visibilityOfAllElements(plp.imgProduct_pdp));
		System.out.println("category L3");
		// end
	}

	public void navigateL3Filters() throws InterruptedException {
		// init timer listingView
		plp.iconListView.click();
		waitForVisibilityOf(plp.divListingView);
		//wait.until(ExpectedConditions.visibilityOf(plp.divListingView));
		wait.until(ExpectedConditions.visibilityOfAllElements(plp.imgProduct_pdp));
		System.out.println("listing view");
		// end
		plp.iconGridView.click();
		waitForVisibilityOf(plp.divGridView);
		wait.until(ExpectedConditions.visibilityOfAllElements(plp.imgProduct_pdp));
		// init timer filterprice
		selectFilter(plp.chbxPrice);
		System.out.println("by price");
		//end
		cleanFilter();
		// init timer filterpromotions
		selectFilter(plp.chbxPromotion.get(4));
		System.out.println("by discount");
		//end
		cleanFilter();
		//init timer filterbrand
		selectFilter(plp.chbxBrand);
		System.out.println("by brand");
		// end
		cleanFilter();
		// init timer filtercolor
		selectFilter(plp.chbxColor);
		System.out.println("by color");
		// end
		cleanFilter();
		// init timer filterRating
		selectFilter(plp.chbxRating);
		System.out.println("by rating");
		// end
		cleanFilter();
		// init timer filtersoldBy
		selectFilter(plp.chbxSoldBy);
		System.out.println("sold by");
		//end
		cleanFilter();
	}
	
	public void navigateL3SortBy() {
		// init timer sortByRelevancia
		sortBy(0, "Relevancia");
		// end
		// init timer sortByMenorprecio
		sortBy(2, "Menor precio");
		// end
		// init timer soldByMayorprecio
		sortBy(3, "Mayor precio");
		// end
		// init timer sortByCalificaciones
		sortBy(4, "Calificaciones");
		// end
		// init timer sortByMasVisto
		sortBy(5, "Más visto");
		// end
		// init timer sortByMasVendido
		sortBy(6, "Más vendido");
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
					Thread.sleep(500);
					wait.until(ExpectedConditions.visibilityOf(pdp.btnSize)).click();
					System.out.println("clicked at size button");
					refreshedAndClickable(pdp.viewerImgPDP);
					scroll(home.txtSearchBar);
					Thread.sleep(500);
					// init timer buy now
					wait.until(ExpectedConditions.elementToBeClickable(pdp.btnBuyNow)).click();
					waitForVisibilityOf(login.txtUserName);
					System.out.println("clicked at buy now");
					//end
				}catch(Exception ex) {}
			}
		//} catch(Exception ex) {}
	}
	
	public void navigateHomeLinks() throws InterruptedException {
		home.imgLogoBackLogin.click();
		homePage();
		//init timer my bag
		wait.until(ExpectedConditions.visibilityOf(home.linkMyBag)).click();
		try {
			waitForVisibilityOf(mybag.btnBuyNowProduct);
		}catch(Exception ex) {}
		//init timer mis compras
		home.linkMyShoppings.click();
		waitForVisibilityOf(login.txtUserName);
		//end
		home.imgLogoBackLogin.click();
		homePage();
		//init timer mesa de regalo
		wait.until(ExpectedConditions.visibilityOf(home.linkGiftTable)).click();
		waitForVisibilityOf(gift.btnGoToGift);
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
		//init timer ayuda page
		wait.until(ExpectedConditions.visibilityOf(home.linkHelp)).click();
		pageLoad();
		waitForVisibilityOf(faq.linkViewAll);
		waitForVisibilityOf(faq.mainQuestions);
	}
	private void selectFilter(WebElement filterBy) {
		scroll(filterBy);
		filterBy.click();
		waitForVisibilityOf(plp.linkCleanfilters);
		//wait.until(ExpectedConditions.visibilityOf(plp.linkCleanfilters));
		//refreshedAndClickable(plp.imgProduct_pdp.get(10));
		refreshedAllAndClickable(plp.imgProduct_pdp);
		//wait.until(ExpectedConditions.visibilityOfAllElements(plp.imgProduct_pdp));
	}
	private void cleanFilter() throws InterruptedException {
		scroll(plp.linkCleanfilters);
		wait.until(ExpectedConditions.elementToBeClickable(plp.linkCleanfilters)).click();
		Thread.sleep(1500);
	}
	private void navigateCarousel(WebElement carouselSection) throws InterruptedException {
		scroll(carouselSection);
		carouselSection.click();
		try {
			pageLoad();
			waitForVisibilityOf(pdp.pProductInfoCode);
			//wait.until(ExpectedConditions.visibilityOf(pdp.pProductInfoCode));
			
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
