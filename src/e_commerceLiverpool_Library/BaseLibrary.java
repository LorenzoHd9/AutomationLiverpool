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

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("deprecation")
public class BaseLibrary {

	private WebDriver driver;
	static String stepName = "";
	String scenarioName = "";
	static Date start;
	double systemCPU;
	double freeMemory;
	double diff;
	double durationOfSeconds;
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	public BaseLibrary(WebDriver driver) {
		this.driver = driver;
	}
	/**  Scroll until the given element **/
	protected void scroll(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	// scroll 350 px down
	protected void scrollDown() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,350)","");
	}
	// scroll -450 px up
	protected void scrollUp() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-450)","");
	}
	// scroll to the bottom of the page
	protected void scrollToBottom() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	protected void scrollToTop() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
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
	/** wait for visibility of the given element, two attemps of 30 secodns = 60 seconds total**/
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
	// wait for an expetected conditions for 30 seconds
	private void waitFor(ExpectedCondition<WebElement> condition, Duration timeout){
		timeout = timeout!= null ? timeout : Duration.ofSeconds(30);
		WebDriverWait wait  = new WebDriverWait(driver, timeout);
		wait.until(condition);
	}
	// hover on the given element
	protected void hoverOn(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
	}
	// wait for the element until it is refresehd and clickable, it avoid stale elememt status
	protected WebElement refreshedAndClickable(WebElement element) {
		return new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.refreshed(
						ExpectedConditions.elementToBeClickable(element)));
	}
	// wait for the elements until it is refresehd and clickable, it avoid stale elememt status
	protected List<WebElement> refreshedAllAndClickable(List<WebElement> element) {
		return new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.refreshed(
						ExpectedConditions.visibilityOfAllElements(element)));
	}
	// get the init time (step)
	protected void startTimer(String scenario, String stepname) {
		start = new Date();
		scenarioName = scenario;
		stepName = stepname;
	}
	// stop and send the time to the data base
	protected void stopTimer() throws InterruptedException, IOException {
		Date end = new Date();
		SimpleDateFormat keyformat = new SimpleDateFormat("yyyyMMddHH");
		String initime = sdf.format(start);
		String endtime = sdf.format(end);
		SystemInfo info = SystemInfo.getInstance();
		systemCPU = 100 * info.getSystemCpuLoad();
		//memoryLoad = 100 * info.getProcessMemoryLoad();
		freeMemory = (100 * info.getRemainigMemorySize()) / info.getTotalPhysicalMemorySize();
		diff = end.getTime() - start.getTime();
		durationOfSeconds =diff / 1000.00;
		String key = "";
		int minute = (end.getMinutes()/5)+1;
		if(minute< 10) {
			key = keyformat.format(end)+"0"+minute;
		}
		else {
			key = keyformat.format(end)+""+minute;
		}
		ConnectDB.setStepTime(ConnectDB.getExecuteID(),scenarioName,"Web",stepName,initime, endtime, durationOfSeconds, key,systemCPU, freeMemory);
		int thinkTime = Integer.parseInt(configProperties("thinkTime")); 
		Thread.sleep(thinkTime);
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
	
	public static void endScenario(String error, String errorMsg, String errorStep) {
		Date endScenario = new Date();
		if(error == "0") {
			ConnectDB.updateScenarioTime(sdf.format(endScenario),error,"","");
		}
		else if (error =="1"){
			ConnectDB.updateScenarioTime(sdf.format(endScenario),error, escapeStr(errorMsg),errorStep);
		}
	}
	
	public static void errorScenario(String errorScenario, Throwable except) {
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("something went wrong, look at the "+errorScenario+" log file for more details!!");
		endScenario("1",except.getMessage(),stepName);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		except.printStackTrace(pw);
		createLogFile(errorScenario,sw.toString());
	}
	
	public static void captureScreenShot(WebDriver driver, String name){
		// Take screenshot and store as a file format             
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);           
		try {
			// now copy the  screenshot to desired location using copyFile method
			Date now = new Date();
			SimpleDateFormat formater = new SimpleDateFormat("MMdd_HHmmssSSS_");
		 	FileUtils.copyFile(src, new File("logsMonitoreo\\evidence\\"+formater.format(now)+name+".png"));
		 	driver.quit();
		}
		catch(IOException e){
			driver.quit();
			System.out.println(e.getMessage()); 
		 }
	}
	
	protected void secureClick(WebElement element) throws Exception {
		Boolean btnClicked = false;
		int attempts = 0;
		int maxAttempts = 30;
		Throwable lastError = null;
		while(btnClicked == false || attempts == maxAttempts) {
			try {
				element.click();
				btnClicked = true;
				//throw new Exception(lastError);
			}
			catch(Exception ex) {
				if(ex.getMessage().contains("Other element would receive the click:")) {
					attempts +=1;
					lastError = ex;
					Thread.sleep(1000);
					//System.out.println("attempt: "+ attempts);
				}
				else {
					throw new Exception(lastError);
				}
			}
		}
		if(btnClicked == false) {
			throw new Exception(lastError);
		}
	}

	public double bytesReadableValue(long valueInBytes) {
		String[] BYTE_UNITS = {"B","kB","MB","GB","TB"};
		int unitsIndex = 0 ;
		double value = valueInBytes;
		while(value > 1024d && unitsIndex < BYTE_UNITS.length - 1) {
			value /= 1024d;
			unitsIndex++;
		}
		return value;
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
			myFile = new File(scenario + ".txt");
			myFile.createNewFile();
			FileWriter myLog = new FileWriter(myFile, true);
			Date now = new Date();
			myLog.write(System.lineSeparator());
			myLog.write(sdf.format(now));
			myLog.write(System.lineSeparator());
			myLog.write(log);
			myLog.write("--------------------------------------------------------------------------------------------");
			myLog.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
