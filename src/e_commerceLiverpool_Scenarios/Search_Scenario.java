package e_commerceLiverpool_Scenarios;

import e_commerceLiverpool_Library.Search_Library;

public class Search_Scenario extends CreateDriver{

	public static void search() throws InterruptedException {
		Search_Library search = new Search_Library(setUp());
		search.homePage();
		search.searchKeyword();
		search.searchID();
		search.searchThreeCharacters();
		tearDown();
	}
}
