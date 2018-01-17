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
public class Person {
	 
		private String m_sName;

		Person(String sName)
		{
			m_sName=sName;
		}
		public String getName()
		{
			return m_sName;
		}
		public String toString()
		{
			return "Name = " + m_sName;
		}

	};

