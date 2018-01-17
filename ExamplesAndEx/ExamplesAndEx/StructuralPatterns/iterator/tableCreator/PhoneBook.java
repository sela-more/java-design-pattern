package iterator.tableCreator;
class PhoneBook implements TableContainer
{
	private Person m_Arr[];

	PhoneBook(int nNumberOfPersons)
	{
		m_Arr = new Person[nNumberOfPersons];
		for (int i = 0 ; i < m_Arr.length ; ++i )
		{
			m_Arr[i] = new Person("Person #" + i, "0" + ((int)(Math.random() * 10) + 1) + "-" + ((int)(Math.random() * 10000000) + 1));
		}
	}

	public TableContentIterator iterator()
	{
		return new PhoneBookIterator();
	}

	class PhoneBookIterator implements TableContentIterator
	{
		private int m_nPosition;

		public boolean hasNextRow()
		{
			return m_nPosition < m_Arr.length;
		}

		public TableRow getNextRow()
		{
			return m_Arr[m_nPosition++];
		}
	};
};