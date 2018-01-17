package cloningStarter;
import java.util.*;

import cloning.Person;
class PhoneBook // student??
{
	private HashMap<String,Person> m_Persons = new HashMap<String,Person> ();
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

		// stuedent?? Another method is needed here?
		
		
		// a review on how to iterate a map:
		// Map does not have an iterator. You need to ask for entrySet
		// which gives you a set of elements of type Map.Entry
		// Each such element has getKey() and getValue() methods
//		Iterator<Map.Entry<String,Person>> iter = m_Persons.entrySet().iterator();
//		while(iter.hasNext())
//		{
//			Map.Entry<String,Person> nextEntry = iter.next();
//			......nextEntry.getKey()
//			.......nextEntry.getValue()
//		}
	
	
	
	

	

	public String toString()
	{
		StringBuffer temp = new StringBuffer();
		Iterator<Person> iter = m_Persons.values().iterator();
		while(iter.hasNext())
			temp.append(iter.next().toString()).append("\n");
		return temp.toString();
	}



};

