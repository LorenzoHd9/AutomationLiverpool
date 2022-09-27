package e_commerceLiverpool_Scenarios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import e_commerceLiverpool_Library.BaseLibrary;

public class CreateDriver {
	
	protected static StringWriter sw = new StringWriter();
	private static WebDriver driver = null;
	protected static WebDriver setUp() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe").destroy();
		System.setProperty("webDriver.chrome.driver","chromedriver.exe");
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		if(BaseLibrary.configProperties("headless") == "true") {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--headless");
			driver = new ChromeDriver(opt);
		}
		else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.liverpool.com.mx");
		return driver;
	}
	protected static void tearDown() {
		///log.info("quit browser");
		driver.quit();
	}
	
	protected static void createLogFile(String scenario, String log) {
		File myFile = null;
		try {
			myFile = new File("\\logsMonitoreo\\"+scenario+".txt");
			if (myFile.createNewFile() == false) {
				System.out.println("log file already exist, saving logs...");
			}
			else {System.out.println("file successfully created"+ myFile.getName());}
		}
		catch(Exception e) {e.printStackTrace();}
		try {
			FileWriter myLog = new FileWriter(myFile);
			myLog.write(log);
			myLog.write("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			myLog.close();
		}catch(Exception ex) {ex.printStackTrace();}
	}
}
