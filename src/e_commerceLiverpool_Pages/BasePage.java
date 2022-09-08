package e_commerceLiverpool_Pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
	
	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	protected String getTilte() {
		return driver.getTitle();
	}
}
