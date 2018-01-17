package cloning;
import java.util.*;
class PhoneBook implements Cloneable
{
	private HashMap<String,Person> m_Persons = new HashMap<String,Person> ();

	public String toString()
	{
		StringBuffer temp = new StringBuffer();
		Iterator<Person> iter = m_Persons.values().iterator();
		while(iter.hasNext())
			temp.append(iter.next().toString()).append("\n");
		return temp.toString();
	}


	public void addPerson(Person p)
	{
		m_Persons.put(p.getName(), p);
	}

	public Person getPerson(String sName)
	{
		return m_Persons.get(sName);
	}

	public void printPersonDetails(String sName)
	{
		System.out.println(m_Persons.get(sName).toString());
	}

	public Object clone() throws CloneNotSupportedException
	{
		System.out.println("cloning phonebook");
		PhoneBook copy = (PhoneBook)super.clone();
		copy.m_Persons = new HashMap<String,Person>();
		Iterator<Map.Entry<String,Person>> iter = m_Persons.entrySet().iterator();
		while(iter.hasNext())
		{
			Map.Entry<String,Person> nextEntry = iter.next();
			copy.m_Persons.put(nextEntry.getKey(),
							   ((Person)(nextEntry.getValue()).clone()));
		}
		return copy;
	}

};

