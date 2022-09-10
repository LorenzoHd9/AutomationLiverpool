package e_commerceLiverpool_Library;

import java.time.Duration;

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
	int stepDelay = 2000;
	public Search_Library(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		home = new Home_Page(driver);
		plp = new PLP_Page(driver);
		pdp = new PDP_Page(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void homePage() throws InterruptedException {
		// start "Home page" measuring
		pageLoad();
		wait.until(ExpectedConditions.visibilityOf(home.carouselOnesection));
		// end
		System.out.println("home page loaded");
	}
	
	public void searchKeyword() throws InterruptedException {
		/*choose first one*/
		System.out.println("choose first one");
		search("vinos", 0);
		Thread.sleep(stepDelay);
		/*choose second one*/
		System.out.println("choose second one");
		search("iphone", 1);
		Thread.sleep(stepDelay);
		/*choose third one*/
		System.out.println("choose third one");
		search("ojos", 2);
		Thread.sleep(stepDelay);
		/* choose random prodcut*/
		System.out.println("choose random product");
		home.txtSearchBar.clear();
		home.txtSearchBar.sendKeys("mochilas");
		wait.until(ExpectedConditions.visibilityOfAllElements(home.typeAheadResults));
		wait.until(ExpectedConditions.visibilityOfAllElements(home.imgTypeAhead));
		home.imgTypeAhead.click();
		//wait.until(ExpectedConditions.visibilityOf(.));
		waitForVisibilityOf(pdp.pProductInfoCode);
		Thread.sleep(stepDelay);
		/* buscar en marcas */
		System.out.println("buscar en marcas");
		search("ps4",5);
		Thread.sleep(stepDelay);
		/*buscar en categorias*/
		System.out.println("buscar en categorias");
		search("ojos",6);
		/*on Category l1*/
		
		/*on category L2*/
		
		/*on category L3*/
		
	}
	
	public void searchID() {
		home.txtSearchBar.clear();
		home.txtSearchBar.sendKeys("vin ojo sal");
		
	}
	private void search(String keyword, int index) throws InterruptedException {
		//homePage();
		wait.until(ExpectedConditions.visibilityOf(home.txtSearchBar)).click();
		home.txtSearchBar.clear();
		home.txtSearchBar.sendKeys(keyword);
		wait.until(ExpectedConditions.visibilityOfAllElements(home.typeAheadResults));
		System.out.println(home.typeAheadResults.size());
		home.typeAheadResults.get(index).click();
		wait.until(ExpectedConditions.visibilityOf(plp.divGridView));
		//wait.until(ExpectedConditions.visibilityOf(plp.imgProduct_pdp));
		//waitForVisibilityOf(plp.imgProduct_pdp);  NECESIU CAMBIARSE POR LA LISTA
	}
}
