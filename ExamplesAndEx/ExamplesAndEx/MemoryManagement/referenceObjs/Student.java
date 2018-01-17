/*
 * Created on 26/09/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package referenceObjs;

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Student {

	String m_name;

	public Student(String name) {
		m_name=name;
	}

	public String toString() {
		return "student="+m_name;
	}

	protected void finalize() {
		System.out.println("finalize() m_name=" + m_name + " Data counter: " + Data.counter);
	}
}
