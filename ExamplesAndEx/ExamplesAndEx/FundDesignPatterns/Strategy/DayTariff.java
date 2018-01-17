/*
 * Created on Nov 12, 2006
 *
  */
package Strategy;


public class DayTariff implements Tariff {

	
	public int calcCall(int time) {
		System.out.println("In day tariff, calcCall");
		return time*2;
	}

}
