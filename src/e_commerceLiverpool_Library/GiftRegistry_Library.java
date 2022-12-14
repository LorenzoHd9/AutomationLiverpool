package e_commerceLiverpool_Library;

import java.io.IOException;
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
	String scenario = "gift_registry_web";
	public GiftRegistry_Library(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		home = new Home_Page(driver);
		gift = new GiftRegistry_Page(driver);
		// TODO Auto-generated constructor stub
	}

	public void searchByName() throws InterruptedException, IOException {
		startTimer(scenario,"homepage");
		pageLoad();
		wait.until(ExpectedConditions.visibilityOf(home.carouselOnesection));
		stopTimer();
		startTimer(scenario,"navigate_gift_table_page1");
		gotoGiftRegistrypage();
		stopTimer();
		//end
		startTimer(scenario,"search_gift_table_by_name");
		gift.btnGotoSearchGift.click();
		waitForVisibilityOf(gift.txtFirstName);
		gift.txtFirstName.sendKeys("Diana");
		gift.txtParentName.sendKeys("caballero");
		wait.until(ExpectedConditions.elementToBeClickable(gift.btnSearchGift)).click();
		wait.until(ExpectedConditions.invisibilityOf(gift.imgLoading));
		wait.until(ExpectedConditions.visibilityOfAllElements(gift.btnSeeList));
		stopTimer();
		startTimer(scenario,"see_list_event");
		gift.btnSeeList.get(0).click();
		wait.until(ExpectedConditions.invisibilityOf(gift.imgLoading));
		wait.until(ExpectedConditions.visibilityOfAllElements(gift.allProductsImg));
		stopTimer();
		//end
	}
	
	public void searchByID() throws InterruptedException, IOException {
		startTimer(scenario,"navigate_gift_table_page2");
		gotoGiftRegistrypage();
		stopTimer();
		// end
		startTimer(scenario,"search_gift_table_by_event_id");
		gift.btnGotoSearchGift.click();
		waitForVisibilityOf(gift.txtFirstName);
		scroll(gift.txtEventNumber);
		gift.txtEventNumber.sendKeys("50186810");
		wait.until(ExpectedConditions.elementToBeClickable(gift.btnSearchID)).click();
		wait.until(ExpectedConditions.invisibilityOf(gift.imgLoading));
		wait.until(ExpectedConditions.visibilityOfAllElements(gift.allProductsImg));
		stopTimer();
		//end
	}
	
	private void gotoGiftRegistrypage() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(home.linkGiftTablePage)).click();
		pageLoad();
		waitForVisibilityOf(gift.btnGotoSearchGift);
	}
	
}
