package singleton.simple1;
public class Singleton
{
	private static Singleton Me;
	private Singleton()
	{
		System.out.println("Initializing Instance");
	}

	public static Singleton getInstance()
	{
		if (Me == null)
		{
			System.out.println("First time getInstance was invoked");
			System.out.println("Creating Instance");
			Me = new Singleton();
		}
		return Me;
	}

	public void doSomething()
	{
		System.out.println("Singleton does something");
	}
}