package ctor;
import java.lang.reflect.*;


public class CtorsParams {

	public static void main(String[] args) {

		Class<?> cls;
		Constructor<?> Ctor;

		try {
			Class<?>[] cArray = new Class[] { String.class, String.class, String.class };

			// method 1 - getCobnstractor
			cls = Class.forName("ctor.Person");
			Ctor = cls.getConstructor(cArray);
			Object [] cParam = {"Kosmo","Kramer","1.70"};

			Person p = (Person)Ctor.newInstance(cParam);
			System.out.println( p );


			// method 2 - getDeclaredConstractor
			Constructor<?> ctor = cls.getDeclaredConstructor(
					new Class[] {String.class, int.class });
			Object oPerson = ctor.newInstance(
					new Object[] {"Amnon", new Integer(30) });
			
			System.out.println( oPerson );
		}
		catch(Exception e) {
			System.out.println(e);
		}





	}





}