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
public class SoftyWithQueue {

	ReferenceQueue m_rq = new ReferenceQueue();
	SoftReference m_student = new SoftReference(new Student("shraga"),m_rq);

	public void print() {
			System.out.println(m_student.get());
	}

	public static void main (String args[]) {
		SoftyWithQueue s = new SoftyWithQueue();
		s.print();
		System.out.println("starting to waste some memory...");
		for (int i=0; i<15000; i++) {
			Reference temp = s.m_rq.poll();
			if (temp!=null) {
			
				System.out.println(i+". a reference was returned by queue="+temp);
			}
		//	double [][]arr = new double[100][100];	// waste some memory
			Data d[] = new Data[5000];
			for (int i1=0; i1<d.length; i1++)
				d[i1] = new Data();
		}
		s.print();

	}
}
