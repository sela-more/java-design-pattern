package markUp.cache.annotation;
class Main
{
	public static void main(String args[]) 
	{
		CacheManager cm = new CacheManager();
		
		try {
//			Object key1 = cm.store(new MyHugeType());
//			Object key2 = cm.store(new MyHugeType());
//			Object key3 = cm.store(new MyHugeType());
//			Object key4 = cm.store(new MyHugeType());
//			Object key5 = cm.store(new MyHugeType());
//			Object key6 = cm.store(new MyHugeType());
//			Object key7 = cm.store(new MyHugeType());
//			Object key8 = cm.store(new MyHugeType());
//			Object key9 = cm.store(new MyHugeType());
//			Object key10 = cm.store(new MyHugeType());
	
			// show that derived class is not marked
			//cm.store(new MyOtherHugeClass());
			Object k []= new Object[1000];
			for (int i=0; i<k.length; i++)
				k[i] = cm.store(new MyHugeType());
			
			System.gc();
			
			for (int i=0; i <k.length; i++) {
				Object obj1 = cm.get(k[i]);
				if (obj1 == null)
				{
					System.out.println(" " + i  + "'th instance was collected.");
				}
				else
					System.out.println(" " + i  + "'th instance was  NOT collected." + obj1);
			
				}
		}
		catch (IllegalArgumentException e) {
			System.out.println(e);
		
		}
	}
};