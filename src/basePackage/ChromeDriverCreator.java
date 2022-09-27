package basePackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import e_commerceLiverpool_Library.BaseLibrary;

public class ChromeDriverCreator {
	
	public static WebDriver createWebDriver() throws IOException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.setHeadless(false);
		if(BaseLibrary.configProperties("headless") == "true") {
			opt.setHeadless(true);
		}
		return new ChromeDriver(opt);
	}
}
