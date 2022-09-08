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
		// init go to gift registry
		wait.until(ExpectedConditions.visibilityOf(home.linkGiftTable)).click();
		pageLoad();
		wait.until(ExpectedConditions.visibilityOf(gift.btnGoToGift));
		gift.btnGoToGift.click();
		wait.until(ExpectedConditions.visibilityOf(gift.txtFirstName)).sendKeys("diana");
		wait.until(ExpectedConditions.visibilityOf(gift.txtParentName)).sendKeys("caballero");
		wait.until(ExpectedConditions.visibilityOf(gift.btnSearchGift));
		gift.btnSearchGift.click();
		wait.until(ExpectedConditions.invisibilityOf(gift.imgLoading));
		wait.until(ExpectedConditions.visibilityOf(gift.btnSeeList)).click();
		wait.until(ExpectedConditions.invisibilityOf(gift.imgLoading));
		wait.until(ExpectedConditions.visibilityOf(gift.imgCelebrated));
	}
	
	public void searchByID() throws InterruptedException {
		Thread.sleep(3000);
		// init go to gift registry
		wait.until(ExpectedConditions.visibilityOf(home.linkGiftTable));
		home.linkGiftTable.click();
		pageLoad();
		// Search by ID
		wait.until(ExpectedConditions.visibilityOf(gift.btnGoToGift)).click();
		wait.until(ExpectedConditions.visibilityOf(gift.txtEventNumber));
		scroll(gift.txtEventNumber);
		gift.txtEventNumber.sendKeys("50841501");
		wait.until(ExpectedConditions.visibilityOf(gift.btnSearchID)).click();
		wait.until(ExpectedConditions.invisibilityOf(gift.imgLoading));
		wait.until(ExpectedConditions.visibilityOf(gift.imgCelebrated));
	}
}
