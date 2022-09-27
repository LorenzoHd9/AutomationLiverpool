package basePackage;

import org.openqa.selenium.WebDriver;

public class CurrentWebDriver {
	
	private static CurrentWebDriver instance;
	private static ThreadLocal<WebDriver> webDriverThreadLocal;
	
	private CurrentWebDriver() {
		webDriverThreadLocal = new ThreadLocal<>();
	}
	
	public static CurrentWebDriver getInstance() {
		if(instance == null) {
			// synchronized block to remove overhead
			synchronized(CurrentWebDriver.class) {
				if(instance == null) {
					// instance is null, initialize
					instance = new CurrentWebDriver();
				}
			}
		}
		return instance;
	}
	
	public WebDriver getWebDriver() {
		return webDriverThreadLocal.get();
	}
	
	public void setWebDriver(WebDriver webdriver) {
		webDriverThreadLocal.set(webdriver);
	}
	
	public void removeWebDriver() {
		webDriverThreadLocal.remove();
	}
}
