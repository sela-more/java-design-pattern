package dynamicProxy;
import java.lang.reflect.*;
import java.util.*;

public interface MyInterface {
  public void m1(int i);
  public void m2(String s);
  public void m3(int i, String s);
}


class Dog implements MyInterface {

  public void m1(int i) {
  	System.out.println("Dog's m1");
  }
  public void m2(String s) {
  	System.out.println("Dog's m2");
  }
  public void m3(int i, String s) {
  	System.out.println("Dog's m3");
  }

}






 class MyInvocationHandler1 implements InvocationHandler { 
   Object m_obj;

   public MyInvocationHandler1(Object obj) {
   	m_obj=obj;
   }

   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
   {
       System.out.println("Logging... Method " + method.getName() +
                    " was invoked with " + args.length + " arguments");

       return method.invoke(m_obj, args);
      
   }
}

 
class Driver2 {
	
	  public static void main(String[] args) {
		ArrayList<String> ar = new ArrayList<String>();
		MyInvocationHandler1 ih = new MyInvocationHandler1(ar); 
		
		Object o2 = Proxy.newProxyInstance(Driver.class.getClassLoader(),
			ar.getClass().getInterfaces(), 
			ih);
		System.out.println(o2 instanceof List);
		List<String> li = (List)o2;
		li.add("first string");
		li.add("second string");
		li.add("third string");
		System.out.println(ar);
	  
	
	  }

}