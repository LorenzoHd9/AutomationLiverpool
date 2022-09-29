package e_commerceLiverpool_Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseLibrary {

	private WebDriver driver;
	String stepName = "";
	String scenarioName = "";
	static Date start;
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	public BaseLibrary(WebDriver driver) {
		this.driver = driver;
	}
	/**  Scroll until the given element **/
	protected void scroll(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	protected void scrollDown() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,350)","");
	}
	
	protected void scrollUp() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-450)","");
	}
	/** wait until the document has the "ready" state **/
	protected void pageLoad() throws InterruptedException {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	boolean state=false;
    	while (state != true){
    		Thread.sleep(250);
    		state= js.executeScript("return document.readyState").toString().equals("complete");	
    	}
    }
	/** wait for visibility of the given element**/
	protected void waitForVisibilityOf(WebElement element, Duration... timeOut) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOf(element),
						(timeOut.length > 0 ? timeOut[0] : null));
				break;
			} catch (StaleElementReferenceException e) {}
			attempts++;
		}
	}
	
	private void waitFor(ExpectedCondition<WebElement> condition, Duration timeout){
		timeout = timeout!= null ? timeout : Duration.ofSeconds(30);
		WebDriverWait wait  = new WebDriverWait(driver, timeout);
		wait.until(condition);
	}
	
	protected void hoverOn(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
	}
	
	protected WebElement refreshedAndClickable(WebElement element) {
		return new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.refreshed(
						ExpectedConditions.elementToBeClickable(element)));
	}
	
	protected List<WebElement> refreshedAllAndClickable(List<WebElement> element) {
		return new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.refreshed(
						ExpectedConditions.visibilityOfAllElements(element)));
	}
	
	protected void scrollToBottom() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	protected void startTimer(String scenario, String stepname) {
		start = new Date();
		scenarioName = scenario;
		stepName = stepname;
	}
	
	protected void stopTimer() throws InterruptedException {
		Date end = new Date();
		SimpleDateFormat keyformat = new SimpleDateFormat("yyyyMMddHH");
		String initime = sdf.format(start);
		String endtime = sdf.format(end);
		double diff = end.getTime() - start.getTime();
		double durationOfSeconds =diff / 1000.00;
		String key = "";
		int minute = (end.getMinutes()/5)+1;
		if(minute< 10) {
			key = keyformat.format(end)+"0"+minute;
		}
		else {
			key = keyformat.format(end)+""+minute;
		}
		ConnectDB.setStepTime(ConnectDB.getExecuteID(),scenarioName,"Web",stepName,initime, endtime, durationOfSeconds, key);
		Thread.sleep(3000);
	}
	
	public static String configProperties(String Property) throws IOException {
		String propertiesFile = "config.properties";
		FileInputStream propInput = new FileInputStream(propertiesFile);
		
		Properties prop = new Properties();
		prop.load(propInput);
		return prop.getProperty(Property);
	}
	
	public static void initScenario(String scenarioName) {
		start = new Date();
		String initime = sdf.format(start);
		ConnectDB.setScenarioTime(scenarioName, "Web", initime);
	}
	
	public static void endScenario(String error, String errorMsg) {
		Date endScenario = new Date();
		if(error == "0") {
			ConnectDB.updateScenarioTime(sdf.format(endScenario),error,"");
		}
		else if (error =="1"){
			ConnectDB.updateScenarioTime(sdf.format(endScenario),error, escapeStr(errorMsg));
		}
	}
	private static String escapeStr(String string) {
		return string.replace("\\", "\\\\")
		          .replace("\t", "\\t")
		          .replace("\b", "\\b")
		          .replace("\n", "\\n")
		          .replace("\r", "\\r")
		          .replace("\f", "\\f")
		          .replace("\'", "\\'")
		          .replace("\"", "\\\"");    
	}
	
	private static void createLogFile(String scenario, String log) {
		File myFile = null;
		try {
			myFile = new File("logsMonitoreo\\" + scenario + ".txt");
			myFile.createNewFile();
			FileWriter myLog = new FileWriter(myFile, true);
			Date now = new Date();
			myLog.write(sdf.format(now));
			myLog.write("----");
			myLog.write(log);
			myLog.write("-----------------------------------------------");
			myLog.write("-----------------------------------------------");
			myLog.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void errorScenario(String errorScenario, Throwable except) {
		System.out.println("-----------------------------------------------");
		System.out.println("-----------------------------------------------");
		System.out.println("something went wrong, look at the log file for more details!!");
		endScenario("1",except.getMessage());
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		except.printStackTrace(pw);
		createLogFile(errorScenario,sw.toString());
	}
}
