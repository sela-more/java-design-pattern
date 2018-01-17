package cache.imageCacheFirstVersion;
import  java.util.HashMap;

class ImageCache
{
	private HashMap m_Images = new HashMap();

	public void addImage(String sURL, CachedImage NewImage)
	{
		m_Images.put(sURL, NewImage);
	}

	public CachedImage fetchImage(String sURL)
	{
		return (CachedImage)m_Images.get(sURL);
	}

};