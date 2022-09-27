package e_commerceLiverpool_Scenarios;

import java.io.PrintWriter;

import e_commerceLiverpool_Library.StaticPages_Library;

public class StaticPages_Scenario extends CreateDriver{

	public static void statiPages() throws InterruptedException {
			try {
				StaticPages_Library staticP = new StaticPages_Library(setUp());
				staticP.goToHelpPage();
				staticP.goToStoreLocatorPage();
				staticP.selectMyStore();
				staticP.navigateFAQ();
				staticP.navigateCredito();
				staticP.navigateInsuranceCenter();
				tearDown();
				System.out.println("------Static pages scenario completed:--------");
			}
			catch(Exception ex) {
				System.out.println("something went wrong, look at the log file for more details!!");
				PrintWriter pw = new PrintWriter(sw);
				ex.printStackTrace(pw);
				createLogFile("staticPages",sw.toString());
				tearDown();
			}
	}
}
