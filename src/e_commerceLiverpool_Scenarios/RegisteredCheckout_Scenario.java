package e_commerceLiverpool_Scenarios;

import java.io.PrintWriter;

import e_commerceLiverpool_Library.RegisteredCheckout_Libary;

public class RegisteredCheckout_Scenario extends CreateDriver{

	public static void registeredCheckout() throws InterruptedException {
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
				System.out.println("Registered checkout iteration complete: ");
			}
			catch(Exception ex) {
				PrintWriter pw = new PrintWriter(sw);
				ex.printStackTrace(pw);
				createLogFile("registeredCheckout",sw.toString());
				tearDown();
			}
	}
}
