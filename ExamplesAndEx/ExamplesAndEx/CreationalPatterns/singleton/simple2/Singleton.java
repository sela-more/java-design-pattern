package singleton.simple2;
class Singleton
{
	private static Singleton Me;
	
	static {
		// Instance is created not in the getInstance
		// But in the Class Static Block
		System.out.println("Initializing Object");
		Me = new Singleton();
	}
	private Singleton()
	{
		System.out.println("Initializing Instance");
	}

	public static Singleton getInstance()
	{
		// No need for "If"
		return Me;
	}

	public void doSomething()
	{
		System.out.println("Singleton does something");
	}
}