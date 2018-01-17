package iterator.tableCreator;
class TableCreator
{
	StringBuffer m_sData = new StringBuffer();
	TableCreator(TableContainer Cont) throws Exception
	{
		TableContentIterator iter = Cont.iterator();
		TableRow CurrentRow;
		if (!iter.hasNextRow())
			throw new Exception("Collection is empty");

		CurrentRow = iter.getNextRow();
		m_sData.append("<table border=1>\n");
		m_sData.append(CurrentRow.getHeader());
		m_sData.append("\n");
		m_sData.append(CurrentRow.getRow());
		m_sData.append("\n");

		while (iter.hasNextRow())
		{
			m_sData.append(iter.getNextRow().getRow());
			m_sData.append("\n");
		}
		m_sData.append("</table>\n");
	}

	public String toString()
	{
		return m_sData.toString();
	}
};