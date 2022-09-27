package e_commerceLiverpool_Scenarios;

import java.io.PrintWriter;

import e_commerceLiverpool_Library.Search_Library;

public class Search_Scenario extends CreateDriver{

	public static void search() throws InterruptedException {
			try {
				Search_Library search = new Search_Library(setUp());
				search.homePage();
				search.searchKeyword();
				search.searchID();
				search.searchThreeCharacters();
				tearDown();
				System.out.println("----------Search scenario completed:----------");
			}
			catch(Exception ex) {
				System.out.println("something went wrong, look at the log file for more details!!");
				PrintWriter pw = new PrintWriter(sw);
				ex.printStackTrace(pw);
				createLogFile("search",sw.toString());
				tearDown();
			}
	}
}
