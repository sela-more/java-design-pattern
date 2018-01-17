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
public class Lecturer  { // do not extend
	private float m_fSalary;
	
	// define a reference to person
	private Person m_person;

	Lecturer(Person p, float fSalary)
	{
		m_person=p;
		m_fSalary = fSalary;
	}
	//	delegate requests to person
		 public String getName()
		 {
			 return m_person.getName();
		 }
		public void setSalary(float fSalary)
	{
		m_fSalary = fSalary;
	}
	public float getSalary()
	{
		return m_fSalary;
	}
	public String toString()
	{
		return m_person.toString() + " Salary = " + m_fSalary;
	}

	

}
