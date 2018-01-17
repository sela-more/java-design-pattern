package markUp.cache.annotation;


import java.util.*;
import java.lang.ref.*;

class CacheManager
{
	private HashMap m_References = new HashMap();
	private int m_nCounter;
	
	public static boolean testAnnon(Class cl) {
		
		Object annot = cl.getAnnotation(CacheableAnnotation.class);
  
		
		if (annot != null)  {
			CacheableAnnotation anot1 = (CacheableAnnotation)annot;
			if (anot1.isMarked()) {
				//System.out.println("Class: "+ cl.getName() + " is Marked as TRUE by CacheableAnnotation");
				return true;
			}
			else
			{
				//System.out.println("Class: "+ cl.getName() + " is Marked at FALSE by CacheableAnnotation");
				return false;
			}
		}
		return false;
		
	}

	public Object store(Object c) throws IllegalArgumentException
	{
		if (testAnnon(c.getClass()) == false)
			throw new IllegalArgumentException("not marked as Cacheable");
		
		String sKey = "" + m_nCounter++;
		m_References.put(sKey, new SoftReference(c));
		return sKey;
	}

	public Object get(Object key)
	{
		SoftReference sr = (SoftReference)m_References.get(key);
		if (sr.get() == null)
		{
			m_References.remove(key);
			return null;
		}

		return sr.get();
	}
};