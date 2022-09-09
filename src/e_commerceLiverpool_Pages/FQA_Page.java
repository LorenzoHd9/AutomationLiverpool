package e_commerceLiverpool_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FQA_Page extends BasePage{

	@FindBy(xpath = "//a[contains(text(),'Preguntas frecuentes')]")
	public WebElement linkFQAPage;
	
	@FindBy(xpath = "//a[contains(text(),'Crédito')]")
	public WebElement  linkCreditoPage;
	
	@FindBy(css = "div[class='title ng-binding']")
	public WebElement divTitleCategory;
	
	@FindBy(css = "img.logoAyuda")
	public WebElement imgLogoHelp;
	
	@FindBy(xpath = "//a[contains(text(),'Mesa de regalos')]")
	public WebElement linkMesaRegalosPage;
	
	@FindBy(xpath = "//a[contains(text(),'Acerca de nosotros')]")
	public WebElement linkAboutUsPage;
	
	@FindBy(css = "div.menu-ayuda")
	public WebElement divMenuLeft;
	
	@FindBy(css = "div.title")
	public WebElement divTitle;
	
	@FindBy(xpath = "//a[contains(text(),'Términos y condiciones')]")
	public WebElement linkTerminosPage;
	
	@FindBy(xpath = "//a[contains(text(),'Protección de datos personales')]")
	public WebElement linkProtectiondata;
	
	@FindBy(css = "input[type='text'] [ng-model='inputBuscar']")
	public WebElement txtSearchFQA;
	
	@FindBy(xpath = "//a[contains(text(),'Guía de consulta de crédito')]")
	public WebElement linkGuiaCredito;
	
	@FindBy(xpath = "//a[contains(text(),'Mis tarjetas Liverpool*')]")
	public WebElement linkMyCards;
	
	@FindBy(xpath = "//a[contains(text(),'Mis tarjetas Liverpool*')]")
	public WebElement linkCobranza;
	
	@FindBy(xpath = "//a[contains(text(),'Ver todo ')]")
	public WebElement linkViewAll;
	
	@FindBy(css = "div.logaB a")
	public WebElement imgBackHome;
	
	@FindBy(css = "div.frecuente-tag")
	public WebElement divFAQTag;
	
	@FindBy(css = "ul.main-questions")
	public WebElement mainQuestions;
	
	public FQA_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	
}
