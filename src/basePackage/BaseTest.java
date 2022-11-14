package basePackage;

import java.io.IOException;

public abstract class BaseTest {

	//@BeforeMethod(alwaysRun = true)
	//@Parameters({"browser","seleniumGridUrl"})
	public void settingUp() throws IOException {
		System.out.println("setUp Thread-ID: "+ Thread.currentThread().getId());
		
		CurrentWebDriver.getInstance().setWebDriver(ChromeDriverCreator.createWebDriver());
		CurrentWebDriver.getInstance().getWebDriver().get("https://www.liverpool.com.mx");
		CurrentWebDriver.getInstance().getWebDriver().manage().window().maximize();
	}
	
	//@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if(CurrentWebDriver.getInstance()!=null) {
			CurrentWebDriver.getInstance().getWebDriver().quit();
			CurrentWebDriver.getInstance().removeWebDriver();
		}
	}
}
