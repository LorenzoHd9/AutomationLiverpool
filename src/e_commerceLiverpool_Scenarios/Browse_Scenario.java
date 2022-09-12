package e_commerceLiverpool_Scenarios;

import e_commerceLiverpool_Library.Browse_Library;

public class Browse_Scenario extends CreateDriver{

	public static void browse() throws InterruptedException {
		int i = 0;
		while(i< 8) {
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
			System.out.println("iteration number: "+ i);
		    i++;
		}
	}
}
