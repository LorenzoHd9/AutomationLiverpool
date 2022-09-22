package e_commerceLiverpool_Scenarios;

import e_commerceLiverpool_Library.StaticPages_Library;

public class StaticPages_Scenario extends CreateDriver{

	public static void statiPages() throws InterruptedException {
		int i = 0;
		while(i < 2) {
			try {
				StaticPages_Library staticP = new StaticPages_Library(setUp());
				staticP.goToHelpPage();
				staticP.goToStoreLocatorPage();
				staticP.selectMyStore();
				staticP.navigateFAQ();
				staticP.navigateCredito();
				staticP.navigateInsuranceCenter();
				tearDown();
				System.out.println("Static pages iteration complete: "+i);
			}
			catch(Exception ex) {System.out.println("something when wrong, closing chrome...");tearDown();}
			i++;
		}
	}
}
