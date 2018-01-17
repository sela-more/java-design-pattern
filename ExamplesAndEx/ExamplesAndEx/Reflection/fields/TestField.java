package fields;
/*
 * Created on 27/09/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author clsd1
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import java.lang.reflect.*;

class Base {
	public int m_base;
}
class Derived extends Base {
	public int m_derived;
}
public class TestField {

	/**
	 * 
	 */
	public TestField() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Field baseFields[] = fields.Base.class.getDeclaredFields();
		System.out.println("Base Fields:");
		for (int i=0; i<baseFields.length;i++) {
			System.out.println("FieldName: " + baseFields[i].getName() + "Field Defined Class: " +
					baseFields[i].getDeclaringClass());
		}
		
		Field derFields[] = fields.Derived.class.getDeclaredFields();
		System.out.println("Derived Fields:");
		for (int i=0; i<derFields.length;i++) {
			System.out.println("FieldName: " + derFields[i].getName() + "Field Defined Class: " +
					derFields[i].getDeclaringClass());
		}
		
	}
}
