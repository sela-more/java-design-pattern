package numericalBridgePhase2Solution;


public abstract class NumberImp {
	
	
	abstract public void increment() ;
	abstract public NumberImp plus(NumberImp other);
	abstract public NumberImp plus(IntImp other);
	abstract public NumberImp plus(DoubleImp other);
	
	

}
