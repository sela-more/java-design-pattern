package markUp.cache.cache;
class Main
{
	public static void main(String args[])
	{
		CacheManager cm = new CacheManager();
		Object key1 = cm.store(new MyHugeType());
		Object key2 = cm.store(new MyHugeType());
		Object key3 = cm.store(new MyHugeType());

		Cacheable obj1 = cm.get(key1);
		if (obj1 == null)
		{
			System.out.println("First instance was collected.");
		}
	}
};