package e_commerceLiverpool_Library;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

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
	Date start;
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
	//ConnectDB.setScenarioTime("Browse","Web","Navigate carousel","2022-9-14 01:17:23","2022-9-14 01:17:36",10 );
	
	protected void stopTimer() {
		Date end = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
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
		ConnectDB.setScenarioTime(scenarioName,"Web",stepName,initime, endtime, durationOfSeconds, key);
	}
}
