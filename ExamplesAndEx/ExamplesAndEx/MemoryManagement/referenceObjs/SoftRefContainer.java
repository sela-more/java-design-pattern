/*
 * Created on 26/09/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package referenceObjs;
import java.lang.ref.*;

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SoftRefContainer {

	WeakReference<Student> m_students[] = new WeakReference[10];

	SoftRefContainer() {
		for (int i=0; i<10; i++)
			m_students[i] = new WeakReference<Student>(new Student("student" + i));
	}


	public void print() {
		Reference<Student> sr;
		for (int i=0; i<10; i++) {
			sr = m_students[i];
			Object temp = sr.get();
			if (temp==null) {
				// No object found
			}
			System.out.println("printing container: " + temp);
		}
	}

	public static void main (String args[]) {
		SoftRefContainer s = new SoftRefContainer();
		s.print();

		System.out.println("Filling memory with junk...");
		Data d[] = new Data[5000];
		for (int i=0; i<d.length; i++)
			d[i] = new Data();

		s.print();

	}
}
