package markUp.cache.cache;
import java.util.*;
import java.lang.ref.*;

class CacheManager
{
	private HashMap m_References = new HashMap();
	private int m_nCounter;

	public Object store(Cacheable c)
	{
		String sKey = "" + m_nCounter++;
		m_References.put(sKey, new SoftReference(c));
		return sKey;
	}

	public Cacheable get(Object key)
	{
		SoftReference sr = (SoftReference)m_References.get(key);
		if (sr.get() == null)
		{
			m_References.remove(key);
			return null;
		}

		return (Cacheable)sr.get();
	}
};