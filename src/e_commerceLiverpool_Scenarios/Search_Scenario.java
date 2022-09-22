package e_commerceLiverpool_Scenarios;

import e_commerceLiverpool_Library.Search_Library;

public class Search_Scenario extends CreateDriver{

	public static void search() throws InterruptedException {
		int i = 0;
		while(i < 2) {
			try {
				Search_Library search = new Search_Library(setUp());
				search.homePage();
				search.searchKeyword();
				search.searchID();
				search.searchThreeCharacters();
				tearDown();
				System.out.println("Search iteration complete: "+i);
			}
			catch(Exception ex) {System.out.println("something when wrong, closing chrome...");tearDown();}
			i++;
		}
	}
}
