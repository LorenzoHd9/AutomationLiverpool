package e_commerceLiverpool_Scenarios;

import java.io.PrintWriter;

import e_commerceLiverpool_Library.Browse_Library;

public class Browse_Scenario extends CreateDriver{

	public static void browse() throws InterruptedException {
			try{
				Browse_Library browse = new Browse_Library(setUp());
				browse.homePage();
				browse.carouselOneSection();
				browse.carouselTwoSection();
				browse.OnCategories();
				browse.navigateL3Filters();
				browse.navigateL3SortBy();
				browse.onCategoryL4PDP();
				browse.navigateHomeLinks();
				tearDown();
				System.out.println("Browse iteration complete: ");
			}
			catch(Exception ex) {
				PrintWriter pw = new PrintWriter(sw);
				ex.printStackTrace(pw);
				createLogFile("browse",sw.toString());
				tearDown();
				
			}
	}
}
