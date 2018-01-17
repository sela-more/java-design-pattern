/*
 * Created on 27/09/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package delegation.OOCollege.deleg1;

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
// first delegation versoin
public class Student  { // do not extend person
		private float m_fAverage;
	
		// add reference to person
		private Person m_person;

		// ctor sets the reference to person
		Student(Person p, float fAverage)
		{
			m_person=p;
			m_fAverage = fAverage;
		}
		
		// delegate requests to person
		public String getName()
		{
			return m_person.getName();
		}

		public float getAverage()
		{
			return m_fAverage;
		}

		// delegation
		public String toString()
		{
			return m_person.toString() + " Average = " + m_fAverage;
		}

}
