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
	public Search_Library(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		home = new Home_Page(driver);
		plp = new PLP_Page(driver);
		pdp = new PDP_Page(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void homePage() throws InterruptedException {
		pageLoad();
		wait.until(ExpectedConditions.visibilityOf(home.carouselOnesection));
		System.out.println("home page loaded");
	}
	
	public void searchKeyword() throws InterruptedException {
		/*choose first one*/
		search("vinos", 0);
		System.out.println("choose first one");
		/*choose second one*/
		search("iphone", 1);
		System.out.println("choose second one");
		/*choose third one*/
		search("ojos", 2);
		System.out.println("choose third one");
		/* choose random prodcut*/
		wait.until(ExpectedConditions.visibilityOf(home.txtSearchBar)).click();
		home.txtSearchBar.clear();
		home.txtSearchBar.sendKeys("mochilas");
		refreshedAllAndClickable(home.imgTypeAhead);
		//wait.until(ExpectedConditions.visibilityOfAllElements(home.imgTypeAhead));
		home.imgTypeAhead.get(0).click();
		waitForVisibilityOf(pdp.pProductInfoCode);
		System.out.println("choose random product");
		/* buscar en marcas */
		search("ps4",5);
		System.out.println("buscar en marcas");
		/*buscar en categorias*/
		search("ojos",6);
		System.out.println("buscar en categorias");
		
	}
	
	public void searchID() throws InterruptedException {
		search("1092197938", 00);
		System.out.println("By ID ----------------");
		//1092197938
	}
	
	public void searchTreeCharacters() throws InterruptedException {
		home.imgLogo.click();
		homePage();
		search("ojo",0);
		System.out.println("Three characters one");
		search("sal",1);
		System.out.println("Three characters second one");
		search("vin",2);
		System.out.println("Three characters third one");
		wait.until(ExpectedConditions.visibilityOf(home.txtSearchBar)).click();
		home.txtSearchBar.clear();
		home.txtSearchBar.sendKeys("sal");
		wait.until(ExpectedConditions.visibilityOfAllElements(home.imgTypeAhead));
		home.imgTypeAhead.get(0).click();
		pageLoad();
		waitForVisibilityOf(pdp.pProductInfoCode);
		System.out.println("Three characters choose random product");
		/* buscar en marcas */
		search("vin",5);
		System.out.println("Three characters buscar en marcas");
		/*buscar en categorias*/
		search("sal",6);
		System.out.println("Three characters buscar en categorias");
	}
	
	private void search(String keyword, int index) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(home.txtSearchBar)).click();
		home.txtSearchBar.clear();
		home.txtSearchBar.sendKeys(keyword);
		if(index != 00) {
			refreshedAllAndClickable(home.typeAheadResults);
			System.out.println(home.typeAheadResults.size());
			home.typeAheadResults.get(index).click();
			pageLoad();
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
