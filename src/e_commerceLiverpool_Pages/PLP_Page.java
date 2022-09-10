package e_commerceLiverpool_Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PLP_Page extends BasePage{
	
	@FindBy(css = "img.iconArrow")
	public WebElement iconL2;
	
	@FindBy(css= "img[class='a-mainBanner__image lazyloaded']")
	public WebElement imgL2;
	
	@FindBy(css ="li.nav-sub-link-leftMenu a")
	public WebElement linkL2_L4;
	
	@FindBy(xpath = "//a[contains(text(),'Ver todo')]")
	public WebElement linkVerTodo;
	
	/*@FindBy(css = "img.card-img-top")
	public WebElement imgLinkL3;
	*/
	//m-figureCard__figure card  m-card
	@FindBy(css = "figure[class ='m-figureCard__figure card  m-card']")
	public List<WebElement> imgsLinkL3;
	
	@FindBy(css = "div[class='d-flex align-items-center'] [id='sortby']")
	public WebElement cmbSortBy;
	
	@FindBy(css = "div[class='d-flex align-items-center'] [class='dropdown-item']")
	public List<WebElement> dropDownItems;
	
	@FindBy(css = "i.icon-vistalista")
	public WebElement iconListView;
	
	@FindBy(css = "div[class='o-listing__products card-columns-plp']")
	public WebElement divListingView;
	
	@FindBy(css = "i.icon-vistagrid")
	public WebElement iconGridView;
	
	@FindBy(css = "div.o-listing__products")
	public WebElement divGridView;
	
	/*@FindBy(css = "div.o-card__image__container")
	public WebElement imgProduct_pdp;
	*/
	@FindBy(css = "div.o-card__image__container")
	public List<WebElement> imgProduct_pdp;
	
	@FindBy(css = "div.fiterl-prices input")
	public WebElement chbxPrice;
	
	@FindBy(id = "variants.prices.discountPercentage-undefined")
	public List<WebElement> chbxPromotion;
	
	@FindBy(css = "div.filter-brands input")
	//@FindBy(id = "brand-&ME")
	public WebElement chbxBrand;
	
	@FindBy(css = "ul.a-plp-color a")
	public WebElement chbxColor;
	
	@FindBy(id = "ratingInfo.productAvgRating-3.7")
	public WebElement chbxRating;
	
	//@FindBy(css = "input[id*=variants.sellernames-]:not[id*='Liverpool']")
	@FindBy(id= "variants.sellernames-Liverpool")
	public WebElement chbxSoldBy;
	
	@FindBy(css = "div.plp-head-filter a")
	public WebElement linkCleanfilters;
	
	@FindBy(id = "dept0")
	public WebElement onCategoryL1;
	
	@FindBy(xpath = "//a[contains(text(),'Puede interesarte')]")
	public WebElement nullResult;
	
	public PLP_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
}
