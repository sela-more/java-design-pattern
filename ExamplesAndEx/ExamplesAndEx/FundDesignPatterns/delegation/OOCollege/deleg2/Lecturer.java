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
public class Lecturer  extends PersonRole{ // extend PR
	private float m_fSalary;
	
	

	Lecturer(Person p, float fSalary)
	{
		super(p);
		m_fSalary = fSalary;
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
		return super.toString() + " Salary = " + m_fSalary;
	}

	

}
