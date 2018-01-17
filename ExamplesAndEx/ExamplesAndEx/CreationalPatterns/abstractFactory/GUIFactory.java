package abstractFactory; 
abstract class GUIFactory implements AbstractGuiFactory
{
	private static AbstractGuiFactory m_Creator;

	public static synchronized AbstractGuiFactory instance()
	{
		if (m_Creator == null)
		{
			if (System.getProperty("AppTechnology").equalsIgnoreCase("swing"))
				m_Creator = new SwingFactory();
			else
				m_Creator = new AWTFactory();
		}
		return m_Creator;
	}

	public PushButton createButton(String sTitle)
	{
		return m_Creator.createButton(sTitle);
	}

	public TextLine createTextLine(String sTitle)
	{
		return m_Creator.createTextLine(sTitle);
	}

};