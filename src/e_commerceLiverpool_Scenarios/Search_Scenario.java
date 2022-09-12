package e_commerceLiverpool_Scenarios;

import e_commerceLiverpool_Library.Search_Library;

public class Search_Scenario extends CreateDriver{

	public static void search() throws InterruptedException {
		/*int i =0;
		while(i < 5) {
			System.out.println("interation number: "+i);
			i++;
		}*/
		Search_Library search = new Search_Library(setUp());
		search.searchKeyword();
		search.searchID();
		search.searchTreeCharacters();
		tearDown();
	}
}
