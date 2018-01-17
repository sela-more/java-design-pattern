package numericalBridgePhase2Starter;


public class IntImp extends NumberImp {
	public IntImp (int i) {m_val = i;}
	public void increment() {
		
		m_val+=1;
	}
		//Studnet?
	 public int getVal() {return m_val;}
	
	
	private int m_val;

	public String toString() {
		return "An Int Implementation, value: " + m_val;
	}

}
