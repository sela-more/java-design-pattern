/*
 * Created on 27/09/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package delegation.OOCollege.withInheritance;

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Student extends Person {
	private float m_fAverage;
	
		Student(Person p, float fAverage)
		{
			super(p.getName());
			m_fAverage = fAverage;
		}

			public float getAverage()
		{
			return m_fAverage;
		}

		public String toString()
		{
			return super.toString() + " Average = " + m_fAverage;
		}

}
