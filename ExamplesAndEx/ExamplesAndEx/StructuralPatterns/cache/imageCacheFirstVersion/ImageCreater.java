package cache.imageCacheFirstVersion;
import java.io.IOException;
class ImageCreater
{
	public CachedImage createImage(String sURL) throws ImageCreationException
	{
		try
		{
			return new CachedImage(sURL);
		}
		catch (IOException e)
		{
			throw new ImageCreationException(sURL);
		}
	}
};