/*
 * Created on Nov 12, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package Strategy;

/**
 * @author localuser
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Main {
	
	public static void main(String args[])  {
		DayTariff dt = new DayTariff();
		NightTariff nt = new NightTariff();
		BillingSystem billSys = new BillingSystem(dt);
		System.out.println("Calculating cost of 50 minutes call: ");
		System.out.println("" + billSys.calcCall(50));
		billSys.setTariff(nt);
		System.out.println("Calculating cost of 50 minutes call: ");
		System.out.println("" + billSys.calcCall(50));
	}
}
