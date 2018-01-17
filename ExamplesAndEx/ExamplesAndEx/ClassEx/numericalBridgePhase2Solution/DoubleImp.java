package numericalBridgePhase2Solution;


public class DoubleImp extends NumberImp {

	public DoubleImp (double d ){m_val = d;}
	public void increment() {
		// TODO Auto-generated method stub
		m_val+=1.0;
	}
	
	public NumberImp plus(NumberImp other){
		 return other.plus(this);
	 }
	 public NumberImp plus(IntImp other){
		 return new DoubleImp(m_val + other.getVal());
	 }
	 public NumberImp plus(DoubleImp other){
		 return new DoubleImp(m_val + other.getVal());
	 }
	
	private double m_val;
	public double getVal() {return m_val;}

	public String toString() {
		return "A Double Implementation, value: " + m_val;
	}

}
