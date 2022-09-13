package e_commerceLiverpool_Scenarios;

import e_commerceLiverpool_Library.RegisteredCheckout_Libary;

public class RegisteredCheckout_Scenario extends CreateDriver{

	public static void registeredCheckout() throws InterruptedException {
		int i = 0;
		while(i<1) {
			RegisteredCheckout_Libary checkout = new RegisteredCheckout_Libary(setUp());
			checkout.LogIn();
			checkout.navigateUserSessionOpt();
			checkout.addItems();
			checkout.myBag();
			checkout.oneCheckOut();
			checkout.oneCheckoutTwo();
			checkout.logOut();
			tearDown();
			System.out.println("iteracion number:---------------------------------- "+ i);
			i++;
		}
	}
}
