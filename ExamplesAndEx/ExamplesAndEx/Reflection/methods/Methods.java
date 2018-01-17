package methods;
import java.lang.reflect.*;

public class Methods {


	public void m1(){System.out.println("In m1");}
	private void m2() {System.out.println("In m2");}
	public int m3(int arg){System.out.println("In m3");return 1;}
	
	public static void main (String args[]) {

		if (args.length<1)
			return;

		try {
			Class<?> cls = Class.forName(args[0]);
			Object o = (Object)cls.newInstance();

			System.out.println("\navailable methods...");
			Method []allMethods = cls.getDeclaredMethods();
			for (int i=0; i<allMethods.length; i++)
				System.out.println(allMethods[i].getName());

			// this of course is good for this class only,
			// as I dont bother to get the number of args for 
			// the moethod etc
			System.out.println("Param Types of method " + allMethods[3].getName());
			Class<?>[] types = allMethods[3].getParameterTypes();
			int parL = types.length;
			for (int i=0; i< parL; i++)
				System.out.println(types[i].getName());
			if (allMethods[3].getParameterTypes().length == 1) {
				if (allMethods[3].getParameterTypes()[0] == int.class) {
					Object[] par = new Object[] {17};
				
					System.out.println("return value from a method: "
							+allMethods[3].invoke(o, par));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}




}