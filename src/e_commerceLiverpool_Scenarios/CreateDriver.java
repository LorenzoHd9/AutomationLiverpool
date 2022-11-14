package e_commerceLiverpool_Scenarios;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import e_commerceLiverpool_Library.BaseLibrary;

public class CreateDriver {
	
	private static WebDriver driver = null;
	protected static WebDriver setUp() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe").destroy();
		System.setProperty("webDriver.chrome.driver","chromedriver.exe");
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		String IsHeadless = BaseLibrary.configProperties("headless");
		if(IsHeadless.equals("true")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--headless");
			driver = new ChromeDriver(opt);
		}
		else if (IsHeadless.equals("false")){
			driver = new ChromeDriver();
		}
		else {
			System.out.println("configure headless value to 'true' or 'false'");
		}
		driver.manage().window().maximize();
		driver.get("https://www.liverpool.com.mx");
		return driver;
	}
	protected static void tearDown() {
		///log.info("quit browser");
		driver.quit();
	}
}
