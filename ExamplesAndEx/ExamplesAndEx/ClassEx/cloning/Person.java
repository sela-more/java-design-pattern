package cloning;
import java.util.*;
class Person implements Cloneable
{
	private String m_sName;
	private LinkedList<String> m_Phones = new LinkedList<String>();

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

	@SuppressWarnings("unchecked")
	public Object clone() throws CloneNotSupportedException
	{
		System.out.println("cloning person");
		Person newPerson = (Person)super.clone();
		newPerson.m_Phones = (LinkedList<String>)m_Phones.clone();
		return newPerson;
	}

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