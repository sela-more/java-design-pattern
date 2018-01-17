package immutable.greetingCards;
class Client
{
	public static void main(String args[])
	{
		GreetingManager Manager = new GreetingManager();
		String sTitles[] = Manager.getTitles();
		
		for (int i = 0 ; i < sTitles.length ; ++i )
			System.out.println((i + 1) + ". " + sTitles[i]);

		newLine();

		Greeting g = Manager.getGreeting(0);
		System.out.println(g);

		newLine();

		g = g.setParams("Mark", "Suzan");
		System.out.println(g);

		newLine();

		g = Manager.getGreeting(0);
		System.out.println(g);
	}

	private static void newLine()
	{
		System.out.println();
		System.out.println("********************************************************************************");
		System.out.println();
	}
};