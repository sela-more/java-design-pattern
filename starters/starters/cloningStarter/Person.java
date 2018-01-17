package cloningStarter;
import java.util.*;
class Person // Studnet?
{
	private String m_sName;
	private LinkedList<String> m_Phones = new LinkedList();

	Person(String sName, String sPhoneNumber)
	{
		m_sName = sName;
		m_Phones.add(sPhoneNumber);
	}

	public void addPhoneNumber(String sPhoneNumber)
	{
		m_Phones.add(sPhoneNumber);
	}

	public void removePhoneNumber(String sPhoneNumber)
	{
		System.out.println("removing person");
		m_Phones.remove(sPhoneNumber);
	}

	// student?? add method

	public String getName()
	{
		return m_sName;
	}

	public String toString()
	{
		StringBuffer temp = new StringBuffer().append("Person, Name = ").
			append(m_sName).
			append("\n").
			append("Phones:");
		Iterator<String> iter = m_Phones.iterator();
		while(iter.hasNext())
			temp.append("\t").append(iter.next());
		return temp.toString();
	}
};