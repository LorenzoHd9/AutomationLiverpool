package e_commerceLiverpool_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreLocator_Page extends BasePage{

	@FindBy(css = "div.gm-style-mtc button")
	public WebElement btnMapOpt;
	
	@FindBy(id = "select-state")
	public WebElement cmbSelectState;
	
	@FindBy(css = "ul[class= 'list-group m-list-ul-scrollable']")
	public WebElement listGroupStores;
	
	@FindBy(css = "li[class = 'list-group-item a-list-li-scrollable']")
	public WebElement liStore;
	
	@FindBy(css = "input[id='mainSearchbar'] [placeholder='Buscar por nombre o estado']")
	public WebElement txtSearchStore;
	
	@FindBy(css = "div.mapBtn")
	public WebElement btnUseMyLocation;
	
	public StoreLocator_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	
}
