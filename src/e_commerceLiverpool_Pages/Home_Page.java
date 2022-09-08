package e_commerceLiverpool_Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page extends BasePage{
	
	 @FindBy(css ="div[class='slick-slide slick-active']")
	 public WebElement carouselOnesection;
	 
	 @FindBy(css = "div[id='carouselNo-2'] [class='slick-slide slick-active']")
	 public WebElement carouselTwosection;
	 
	 @FindBy(css = "img[class='a-header__logo'][title='Liverpool Logo']")
	 public WebElement imgLogo;
	 
	 @FindBy(xpath = "//span[contains(text(),'Categorías')]")
	 public WebElement linkCategories;
	 
	 @FindBy(xpath = "//span[contains(text(),'Mujer')]")
	 public WebElement categoryL1;
	 
	 @FindBy(css = "span.a-header__topLink")
	 public WebElement linkLogIn;
	 
	 @FindBy(css = "button.a-header__bag")
	 public WebElement linkMyBag;
	 
	 @FindBy(css = "a.a-header__topLink")
	 public WebElement linkMyShoppings;
	 
	 @FindBy(id = "mainSearchbar")
	 public WebElement txtSearchBar;
	 
	 @FindBy(linkText = "Mesa de regalos")
	 public WebElement linkGiftTable;
	 
	 @FindBy(linkText = "Mi crédito")
	 public WebElement linkMyCredit;
	 
	 @FindBy(linkText = "Centro de seguros")
	 public WebElement insuranceCenter;
	 
	 @FindBy(linkText = "Ayuda")
	 public WebElement linkHelp;
	 
	 @FindBy(linkText = "Tiendas")
	 public WebElement linkStores;
	 
	 @FindBy(linkText = "Citas en tienda")
	 public WebElement inStoreAppointments;
	 
	 @FindBy(css = "a.a-header__typeaheadLink typeahead-link")
	 public List<WebElement> searchKeyword;
	 
	 @FindBy(css ="span[class = 'a-header__topLink popover-session']")
	 public WebElement userNameSession;
	 
	 @FindBy(css = "a.a-header__sessionLink")
	 public List<WebElement> mySessionLinks;
	 
	 @FindBy(css = "a[class ='a-header__typeaheadLink typeahead-link']")
	 public List<WebElement> typeAheadResults;
	 
	 @FindBy(css = "figure.m-figureCard__figure img")
	 public WebElement imgTypeAhead;
	 
	 @FindBy(css = "div.img-wrapper-rectangle")
	 public WebElement imgInsuranceCategory;
	 
	 @FindBy(css = "span.m-navDesktop__selectstore")
	 public WebElement linkSelectStore;
	 
	 @FindBy(css = "input#CP")
	 public WebElement txtCity;
	 
	 @FindBy(css = "div.stores-container")
	 public WebElement storesContainer;
	 
	 @FindBy(css = "input[name= 'Stores-list']")
	 public WebElement rdoStore;
	 
	 @FindBy(css = "span.headerMyStoredesk")
	 public WebElement spanMyStore;
	 
	 public Home_Page(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}
}
