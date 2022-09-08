package e_commerceLiverpool_Scenarios;

import e_commerceLiverpool_Library.StaticPages_Library;

public class StaticPages_Scenario extends CreateDriver{

	public static void statiPages() throws InterruptedException {
		StaticPages_Library staticP = new StaticPages_Library(setUp());
		staticP.goToHelpPage();
		staticP.goToStoreLocatorPage();
		staticP.selectMyStore();
		staticP.navigateFAQ();
		staticP.navigateCredito();
		staticP.navigateInsuranceCenter();
		tearDown();
	}
}
