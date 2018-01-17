/*
 * Created on 27/09/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package dynamicProxy;
import java.lang.reflect.*;

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Driver {
	
	  public static void main(String[] args) {
		Object o = Proxy.newProxyInstance(Driver.class.getClassLoader(),
									  new Class[] {MyInterface.class},
									  new MyInvocationHandler1(new Dog()));
		System.out.println(o instanceof MyInterface);
		MyInterface mi = (MyInterface)o;
		mi.m1(1);
		mi.m2("Hello");
		mi.m3(3, "This is a string");
	  }
	


}
