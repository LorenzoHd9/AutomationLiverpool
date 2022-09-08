package e_commerceLiverpool_Scenarios;

import e_commerceLiverpool_Library.Browse_Library;

public class Browse_Scenario extends CreateDriver{

	public static void browse() throws InterruptedException {
		Browse_Library browse = new Browse_Library(setUp());
		browse.homePage();
		browse.carouselOneSection();
		browse.carouselTwoSection();
		browse.OnCategories();
		browse.onCategoryL3();
		tearDown();
	}
}
