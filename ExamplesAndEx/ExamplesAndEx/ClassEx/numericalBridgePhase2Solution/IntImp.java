package numericalBridgePhase2Solution;


public class IntImp extends NumberImp {
	public IntImp (int i) {m_val = i;}
	public void increment() {
		
		m_val+=1;
	}
	
	 public NumberImp plus(NumberImp other){
		 return other.plus(this);
	 }
	 public NumberImp plus(IntImp other){
		 return new IntImp(m_val + other.m_val);
	 }
	 public NumberImp plus(DoubleImp other){
		 return new DoubleImp((double)m_val + other.getVal());
	 }
	 public int getVal() {return m_val;}
	
	
	private int m_val;

	public String toString() {
		return "An Int Implementation, value: " + m_val;
	}

}
