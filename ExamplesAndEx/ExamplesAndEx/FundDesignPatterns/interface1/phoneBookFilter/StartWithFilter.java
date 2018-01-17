package interface1.phoneBookFilter;
class StartWithFilter implements IFilterPerson
{
	private String m_sStartWith;

	StartWithFilter(String sStartWith)
	{
		m_sStartWith = sStartWith;
	}

	public boolean match(Person p)
	{
		return p.getName().startsWith(m_sStartWith);
	}

	public String toString()
	{
		return "Name filter, matches all persons which name' starts with " + m_sStartWith;
	}
};