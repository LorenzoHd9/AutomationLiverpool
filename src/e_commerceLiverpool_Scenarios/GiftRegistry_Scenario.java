package e_commerceLiverpool_Scenarios;

import e_commerceLiverpool_Library.GiftRegistry_Library;

public class GiftRegistry_Scenario extends CreateDriver{

	public static void giftRegistry() throws InterruptedException {
		/*int i =0;
		while(i< 10) {
			System.out.println("iteration number: " +i);
			i++;
		}*/
		GiftRegistry_Library giftRegistry = new GiftRegistry_Library(setUp());
		giftRegistry.searchByName();
		giftRegistry.searchByID();
		tearDown();
	}
}
