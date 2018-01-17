package cache.imageCacheFirstVersion;
import javax.swing.*;
import java.io.*;
import java.net.*;
class CachedImage extends ImageIcon
{
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
	}
};