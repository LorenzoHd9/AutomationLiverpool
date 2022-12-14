package e_commerceLiverpool_Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PDP_Page extends BasePage{

	@FindBy(css = "p.m-product__information--code")
	public WebElement pProductInfoCode;
	
	@FindBy(css = "div.btnGeoStore")
	public WebElement stockStore;
	
	@FindBy(css = "div.modal-content")
	public WebElement modalStoresAvailability;
	
	@FindBy(css = "a.a-product__anchorSelectState")
	public WebElement selectStateStock;
	
	@FindBy(id = "o-product__productSpecsDetails")
	public WebElement divAvailabilityDetails;
	
	@FindBy(css = "button.close i")
	public WebElement closeModal;
	
	@FindBy(id = "a-ProductQty__inputDesktop")
	public WebElement txtProductQty;
	
	@FindBy(css = "a.dropdown-item")
	public List<WebElement> selectQty;
	
	@FindBy(css = "li[class='a-productColor__item mr-lg-2 mr-3 mt-2']")
	public WebElement linkColor;
	
	@FindBy(css = "img[class = 'm-img-pdp added-event']")
	public WebElement viewerImgPDP;
	
	@FindBy(id = "size-list-container")
	public WebElement containerSizeList;
	
	@FindBy(css = "div.GeoLocationCard")
	public WebElement divGeoLocation;
	
	@FindBy(css = "ul#size-list-container button")
	public WebElement btnSize;
	
	@FindBy(css = "button[class='a-btn a-btn--actionpdp']")
	public WebElement btnSizeEnable;
	
	@FindBy(css = "a.m-product__anchorShareSocial")
	public WebElement linkShareTo;
	
	@FindBy(css = "div[id ='social-modal'] [class='close']")
	public WebElement closeCompartir;
	
	@FindBy(xpath = "//span[contains(text(),'Facebook')]")
	public WebElement btnFacebook;
	
	@FindBy(css = "div[class = 'slick-slider slick-initialized']")
	public WebElement divCarousel;
	
	@FindBy(css = "div[class = 'slick-slide slick-active'] [class = 'card-img-top lazyloaded']")
	public WebElement divCarouselImg;
	
	@FindBy(id = "opc_pdp_buyNowButton")
	public WebElement btnBuyNow;
	
	@FindBy(id = "opc_pdp_addCartButton")
	public WebElement btnAddToCart;
	
	@FindBy(css = "div[class='m-mdc__snackbarLabel mdc-snackbar__label']")
	public WebElement modalNotification;
	
	@FindBy(css ="div[class='m-alert__container mdc-snackbar    -success mdc-snackbar--open']")
	public WebElement alertContainer;//m-alert__container mdc-snackbar -toTop   -success mdc-snackbar--open
	//after change quantity
	
	@FindBy(css = "div[class='m-alert__container mdc-snackbar  -alert mdc-snackbar--open'] [class='icon-close mdc-snackbar__dismiss']")
	public WebElement alertCloseError;
	
	@FindBy(css = "img.mainLoader")
	public WebElement imgLoading;
	
	@FindBy(css = "span.GeoLinkText")
	public WebElement linkEnterZipCode;
	
	@FindBy(css = "div.ChangeStoreTextLink")
	public WebElement linkChangeZipcode;
	
	@FindBy(id = "TTwriteReviewBtn")
	public WebElement productSpecsDetails;
	
	@FindBy(css = "span.GeoStoreName")
	public WebElement myZipCode;
	
	@FindBy(css = "div[class ='slick-slide slick-active slick-current']")
	public WebElement carousel;
	
	@FindBy(css = "div[name='columnProduct']")
	public WebElement columnProduct;
	
	public PDP_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
}
