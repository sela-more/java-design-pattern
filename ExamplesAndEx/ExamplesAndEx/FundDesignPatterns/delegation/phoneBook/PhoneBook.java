package delegation.phoneBook;
import java.util.*;
class PhoneBook
{
	private Set<Person> m_Persons;

	PhoneBook()
	{
		m_Persons = new HashSet<Person>();
	}

	public void addEntry(String sName, String sPhoneNumber)
	{
		m_Persons.add(new Person(sName, sPhoneNumber));
	}

	public void setSortedMode()
	{
		if (m_Persons instanceof TreeSet)
			return;

		m_Persons = new TreeSet<Person>(m_Persons);
	}

	public void setNonSorted()
	{
		if (m_Persons instanceof HashSet)
			return;

		m_Persons = new HashSet<Person>(m_Persons);
	}

	public void print()
	{
		if (m_Persons instanceof HashSet)
			System.out.println("Status = Not Sorted");
		else if (m_Persons instanceof TreeSet)
			System.out.println("Status = Sorted");

		Iterator<Person> iter = m_Persons.iterator();

		while(iter.hasNext())
			System.out.println(iter.next());
	}
};
