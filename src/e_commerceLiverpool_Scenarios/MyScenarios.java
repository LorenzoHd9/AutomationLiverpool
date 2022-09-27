package e_commerceLiverpool_Scenarios;

import java.io.IOException;

import e_commerceLiverpool_Library.BaseLibrary;

public class MyScenarios {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		if(BaseLibrary.configProperties("parallel")== "false") {
			System.out.println("********************** start runing scenarios *********************");
			//Browse_Scenario.browse();
			//Search_Scenario.search();
			GiftRegistry_Scenario.giftRegistry();
			//RegisteredCheckout_Scenario.registeredCheckout();
			//StaticPages_Scenario.statiPages();
			System.out.println("*************************** finish *************************");
		}
		else {
			/*TestNG testng = new TestNG();
              List<String> suites = Lists.newArrayList();
              suites.add("testng.xml");//Path to xml file, put at same level as jar file
              testng.setTestSuites(suites);
              testng.run(); 
			*/
		}
	}

}
