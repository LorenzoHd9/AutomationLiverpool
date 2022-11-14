package e_commerceLiverpool_Scenarios;

import java.io.IOException;

import e_commerceLiverpool_Library.BaseLibrary;


public class MyScenarios {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int i = 1;
		int browse = Integer.parseInt(BaseLibrary.configProperties("browse"));
		int search = Integer.parseInt(BaseLibrary.configProperties("search"));
		int gift = Integer.parseInt(BaseLibrary.configProperties("giftRegistry"));
		int checkout = Integer.parseInt(BaseLibrary.configProperties("registeredCheckOut"));
		int staticP = Integer.parseInt(BaseLibrary.configProperties("staticPages"));
		while (true) {
			System.out.println("************************ starting... *************************");
			if (browse == 1) {
				Browse_Scenario.browse();
			}
			if (search == 1) {
				Search_Scenario.search();
			}
			if (gift == 1) {
				GiftRegistry_Scenario.giftRegistry();
			}
			if (checkout == 1) {
				RegisteredCheckout_Scenario.registeredCheckout();
			}
			if (staticP ==  1) {
				StaticPages_Scenario.statiPages();
			}
			System.out.println("*************************** finished *************************");
			System.out.println("iteration number: " + i);
			i++;
		}
			/*TestNG testng = new TestNG();
              List<String> suites = Lists.newArrayList();
              suites.add("testng.xml");//Path to xml file, put at same level as jar file
              testng.setTestSuites(suites);
              testng.run(); 
			*/
	}

}
