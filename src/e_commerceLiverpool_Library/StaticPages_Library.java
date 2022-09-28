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
	String scenario = "static_pages";
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
		startTimer(scenario,"navigate_to_help_page");
		pageLoad();
		waitForVisibilityOf(faq.linkViewAll);
		waitForVisibilityOf(faq.mainQuestions);
		stopTimer();
	}
	
	public void goToStoreLocatorPage() throws InterruptedException {
		startTimer(scenario,"back_to_homepage");
		wait.until(ExpectedConditions.visibilityOf(faq.imgBackHome)).click();
		homePage();
		stopTimer();
		startTimer(scenario,"navigate_to_stores_page");
		wait.until(ExpectedConditions.visibilityOf(home.linkStores)).click();
		pageLoad();
		waitForVisibilityOf(stores.btnMapOpt);
		stopTimer();
		startTimer(scenario,"find_store_by_name");
		stores.txtSearchStore.sendKeys("Santa fe"+ Keys.ENTER);
		wait.until(ExpectedConditions.textToBePresentInElement(stores.liStore, "Liverpool Santa Fe"));
		stores.liStore.click();
		stopTimer();
		//end
		startTimer(scenario,"find_store_by_state");
		stores.txtSearchStore.click();
		stores.txtSearchStore.clear();
		Select state = new Select(stores.cmbSelectState);
		state.selectByVisibleText("NUEVO LEÓN");
		wait.until(ExpectedConditions.textToBePresentInElement(stores.liStore, "Liverpool Galerías Monterrey"));
		stores.liStore.click();
		stopTimer();
		//end
		startTimer(scenario,"back_to_homepage");
		home.imgLogo.click();
		homePage();
		stopTimer();
	}
	
	public void selectMyStore() throws InterruptedException {
		startTimer(scenario,"store_locator_select_mystore");
		wait.until(ExpectedConditions.visibilityOf(home.linkSelectStore)).click();
		waitForVisibilityOf(home.txtCity);
		home.txtCity.sendKeys("Monterrey"+ Keys.ENTER);
		waitForVisibilityOf(home.storesContainer);
		home.rdoStore.click();
		wait.until(ExpectedConditions.visibilityOf(home.spanMyStore));
		stopTimer();
		//end
	}
	
	public void navigateFAQ() throws InterruptedException {
		startTimer(scenario,"navigate_to_faq");
		wait.until(ExpectedConditions.visibilityOf(home.linkHelp)).click();
		//waitForVisibilityOf(faq.txtSearchFQA);
		waitForVisibilityOf(faq.linkViewAll);
		stopTimer();
		// end
		startTimer(scenario,"navigate_to_credito");
		navigate(faq.linkCreditoPage,"Crédito");
		stopTimer();
		//end
		startTimer(scenario,"navigate_to_gift_table");
		backToFAQ();
		navigate(faq.linkMesaRegalosPage,"Mesa de regalos");
		stopTimer();
		//end
		startTimer(scenario,"navigate_to_about_us");
		backToFAQ();
		navigate(faq.linkAboutUsPage," Preguntas Frecuentes");
		stopTimer();
		//end
		startTimer(scenario,"navigate_to_terms_conditions");
		backToFAQ();
		goTo(faq.linkProtectiondata,"Aviso de Privacidad Integral Clientes");
		stopTimer();
		//end
	}
	
	public void navigateCredito() throws InterruptedException {
		startTimer(scenario,"navigate_to_credit_guide");
		backToFAQ();
		goTo(faq.linkGuiaCredito," Introducción Guía de consulta de Crédito Liverpool en Internet");
		stopTimer();
		//end
		startTimer(scenario,"navigate_to_my_cards");
		backToFAQ();
		goTo(faq.linkGuiaCredito,"Mis tarjetas Liverpool");
		stopTimer();
		//end
		startTimer(scenario,"navigate_to_credit_charge");
		backToFAQ();
		goTo(faq.linkGuiaCredito," Cobranza");
		stopTimer();
		//end
	}
	
	public void navigateInsuranceCenter() throws InterruptedException {
		startTimer(scenario,"back_to_homepage");
		faq.imgBackHome.click();
		homePage();
		stopTimer();
		startTimer(scenario,"navigate_to_insurance_center");
		wait.until(ExpectedConditions.visibilityOf(home.insuranceCenter)).click();
		pageLoad();
		waitForVisibilityOf(home.imgInsuranceCategory);
		stopTimer();
	}
	
	private void goTo(WebElement linkTo, String pageTitle) {
		scroll(linkTo);
		linkTo.click();
		waitForVisibilityOf(faq.divMenuLeft);
		waitForVisibilityOf(faq.divTitle);
		//wait.until(ExpectedConditions.textToBePresentInElement(faq.divTitle, pageTitle));
		//System.out.println("Page: "+ pageTitle);
	}
	private void navigate(WebElement gotoLink,String pageTitle) {
		scroll(gotoLink);
		gotoLink.click();
		waitForVisibilityOf(faq.divMenuLeft);
		if(pageTitle == " Preguntas Frecuentes") {
			//wait.until(ExpectedConditions.textToBePresentInElement(faq.divFAQTag, pageTitle));
			waitForVisibilityOf(faq.divFAQTag);
		}
		else {
			wait.until(ExpectedConditions.textToBePresentInElement(faq.divTitleCategory, pageTitle));
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
