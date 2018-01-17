package nullObject.logManager;
import java.io.IOException;
abstract class LogManager
{
	/**
	/* This class uses the followingpatterns:
	/* 1. Singleton
	/* 2. Factory
	/* 3. Template Method
	**/
	static {
		initLogManager();
	}

	private static void initLogManager()
	{
		String sPropertyVal = System.getProperty("logf");
		if ((sPropertyVal == null) || (sPropertyVal.equalsIgnoreCase("null")))
			m_LogImpl = new NullLogger();
		else if (sPropertyVal.equalsIgnoreCase("stderr"))
			m_LogImpl = new StderrLogger();
		else
		{
			try
			{
				m_LogImpl = new FileLogger(sPropertyVal);
			}
			catch (IOException e)
			{
				e.printStackTrace();
				m_LogImpl = new StderrLogger();
			}
		}
	}

	private static LogManager m_LogImpl;
	
	public static LogManager getInstance()
	{
		return m_LogImpl;
	}

	public final void writeErrorMessage(String sMessage)
	{
		try
		{
			writeLine("Error: ", sMessage);	
		}
		catch (LoggingException e)
		{
			m_LogImpl = new StderrLogger();
			writeLine("Error: ", "Internal Log Error. Redirecting to Stderr");
			writeLine("Error: ", sMessage);	
		}	
	}

	protected abstract void writeLine(String sPrefix, String sLine);
	
};