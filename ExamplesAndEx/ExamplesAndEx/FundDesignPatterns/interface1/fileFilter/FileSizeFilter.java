package interface1.fileFilter;
import java.io.FilenameFilter;
import java.io.File;

class FileSizeFilter implements FilenameFilter
{
	private int m_nMinSize;
	private int m_nMaxSize;

	FileSizeFilter(int nMinSize, int nMaxSize) throws InvalidArgumentException
	{
		if (nMinSize > nMaxSize)
		{
			throw new InvalidArgumentException("nMinSize > nMaxSize");
		}
		m_nMinSize = nMinSize;
		m_nMaxSize = nMaxSize;
	}

	public boolean accept(File fDir, String sName)
	{
		File fToCheck = new File(fDir, sName);
		return ((fToCheck.isFile()) && (fToCheck.length() > m_nMinSize) && (fToCheck.length() < m_nMaxSize));
	}

	public String toString()
	{
		return "File Size Filter, Minimum size = " + m_nMinSize + " Maximum size = " + m_nMaxSize;
	}
}