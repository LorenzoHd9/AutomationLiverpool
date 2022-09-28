package e_commerceLiverpool_Scenarios;

import java.io.PrintWriter;

import org.apache.commons.text.StringEscapeUtils;

import e_commerceLiverpool_Library.BaseLibrary;
import e_commerceLiverpool_Library.StaticPages_Library;

public class StaticPages_Scenario extends CreateDriver{

	public static void statiPages() throws InterruptedException {
			try {
				StaticPages_Library staticP = new StaticPages_Library(setUp());
				BaseLibrary.initScenario("static_pages");
				staticP.goToHelpPage();
				staticP.goToStoreLocatorPage();
				staticP.selectMyStore();
				staticP.navigateFAQ();
				staticP.navigateCredito();
				staticP.navigateInsuranceCenter();
				tearDown();
				System.out.println("------Static pages scenario completed:--------");
				BaseLibrary.endScenario("0", "");
			}
			catch(Exception ex) {
				System.out.println("something went wrong, look at the log file for more details!!");
				tearDown();
				BaseLibrary.endScenario("1", StringEscapeUtils.escapeJava(ex.getMessage()));
				PrintWriter pw = new PrintWriter(sw);
				ex.printStackTrace(pw);
				createLogFile("staticPages",sw.toString());
			}
	}
}
