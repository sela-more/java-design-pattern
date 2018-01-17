package cache.imageCacheFirstVersion;
class CacheManager
{
	private ImageCache		m_Cache;
	private ImageCreater	m_Creater;

	public CacheManager()
	{
		m_Cache = new ImageCache();
		m_Creater = new ImageCreater();
	}

	public CachedImage fetchImage(String sURL) throws ImageCreationException
	{
		CachedImage image = m_Cache.fetchImage(sURL);
		if (image == null)
		{
			image = m_Creater.createImage(sURL);
			m_Cache.addImage(sURL, image);
		}
		return image;
	}
};