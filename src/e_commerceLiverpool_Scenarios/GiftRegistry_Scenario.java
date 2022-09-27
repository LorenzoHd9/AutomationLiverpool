package e_commerceLiverpool_Scenarios;

import java.io.IOException;
import java.io.PrintWriter;

import e_commerceLiverpool_Library.GiftRegistry_Library;

public class GiftRegistry_Scenario extends CreateDriver{

	public static void giftRegistry() throws InterruptedException, IOException {
			try {
				GiftRegistry_Library giftRegistry = new GiftRegistry_Library(setUp());
				giftRegistry.searchByName();
				giftRegistry.searchByID();
				tearDown();
				System.out.println("-------giftRegistry scenario completed:-------");
				System.out.println();
			}
			catch(Exception ex) {
				System.out.println("something went wrong, look at the log file for more details!!");
				PrintWriter pw = new PrintWriter(sw);
				ex.printStackTrace(pw);
				createLogFile("giftRegistry",sw.toString());
				tearDown();
			}
	}
}
