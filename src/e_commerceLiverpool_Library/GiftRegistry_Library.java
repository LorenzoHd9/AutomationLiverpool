package e_commerceLiverpool_Library;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import e_commerceLiverpool_Pages.GiftRegistry_Page;
import e_commerceLiverpool_Pages.Home_Page;

public class GiftRegistry_Library extends BaseLibrary{

	private WebDriverWait wait;
	private Home_Page home;
	private GiftRegistry_Page gift;
	public GiftRegistry_Library(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		home = new Home_Page(driver);
		gift = new GiftRegistry_Page(driver);
		// TODO Auto-generated constructor stub
	}

	public void searchByName() throws InterruptedException {
		pageLoad();
		wait.until(ExpectedConditions.visibilityOf(home.carouselOnesection));
		//init timer go to gift Registry page
		gotoGiftRegistrypage();
		//end
		// init timer search gift table by name
		gift.btnGotoSearchGift.click();
		waitForVisibilityOf(gift.txtFirstName);
		gift.txtFirstName.sendKeys("Diana");
		gift.txtParentName.sendKeys("caballero");
		wait.until(ExpectedConditions.elementToBeClickable(gift.btnSearchGift)).click();
		wait.until(ExpectedConditions.invisibilityOf(gift.imgLoading));
		wait.until(ExpectedConditions.visibilityOfAllElements(gift.btnSeeList));
		gift.btnSeeList.get(0).click();
		wait.until(ExpectedConditions.invisibilityOf(gift.imgLoading));
		wait.until(ExpectedConditions.visibilityOfAllElements(gift.allProductsImg));
		//end
	}
	
	public void searchByID() throws InterruptedException {
		gotoGiftRegistrypage();
		// Search by ID
		gift.btnGotoSearchGift.click();
		waitForVisibilityOf(gift.txtFirstName);
		scroll(gift.txtEventNumber);
		gift.txtEventNumber.sendKeys("50841501");
		wait.until(ExpectedConditions.elementToBeClickable(gift.btnSearchID)).click();
		wait.until(ExpectedConditions.invisibilityOf(gift.imgLoading));
		wait.until(ExpectedConditions.visibilityOfAllElements(gift.allProductsImg));
		//end
	}
	
	private void gotoGiftRegistrypage() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(home.linkGiftTablePage)).click();
		pageLoad();
		waitForVisibilityOf(gift.btnGotoSearchGift);
	}
	
}
