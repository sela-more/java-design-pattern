package cache.imageCacheLRUVersion;
import  java.util.*;

class ImageCache
{
	private static final int DEFAULT_MAX_SIZE = 100;
	private static final int DEFAULT_REMOVAL_SIZE = 10;
	private int m_nMaxSize;
	private int m_nRemovalSize;

	ImageCache()
	{
		m_nMaxSize = DEFAULT_MAX_SIZE;
		m_nRemovalSize = DEFAULT_REMOVAL_SIZE;
	}

	ImageCache(int nMaxSize, int nRemovalSize)
	{
		m_nMaxSize = nMaxSize;
		m_nRemovalSize = nRemovalSize;
	}

	private HashMap m_Images = new HashMap();

	public void addImage(String sURL, CachedImage NewImage)
	{
		if (m_Images.size() == m_nMaxSize)
			compress();
		m_Images.put(sURL, NewImage);
	}

	private void compress()
	{
		TreeMap SortedCache = new TreeMap(m_Images);
		for (int i = 0 ; i < m_nRemovalSize ; ++i )
			SortedCache.remove(SortedCache.firstKey());

		m_Images = new HashMap(SortedCache);
	}

	public CachedImage fetchImage(String sURL)
	{
		CachedImage temp =  (CachedImage)m_Images.get(sURL);
		if (temp!= null)
			temp.setLastAccessTime();
		return temp;

	}

};