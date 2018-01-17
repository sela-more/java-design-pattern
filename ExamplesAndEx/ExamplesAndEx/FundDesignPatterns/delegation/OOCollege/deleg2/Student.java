/*
 * Created on 27/09/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package delegation.OOCollege.deleg2;

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
// Second delegation versoin
public class Student  extends PersonRole{ // do not extend person
										  // extend PRole
		private float m_fAverage;
	
		// no reference to person
		

		// ctor sets the reference to person
		Student(Person p, float fAverage)
		{
			super(p);
			m_fAverage = fAverage;
		}
		
		// No need to delegate requests to person
		// as PersonRole does that already
		

		public float getAverage()
		{
			return m_fAverage;
		}

		
		public String toString()
		{
			return super.toString() + " Average = " + m_fAverage;
		}

}
