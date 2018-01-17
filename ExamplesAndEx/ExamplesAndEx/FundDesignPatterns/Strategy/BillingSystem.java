/*
 * Created on Nov 12, 2006
 *
 */
package Strategy;


public class BillingSystem {
	private Tariff m_currentTariff;
	BillingSystem(Tariff tariff) {
		this.m_currentTariff = tariff;
	}
	public void setTariff (Tariff newTariff) {
		this.m_currentTariff = newTariff;
	}
	public int calcCall(int duration) {
		return this.m_currentTariff.calcCall(duration);
	}

}
