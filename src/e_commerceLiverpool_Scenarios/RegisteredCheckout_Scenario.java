package e_commerceLiverpool_Scenarios;

import java.io.PrintWriter;

import org.apache.commons.text.StringEscapeUtils;

import e_commerceLiverpool_Library.BaseLibrary;
import e_commerceLiverpool_Library.RegisteredCheckout_Libary;

public class RegisteredCheckout_Scenario extends CreateDriver{

	public static void registeredCheckout() throws InterruptedException {
			try {
				RegisteredCheckout_Libary checkout = new RegisteredCheckout_Libary(setUp());
				BaseLibrary.initScenario("registered_user_checkout");
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
				BaseLibrary.endScenario("0", "");
			}
			catch(Exception ex) {
				System.out.println("something went wrong, look at the log file for more details!!");
				tearDown();
				BaseLibrary.endScenario("1", StringEscapeUtils.escapeJava(ex.getMessage()));
				PrintWriter pw = new PrintWriter(sw);
				ex.printStackTrace(pw);
				createLogFile("registeredCheckout",sw.toString());
			}
	}
}
