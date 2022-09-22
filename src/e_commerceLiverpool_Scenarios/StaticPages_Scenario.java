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
				System.out.println("Static pages iteration complete: ");
			}
			catch(Exception ex) {
				PrintWriter pw = new PrintWriter(sw);
				ex.printStackTrace(pw);
				createLogFile("staticPages",sw.toString());
				tearDown();
			}
	}
}
