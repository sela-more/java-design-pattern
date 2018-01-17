package interface1.phoneBookFilter;
class Person implements Comparable
{
	private String m_sName;
	private String m_sPhoneNum;

	Person(String sName, String sPhoneNum)
	{
		m_sName = sName;
		m_sPhoneNum = sPhoneNum;
	}

	public String toString()
	{
		return "Name = " + m_sName + "\tPhone = " + m_sPhoneNum;
	}

	public int hashCode()
	{
		return m_sName.hashCode();
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Person))
			return false;
		Person pOther = (Person)o;
		return ((m_sName.equals(pOther.m_sName)) && (m_sPhoneNum.equals(pOther.m_sPhoneNum)));
	}

	public int compareTo(Object other)
	{
		if (!(other instanceof Person))
			throw new ClassCastException("Tried to compared a person with an " + other.getClass().getName());

		return m_sName.compareTo(((Person)other).m_sName);
	}

	String getName()
	{
		return m_sName;
	}

	String getPhoneNumber()
	{
		return m_sPhoneNum;
	}
};
