package e_commerceLiverpool_Scenarios;

import java.io.IOException;

import e_commerceLiverpool_Library.BaseLibrary;
import e_commerceLiverpool_Library.Browse_Library;

public class Browse_Scenario extends CreateDriver{

	public static void browse() throws InterruptedException, IOException {
			try{
				Browse_Library browse = new Browse_Library(setUp());
				BaseLibrary.initScenario("browse_web");
				//browse.homePage(); this method is inside of carousel one section method so this is no longer required
				browse.carouselOneSection();
				browse.carouselTwoSection();
				browse.OnCategories();
				browse.navigateL3Filters();
				browse.navigateL3SortBy();
				browse.onCategoryL4PDP();
				browse.navigateHomeLinks();
				tearDown();
				System.out.println("-----------Browse scenario completed:---------");
				BaseLibrary.endScenario("0", "","");
			}
			catch(Exception ex) {
				//BaseLibrary.captureScreenShot(setUp(),"browse");
				tearDown();
				BaseLibrary.errorScenario("browse_web", ex);
			}
	}
}
