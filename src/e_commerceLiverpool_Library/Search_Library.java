package e_commerceLiverpool_Library;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import e_commerceLiverpool_Pages.Home_Page;
import e_commerceLiverpool_Pages.PDP_Page;
import e_commerceLiverpool_Pages.PLP_Page;

public class Search_Library extends BaseLibrary{

	private WebDriverWait wait;
	private Home_Page home;
	private PLP_Page plp;
	private PDP_Page pdp;
	String scenario = "Search";
	public Search_Library(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		home = new Home_Page(driver);
		plp = new PLP_Page(driver);
		pdp = new PDP_Page(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void homePage() throws InterruptedException {
		startTimer(scenario, "homepage");
		pageLoad();
		wait.until(ExpectedConditions.visibilityOf(home.carouselOnesection));
		stopTimer();
	}
	
	public void searchKeyword() throws InterruptedException {
		startTimer(scenario,"search_choose_firstOne");
		search("vinos", 0);
		stopTimer();
		// end
		startTimer(scenario,"search_choose_secondOne");
		search("iphone", 1);
		stopTimer();
		// end
		startTimer(scenario,"search_choose_thirdOne");
		search("ojos", 2);
		stopTimer();
		// end
		startTimer(scenario,"search_choose_randomProduct");
		wait.until(ExpectedConditions.visibilityOf(home.txtSearchBar)).click();
		home.txtSearchBar.clear();
		home.txtSearchBar.sendKeys("mochilas");
		refreshedAllAndClickable(home.imgTypeAhead);
		home.imgTypeAhead.get(0).click();
		waitForVisibilityOf(pdp.pProductInfoCode);
		stopTimer();
		// end
		startTimer(scenario,"search_on_brand");
		search("ps4",5);
		stopTimer();
		// end
		startTimer(scenario,"search_on_category");
		search("ojos",6);
		stopTimer();
		
	}
	
	public void searchID() throws InterruptedException {
		startTimer(scenario,"search_productID");
		search("1092197938", 00);
		stopTimer();
	}
	
	public void searchThreeCharacters() throws InterruptedException {
		home.imgLogo.click();
		homePage();
		startTimer(scenario,"three_characters_firstOne");
		search("ojo",0);
		stopTimer();
		startTimer(scenario,"three_characters_searchOne");
		search("sal",1);
		stopTimer();
		startTimer(scenario,"three_characters_thirdOne");
		search("vin",2);
		stopTimer();
		startTimer(scenario,"three_characters_randomProdcut");
		wait.until(ExpectedConditions.visibilityOf(home.txtSearchBar)).click();
		home.txtSearchBar.clear();
		home.txtSearchBar.sendKeys("sal");
		wait.until(ExpectedConditions.visibilityOfAllElements(home.imgTypeAhead));
		home.imgTypeAhead.get(0).click();
		pageLoad();
		waitForVisibilityOf(pdp.pProductInfoCode);
		stopTimer();
		startTimer(scenario,"three_characters_on_brand");
		search("vin",5);
		stopTimer();
		startTimer(scenario,"three_characters_on_category");
		search("sal",6);
		stopTimer();
	}
	
	private void search(String keyword, int index) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(home.txtSearchBar)).click();
		home.txtSearchBar.clear();
		home.txtSearchBar.sendKeys(keyword);
		if(index != 00) {
			refreshedAllAndClickable(home.typeAheadResults);
			home.typeAheadResults.get(index).click();
			//pageLoad();
			refreshedAllAndClickable(plp.imgProduct_pdp);
		}
		else {
			home.txtSearchBar.sendKeys(Keys.ENTER);
			try {
				waitForVisibilityOf(pdp.pProductInfoCode);
			}catch(Exception ex){}
		}
	}
}
