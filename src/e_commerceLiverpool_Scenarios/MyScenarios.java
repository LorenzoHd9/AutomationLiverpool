package e_commerceLiverpool_Scenarios;

import java.io.IOException;

public class MyScenarios {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("start runing scenarios-----");
		Browse_Scenario.browse();
		Search_Scenario.search();
		GiftRegistry_Scenario.giftRegistry();
		RegisteredCheckout_Scenario.registeredCheckout();
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T").destroy();
		StaticPages_Scenario.statiPages();
		System.out.println("finish scenarios----");
	}

}
