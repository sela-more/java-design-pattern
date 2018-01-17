
package delegation.OOCollege.completeSolution;


public class Person  implements IPerson
{
	 
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

