package e_commerceLiverpool_Scenarios;


import java.io.IOException;

import e_commerceLiverpool_Library.BaseLibrary;
import e_commerceLiverpool_Library.Search_Library;

public class Search_Scenario extends CreateDriver{

	public static void search() throws InterruptedException, IOException {
			try {
				Search_Library search = new Search_Library(setUp());
				BaseLibrary.initScenario("search_web");
				search.homePage();
				search.searchKeyword();
				search.searchID();
				search.searchThreeCharacters();
				tearDown();
				System.out.println("----------Search scenario completed:----------");
				BaseLibrary.endScenario("0", "","");
			}
			catch(Exception ex) {
				//BaseLibrary.captureScreenShot(setUp(),"search");
				tearDown();
				BaseLibrary.errorScenario("search_web", ex);
			}
	}
}
