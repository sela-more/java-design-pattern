package singleton.logFile;
import java.io.*;
class LogFile
{
	private static LogFile Me;
	private static final String m_FileName = "log.txt";
	private BufferedWriter m_Writer;
	private LogFile() throws IOException
	{
		m_Writer = new BufferedWriter(new FileWriter(m_FileName));
	}
	public static LogFile getInstance() throws IOException
	{
		if (Me == null)
			Me = new LogFile();
		return Me;
	}
	public void writeLine(String sLine) throws IOException
	{
		m_Writer.write(sLine);
		m_Writer.newLine();
		m_Writer.flush();
	}
};