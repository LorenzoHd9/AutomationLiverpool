package e_commerceLiverpool_Scenarios;

import java.io.IOException;

import e_commerceLiverpool_Library.BaseLibrary;
import e_commerceLiverpool_Library.RegisteredCheckout_Libary;

public class RegisteredCheckout_Scenario extends CreateDriver{

	public static void registeredCheckout() throws InterruptedException, IOException {
			try {
				RegisteredCheckout_Libary checkout = new RegisteredCheckout_Libary(setUp());
				BaseLibrary.initScenario("registered_user_checkout_web");
				checkout.LogIn();
				checkout.cleanCart();
				checkout.navigateUserSessionOpt();
				checkout.addItems();
				checkout.myBag();
				checkout.oneCheckOut();
				checkout.oneCheckoutTwo();
				checkout.logOut();
				tearDown();
				System.out.println("--Registered user checkout scenario completed:-");
				BaseLibrary.endScenario("0", "","");
			}
			catch(Exception ex) {
				//BaseLibrary.captureScreenShot(setUp(),"checkout");
				tearDown();
				BaseLibrary.errorScenario("registered_user_checkout_web", ex);
			}
	}
}
