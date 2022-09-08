package e_commerceLiverpool_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftRegistry_Page extends BasePage{
	
	@FindBy(css = "button[class = 'btnPrimary btnExtraLarge']")
	public WebElement btnGoToGift;
	
	@FindBy(id = "firstName")
	public WebElement txtFirstName;
	
	@FindBy(id = "parentName")
	public WebElement txtParentName;
	
	@FindBy(id = "searchBtn1")//diana caballero
	public WebElement btnSearchGift;
	
	@FindBy(css = "button[class='btnSecondarySpecial btnFull btn-see-list']")
	public WebElement btnSeeList;
	
	@FindBy(css = "img.celebratedImage")
	public WebElement imgCelebrated;
	
	@FindBy(id = "loading-image")
	public WebElement imgLoading;
	
	//50841501 Id Evento
	@FindBy (id = "eventnumber")
	public WebElement txtEventNumber;
	
	@FindBy(id = "searchBtn2")
	public WebElement btnSearchID;
	
	public GiftRegistry_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

}
