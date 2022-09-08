package e_commerceLiverpool_Library;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import e_commerceLiverpool_Pages.GiftRegistry_Page;
import e_commerceLiverpool_Pages.Home_Page;
import e_commerceLiverpool_Pages.MyBag_Page;
import e_commerceLiverpool_Pages.PDP_Page;
import e_commerceLiverpool_Pages.PLP_Page;

public class Browse_Library extends BaseLibrary{

	private Home_Page home;
	private PLP_Page plp;
	private PDP_Page pdp;
	private MyBag_Page mybag;
	private GiftRegistry_Page gift;
	private WebDriverWait wait;
	//private WebDriver driver;
	int stepdelay = 2000;
	public Browse_Library(WebDriver driver){
		super(driver);
		home = new Home_Page(driver);
		plp = new PLP_Page(driver);
		pdp = new PDP_Page(driver);
		mybag = new MyBag_Page(driver);
		gift = new GiftRegistry_Page(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	}
	
	public void homePage() throws InterruptedException {
		// start "Home page" measuring
		pageLoad();
		wait.until(ExpectedConditions.visibilityOf(home.carouselOnesection));
		// end
		System.out.println("home page loaded");
	}
	
	public void carouselOneSection() throws InterruptedException {
		//start "carousel one section" measuring 
		navigateCarousel(home.carouselOnesection);
		// end
		System.out.println("carousel one");
		home.imgLogo.click();
	}
	
	public void carouselTwoSection() throws InterruptedException {
		//start "carousel one section" measuring 
		navigateCarousel(home.carouselTwosection);
		// end
		System.out.println("carousel two");
		home.imgLogo.click();
	}
	// navigates category L1, L2 and L3
	public void OnCategories() throws InterruptedException {
		Thread.sleep(stepdelay);
		// start "On category L1" measuring
		hoverOn(home.linkCategories);
		//home.linkCategories.click();
		hoverOn(home.categoryL1);
		home.categoryL1.click();
		wait.until(ExpectedConditions.visibilityOf(plp.imgL2));
		// end L1
		System.out.println("category L1");
		Thread.sleep(stepdelay);
		/*start L2*/
		plp.linkL2_L4.click(); 
		wait.until(ExpectedConditions.visibilityOf(plp.imgLinkL3));
		//end L2
		System.out.println("category L2");
		Thread.sleep(stepdelay);
		/*start L3*/
		plp.linkVerTodo.click();
		wait.until(ExpectedConditions.visibilityOf(plp.imgProduct_pdp));
		System.out.println("category L3");
		// end
	}
	// Navigates PLP options on L3 category
	public void onCategoryL3() throws InterruptedException {
		Thread.sleep(stepdelay);
		/*start */
		plp.iconListView.click();
		wait.until(ExpectedConditions.visibilityOf(plp.divListingView));
		plp.iconGridView.click();
		wait.until(ExpectedConditions.visibilityOf(plp.divGridView));
		System.out.println("listing view");
		Thread.sleep(stepdelay);
		/* filter by price*/
		selectFilter(plp.chbxPrice);
		Thread.sleep(stepdelay);
		//cleanFilter();
		System.out.println("by price");
		/* filter by discount*/
		selectFilter(plp.chbxPromotion);
		Thread.sleep(stepdelay);
		cleanFilter();
		System.out.println("by discount");
		/* filter by brand*/
		selectFilter(plp.chbxBrand);
		Thread.sleep(stepdelay);
		cleanFilter();
		System.out.println("by brand");
		/* filter by color*/
		selectFilter(plp.chbxColor);
		Thread.sleep(stepdelay);
		cleanFilter();
		System.out.println("by color");
		/* filter by rating*/
		selectFilter(plp.chbxRating);
		Thread.sleep(stepdelay);
		cleanFilter();
		System.out.println("by rating");
		/* filter by soldBy*/
		selectFilter(plp.chbxSoldBy);
		Thread.sleep(stepdelay);
		cleanFilter();
		System.out.println("sold by");
		/*sort By Relevancia index 0*/
		sortBy(0);
		System.out.println("relevancia");
		Thread.sleep(stepdelay);
		/*sort By Menor precio index 2*/
		sortBy(2);
		System.out.println("menor precio");
		Thread.sleep(stepdelay);
		/*sort By Mayor precio index 3*/
		sortBy(3);
		System.out.println("mayor precio");
		Thread.sleep(stepdelay);
		/*sort By Calificaciones index 4*/
		sortBy(4);
		System.out.println("calificaciones");
		Thread.sleep(stepdelay);
		/*sort By Mas visto index 5*/
		sortBy(5);
		System.out.println("mas visto");
		Thread.sleep(stepdelay);
		/*sort By Mas vendido index 6*/
		sortBy(6);
		System.out.println("mas vendido");
		Thread.sleep(stepdelay);
		/*start click product pdp*/
		wait.until(ExpectedConditions.visibilityOf(plp.imgProduct_pdp));
		plp.imgProduct_pdp.click();
		wait.until(ExpectedConditions.visibilityOf(pdp.pProductInfoCode));
		/*start back home with logo liverpool*/
		onCategoryL4();
	}
	public void onCategoryL4() throws InterruptedException {
		//Thread.sleep(2000);
		home.imgLogo.click();
		OnCategories();
		plp.linkL2_L4.click();
		wait.until(ExpectedConditions.visibilityOf(plp.iconL2));
		wait.until(ExpectedConditions.visibilityOf(plp.imgProduct_pdp));
		plp.imgProduct_pdp.click();
		wait.until(ExpectedConditions.visibilityOf(pdp.pProductInfoCode));
		try {
			scroll(pdp.btnSize);
			pdp.btnSize.click();
			System.out.println("inside try{}");
		}
		catch(Exception ex) {}
		System.out.println("clicked at btn size");
		scroll(pdp.pProductInfoCode);
		pdp.stockStore.click();
		System.out.println("click at stock");
		if(pdp.modalNotification.isDisplayed()) {
			System.out.println("modal notification show up");
			scroll(pdp.btnSize);
			pdp.btnSize.click();
		}
		wait.until(ExpectedConditions.visibilityOf(pdp.selectState));
		pdp.selectState.click();
		wait.until(ExpectedConditions.visibilityOf(pdp.tabContentAvailability));
		pdp.closeModal.click();
	}
	
	private void selectFilter(WebElement filterBy) {
		scroll(filterBy);
		filterBy.click();
		wait.until(ExpectedConditions.visibilityOf(plp.linkCleanfilters));
		wait.until(ExpectedConditions.visibilityOf(plp.imgProduct_pdp));
	}
	private void cleanFilter() throws InterruptedException {
		scroll(plp.linkCleanfilters);
		plp.linkCleanfilters.click();
		wait.until(ExpectedConditions.invisibilityOf(plp.linkCleanfilters));
		Thread.sleep(stepdelay);
	}
	private void navigateCarousel(WebElement carouselSection) throws InterruptedException {
		homePage();
		scroll(carouselSection);
		carouselSection.click();
		try {
			wait.until(ExpectedConditions.visibilityOf(pdp.pProductInfoCode));
		}
		catch(Exception e) {
			System.out.println("no loaded second code product");
		}
	}
	private void sortBy(int index) {
		plp.cmbSortBy.click();
		//System.out.println(plp.dropDownItems.size());
		plp.dropDownItems.get(index).click();
		wait.until(ExpectedConditions.visibilityOf(plp.divGridView));
		wait.until(ExpectedConditions.visibilityOf(plp.imgProduct_pdp));
	}
}
