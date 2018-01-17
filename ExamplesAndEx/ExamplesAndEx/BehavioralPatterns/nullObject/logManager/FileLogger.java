package nullObject.logManager;
import java.io.*;

class FileLogger extends LogManager
{
	private BufferedWriter m_Writer;
	FileLogger(String sFileName) throws IOException
	{
		System.out.println("Trying to instantiate a FileLogger");
		m_Writer = new BufferedWriter(new FileWriter(sFileName));
		System.out.println("FileLogger was instantiated successfully");
	}

	protected void writeLine(String sPrefix, String sLine)
	{
		try
		{
			m_Writer.write(sPrefix);
			m_Writer.write(sLine);	
			m_Writer.newLine();
			m_Writer.flush();
		}
		catch (IOException e)
		{
			throw new LoggingException(e.getMessage());
		}
	}

	protected void finalize() throws Throwable 
	{
		m_Writer.close();
	}
}