package e_commerceLiverpool_Scenarios;

import java.io.PrintWriter;

import org.apache.commons.text.StringEscapeUtils;

import e_commerceLiverpool_Library.BaseLibrary;
import e_commerceLiverpool_Library.Browse_Library;

public class Browse_Scenario extends CreateDriver{

	public static void browse() throws InterruptedException {
			try{
				Browse_Library browse = new Browse_Library(setUp());
				BaseLibrary.initScenario("browse");
				browse.homePage();
				browse.carouselOneSection();
				browse.carouselTwoSection();
				browse.OnCategories();
				browse.navigateL3Filters();
				browse.navigateL3SortBy();
				browse.onCategoryL4PDP();
				browse.navigateHomeLinks();
				tearDown();
				System.out.println("-----------Browse scenario completed:---------");
				BaseLibrary.endScenario("0", "");
			}
			catch(Exception ex) {
				System.out.println("something went wrong, look at the log file for more details!!");
				tearDown();
				BaseLibrary.endScenario("1", StringEscapeUtils.escapeJava(ex.getMessage()));
				PrintWriter pw = new PrintWriter(sw);
				ex.printStackTrace(pw);
				createLogFile("browse",sw.toString());
				
			}
	}
}
