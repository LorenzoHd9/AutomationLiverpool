package e_commerceLiverpool_Scenarios;

import e_commerceLiverpool_Library.RegisteredCheckout_Libary;

public class RegisteredCheckout_Scenario extends CreateDriver{

	public static void registeredCheckout() throws InterruptedException {
		int i = 0;
		while(i < 2) {
			try {
				RegisteredCheckout_Libary checkout = new RegisteredCheckout_Libary(setUp());
				checkout.LogIn();
				checkout.cleanCart();
				checkout.navigateUserSessionOpt();
				checkout.addItems();
				checkout.myBag();
				checkout.oneCheckOut();
				checkout.oneCheckoutTwo();
				checkout.logOut();
				tearDown();
				System.out.println("Registered checkout iteration complete: "+i);
			}
			catch(Exception ex) {System.out.println("something when wrong, closing chrome...");tearDown();}
			i++;
		}
	}
}
