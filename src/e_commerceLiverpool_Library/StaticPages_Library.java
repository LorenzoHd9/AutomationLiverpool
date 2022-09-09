package e_commerceLiverpool_Library;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import e_commerceLiverpool_Pages.FQA_Page;
import e_commerceLiverpool_Pages.Home_Page;
import e_commerceLiverpool_Pages.StoreLocator_Page;

public class StaticPages_Library extends BaseLibrary{

	private Home_Page home;
	private FQA_Page faq;
	private StoreLocator_Page stores;
	private WebDriverWait wait;
	public StaticPages_Library(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		home = new Home_Page(driver);
		faq = new FQA_Page(driver);
		stores  = new StoreLocator_Page(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void goToHelpPage() throws InterruptedException {
		homePage();
		wait.until(ExpectedConditions.visibilityOf(home.linkHelp)).click();
		//waitForVisibilityOf(faq.txtSearchFQA);
		pageLoad();
		waitForVisibilityOf(faq.linkViewAll);
		waitForVisibilityOf(faq.mainQuestions);
	}
	
	public void goToStoreLocatorPage() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(faq.imgBackHome)).click();
		homePage();
		//init timer
		wait.until(ExpectedConditions.visibilityOf(home.linkStores)).click();
		pageLoad();
		waitForVisibilityOf(stores.btnMapOpt);
		stores.txtSearchStore.sendKeys("Santa fe"+ Keys.ENTER);
		wait.until(ExpectedConditions.textToBePresentInElement(stores.liStore, "Liverpool Santa Fe"));
		stores.liStore.click();
		//end timer
		//init timer
		stores.txtSearchStore.click();
		stores.txtSearchStore.clear();
		Select state = new Select(stores.cmbSelectState);
		//stores.cmbSelectState.click();
		state.selectByVisibleText("NUEVO LEÓN");
		System.out.println("por tienda: " + stores.liStore.getText());
		wait.until(ExpectedConditions.textToBePresentInElement(stores.liStore, "Liverpool Galerías Monterrey"));
		System.out.println("por estado: " + stores.liStore.getText());
		stores.liStore.click();
		//end
		home.imgLogo.click();
	}
	
	public void selectMyStore() {
		//init timer
		wait.until(ExpectedConditions.visibilityOf(home.linkSelectStore)).click();
		waitForVisibilityOf(home.txtCity);
		home.txtCity.sendKeys("Monterrey"+ Keys.ENTER);
		waitForVisibilityOf(home.storesContainer);
		home.rdoStore.click();
		wait.until(ExpectedConditions.visibilityOf(home.spanMyStore));
		System.out.println("estoy en 2: " +home.spanMyStore.getText());
		//end
	}
	
	public void navigateFAQ() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(home.linkHelp)).click();
		//waitForVisibilityOf(faq.txtSearchFQA);
		waitForVisibilityOf(faq.linkViewAll);
		//init Timer credito page
		navigate(faq.linkCreditoPage,"Crédito");
		//end
		//Thread.sleep(2500);
		backToFAQ();
		//init timer mesa de regalos
		navigate(faq.linkMesaRegalosPage,"Mesa de regalos");
		//end
		//Thread.sleep(2500);
		backToFAQ();
		//init timer acerca de nosotros;
		navigate(faq.linkAboutUsPage," Preguntas Frecuentes");
		//end
		//Thread.sleep(2500);
		backToFAQ();
		//init timer proteccion datos personales
		goTo(faq.linkProtectiondata,"Aviso de Privacidad Integral Clientes");
		//end
		//Thread.sleep(2500);
		backToFAQ();
		
	}
	
	public void navigateCredito() throws InterruptedException {
		//init timer guia de consulta de credito
		goTo(faq.linkGuiaCredito," Introducción Guía de consulta de Crédito Liverpool en Internet");
		//end
		//Thread.sleep(2500);
		backToFAQ();
		//init timer mis tarjetas liverpool
		goTo(faq.linkGuiaCredito,"Mis tarjetas Liverpool");
		//end
		//Thread.sleep(2500);
		backToFAQ();
		//init timer cobranza
		goTo(faq.linkGuiaCredito," Cobranza");
		//end
		//Thread.sleep(2500);
	}
	
	public void navigateInsuranceCenter() throws InterruptedException {
		faq.imgBackHome.click();
		homePage();
		//init timer cobranza
		wait.until(ExpectedConditions.visibilityOf(home.insuranceCenter)).click();
		pageLoad();
		waitForVisibilityOf(home.imgInsuranceCategory);
		//init timer cobranza
	}
	
	private void goTo(WebElement linkTo, String pageTitle) {
		scroll(linkTo);
		linkTo.click();
		waitForVisibilityOf(faq.divMenuLeft);
		waitForVisibilityOf(faq.divTitle);
		//wait.until(ExpectedConditions.textToBePresentInElement(faq.divTitle, pageTitle));
		System.out.println("Page: "+ pageTitle);
	}
	private void navigate(WebElement gotoLink,String pageTitle) {
		scroll(gotoLink);
		gotoLink.click();
		waitForVisibilityOf(faq.divMenuLeft);
		if(pageTitle == " Preguntas Frecuentes") {
			System.out.println("true condition");
			//wait.until(ExpectedConditions.textToBePresentInElement(faq.divFAQTag, pageTitle));
			waitForVisibilityOf(faq.divFAQTag);
			System.out.println("Page: "+ faq.divFAQTag.getText());
		}
		else {
			wait.until(ExpectedConditions.textToBePresentInElement(faq.divTitleCategory, pageTitle));
			System.out.println("Page: "+ faq.divTitleCategory.getText());
		}
		//System.out.println("Page form syst: "+ pageTitle);
	}
	private void backToFAQ() throws InterruptedException {
		faq.imgLogoHelp.click();
		pageLoad();
		waitForVisibilityOf(faq.linkViewAll);
	}	
	private void homePage() throws InterruptedException {
		pageLoad();
		wait.until(ExpectedConditions.visibilityOf(home.carouselOnesection));
	}
}
