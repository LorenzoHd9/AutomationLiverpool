package e_commerceLiverpool_Scenarios;

import java.io.IOException;

import e_commerceLiverpool_Library.BaseLibrary;
import e_commerceLiverpool_Library.StaticPages_Library;

public class StaticPages_Scenario extends CreateDriver{

	public static void statiPages() throws InterruptedException, IOException {
			try {
				StaticPages_Library staticP = new StaticPages_Library(setUp());
				BaseLibrary.initScenario("static_pages_web");
				staticP.goToHelpPage();
				staticP.goToStoreLocatorPage();
				staticP.selectMyStore();
				staticP.navigateFAQ();
				staticP.navigateCredito();
				staticP.navigateInsuranceCenter();
				tearDown();
				System.out.println("------Static pages scenario completed:--------");
				BaseLibrary.endScenario("0", "","");
			}
			catch(Exception ex) {
				//BaseLibrary.captureScreenShot(setUp(),"staticP");
				tearDown();
				BaseLibrary.errorScenario("static_pages_web", ex);
			}
	}
}
