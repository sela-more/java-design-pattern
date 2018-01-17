/*
 * Created on Nov 12, 2006
 *
  */
package Strategy;


public class NightTariff implements Tariff {

	
	public int calcCall(int time) {
		System.out.println("In night tariff, calcCall");
		return time;
	}

}
