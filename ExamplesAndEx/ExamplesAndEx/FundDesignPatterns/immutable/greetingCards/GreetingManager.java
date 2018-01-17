package immutable.greetingCards;
import java.util.ArrayList;
import java.util.Iterator;

class GreetingManager
{
	private ArrayList<Greeting> m_Greetings = new ArrayList<Greeting>();

	private void initMessages()
	{
		m_Greetings.add(new Greeting("birthday", "happy birthday to you."));
		m_Greetings.add(new Greeting("get well", "I hope you get well soon."));
		m_Greetings.add(new Greeting("new baby son", "congradulations on the birth of your son."));
		m_Greetings.add(new Greeting("new baby girl", "congradulations on the birth of your girl."));
	}

	GreetingManager()
	{
		initMessages();
	}

	public String[] getTitles()
	{
		String sTitles[] = new String[m_Greetings.size()];
		Iterator<Greeting> iter = m_Greetings.iterator();
		int i = 0;
		while(iter.hasNext())
			sTitles[i++] = (iter.next()).getTitle();

		return sTitles;
	}

	public Greeting getGreeting(int nID)
	{
		return (Greeting)m_Greetings.get(nID);
	}
};