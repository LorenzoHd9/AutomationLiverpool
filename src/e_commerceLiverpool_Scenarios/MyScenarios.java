package e_commerceLiverpool_Scenarios;

import java.io.IOException;

public class MyScenarios {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("start runing scenarios-----");
		Browse_Scenario.browse();
		System.out.println("Browse scenario Done!");
		Search_Scenario.search();
		System.out.println("Search scenario Done!");
		GiftRegistry_Scenario.giftRegistry();
		System.out.println("gift registry scenario Done!");
		RegisteredCheckout_Scenario.registeredCheckout();
		System.out.println("Registered checkout scenario Done!");
		//Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T").destroy();
		StaticPages_Scenario.statiPages();
		System.out.println("Static pages scenario Done!");
		System.out.println("finish scenarios----");
	}

}
