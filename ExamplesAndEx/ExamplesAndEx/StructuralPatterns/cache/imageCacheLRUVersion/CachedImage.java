package cache.imageCacheLRUVersion;
import javax.swing.*;
import java.io.*;
import java.net.*;
class CachedImage extends ImageIcon implements Comparable
{
	private long m_lLastAccessTime;
	private static byte[] getBinData(String sURL) throws IOException
	{
		URL NetLocation = new URL(sURL);
		InputStream is = NetLocation.openStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int bData;
		while ((bData = is.read()) != -1)
		{
			baos.write(bData);
		}
		byte ArrData[] = baos.toByteArray();
		baos.close();
		return ArrData;

	}
	CachedImage(String sURL) throws IOException
	{
		super(getBinData(sURL));
		setLastAccessTime();
	}

	public CachedImage setLastAccessTime()
	{
		m_lLastAccessTime = System.currentTimeMillis();
		return this;
	}

	public int compareTo(Object other)
	{
		if (!(other instanceof CachedImage))
			throw new ClassCastException("Error performing comparation");

		return (int)(m_lLastAccessTime - ((CachedImage)other).m_lLastAccessTime);
		
	}
};