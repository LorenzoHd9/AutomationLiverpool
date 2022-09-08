package e_commerceLiverpool_Scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateDriver {
	
	private static WebDriver driver = null;
	protected static WebDriver setUp() {
		System.setProperty("webDriver.chrome.driver","\\chromedriver.exe");
		//src/main/resources/driver/chromedriver2.exe
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.liverpool.com.mx");
		return driver;
	}
	protected static void tearDown() {
		///log.info("quit browser");
		driver.quit();
	}
}
