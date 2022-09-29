package e_commerceLiverpool_Scenarios;

import java.io.IOException;

import e_commerceLiverpool_Library.BaseLibrary;
import e_commerceLiverpool_Library.GiftRegistry_Library;

public class GiftRegistry_Scenario extends CreateDriver{

	public static void giftRegistry() throws InterruptedException, IOException {
			try {
				GiftRegistry_Library giftRegistry = new GiftRegistry_Library(setUp());
				BaseLibrary.initScenario("gift_Registry");
				giftRegistry.searchByName();
				giftRegistry.searchByID();
				tearDown();
				System.out.println("-------giftRegistry scenario completed:-------");
				System.out.println();
				BaseLibrary.endScenario("0", "");
			}
			catch(Exception ex) {
				tearDown();
				BaseLibrary.errorScenario("gift_registry", ex);
			}
	}
}
