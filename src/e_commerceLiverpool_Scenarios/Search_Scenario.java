package e_commerceLiverpool_Scenarios;

import java.io.PrintWriter;

import org.apache.commons.text.StringEscapeUtils;

import e_commerceLiverpool_Library.BaseLibrary;
import e_commerceLiverpool_Library.Search_Library;

public class Search_Scenario extends CreateDriver{

	public static void search() throws InterruptedException {
			try {
				Search_Library search = new Search_Library(setUp());
				BaseLibrary.initScenario("search");
				search.homePage();
				search.searchKeyword();
				search.searchID();
				search.searchThreeCharacters();
				tearDown();
				System.out.println("----------Search scenario completed:----------");
				BaseLibrary.endScenario("0", "");
			}
			catch(Exception ex) {
				System.out.println("something went wrong, look at the log file for more details!!");
				tearDown();
				BaseLibrary.endScenario("1", StringEscapeUtils.escapeJava(ex.getMessage()));
				PrintWriter pw = new PrintWriter(sw);
				ex.printStackTrace(pw);
				createLogFile("search",sw.toString());
			}
	}
}
