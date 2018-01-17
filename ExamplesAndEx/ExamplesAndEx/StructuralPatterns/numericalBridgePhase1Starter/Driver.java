package numericalBridgePhase1Starter;

import Bridge.DoubleImp;
import Bridge.IntImp;
import Bridge.Number;

public class Driver {

	
	public static void main(String[] args) {
		Number ni = new Number(new IntImp(4));
		Number nd = new Number(new DoubleImp(3.5));
		
		ni.increment();
		nd.increment();
		
		System.out.println(ni);
		System.out.println(nd);
		
		ni.set(nd);
		System.out.println(ni);
		ni.increment();
		System.out.println(ni);

	}

}
