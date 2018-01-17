package immutable.greetingCards;
class Greeting
{
	private String m_sGreeting;
	private String m_sTitle;
	private String m_sFrom = "[your name]";
	private String m_sTo = "[your friend's name]";

	public Greeting(String sTitle, String sGreetingPhrase)
	{
		m_sTitle = sTitle;
		m_sGreeting = sGreetingPhrase;
	}

	private Greeting(String sTitle, String sGreetingPhrase, String sFrom, String sTo)
	{
		this(sTitle, sGreetingPhrase);
		m_sFrom = sFrom;
		m_sTo = sTo;

	}

	public String toString()
	{
		return "Dear " + m_sTo + "\n\n\t" + m_sGreeting + "\n\n\t\tBest Regards," + "\n\n\t\t\t" + m_sFrom;
	}

	public String getTitle()
	{
		return m_sTitle;
	}

	public Greeting setParams(String sFrom, String sTo)
	{
		return new Greeting(m_sTitle, m_sGreeting, sFrom, sTo);
	}
};