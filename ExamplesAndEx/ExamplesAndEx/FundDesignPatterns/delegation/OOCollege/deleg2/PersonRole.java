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
public class PersonRole implements IPerson {
	private Person m_person;

	PersonRole(Person p) {
		m_person=p;
	}

	public String getName()
	{
		
		return m_person.getName();
	}
	public String toString() {
		return m_person.toString();
	}

}
