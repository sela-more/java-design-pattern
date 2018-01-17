package numericalBridgePhase1Solution;

public class DoubleImp extends NumberImp {

	public DoubleImp (double d ){m_val = d;}
	public void increment() {
		// TODO Auto-generated method stub
		m_val+=1.0;
	}
	
	private double m_val;

	public String toString() {
		return "A Double Implementation, value: " + m_val;
	}

}
