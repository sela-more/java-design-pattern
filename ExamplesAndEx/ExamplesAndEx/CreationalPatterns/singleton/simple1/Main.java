package singleton.simple1;
class Main
{
	public static void main(String args[])
	{
		System.out.println("MAIN #1 CALL");
		Singleton.getInstance().doSomething();
		System.out.println("MAIN #2 CALL");
		Singleton.getInstance().doSomething();
	}
};