package numericalBridgePhase2Solution;


public class Driver {

	
	public static void main(String[] args) {
		Number ni = new Number(new IntImp(4));
		Number nd = new Number(new DoubleImp(3.5));
		
		
		ni.increment();
		nd.increment();
		
		System.out.println(ni);
		System.out.println(nd);
		
		ni.set(ni.plus(nd));
		System.out.println("Adding integer 5 and double 4.5");
		System.out.println(ni);
		ni.set(nd);
		System.out.println(ni);
		ni.increment();
		System.out.println(ni);
		
	

	}

}
