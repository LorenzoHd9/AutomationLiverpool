package e_commerceLiverpool_Scenarios;

import e_commerceLiverpool_Library.GiftRegistry_Library;

public class GiftRegistry_Scenario extends CreateDriver{

	public static void giftRegistry() throws InterruptedException {
		GiftRegistry_Library giftRegistry = new GiftRegistry_Library(setUp());
		giftRegistry.searchByName();
		giftRegistry.searchByID();
		tearDown();
	}
}
