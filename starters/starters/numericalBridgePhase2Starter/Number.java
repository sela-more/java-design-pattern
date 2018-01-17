package numericalBridgePhase2Starter;


public class Number {
	
	public Number(NumberImp ni) {m_imp = ni;}
	public void increment() {m_imp.increment();}
	public void set(Number newNum) {m_imp = newNum.m_imp;}
	public Number plus(Number other) {return new Number(m_imp.plus(other.m_imp));}
	
	private NumberImp m_imp;

	public String toString() {
		return m_imp.toString();
	}  

}
