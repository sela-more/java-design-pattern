package iterator.tableCreator;
class Person implements TableRow
{
	private String m_sName;
	private String m_sNumber;

	private static final String HEADER = "\t<tr>\n\t\t<th>Name</th>\n\t\t<th>Phone Number</th>\n\t</tr>";

	Person(String sName, String sNumber)
	{
		m_sName = sName;
		m_sNumber = sNumber;
	}

	public String getHeader()
	{
		return HEADER;
	}

	public String getRow()
	{
		StringBuffer sb = new StringBuffer("\t<tr>\n\t\t<td>").append(m_sName).
					append("</td>\n\t\t<td>").append(m_sNumber).
					append("</th>\n\t</tr>");
		return sb.toString();
	}
}