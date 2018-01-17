/*
 * Created on 23/02/2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package objectPool.cmdWrapper;
import java.io.*;
/**
 * @author didi
 */
public class Cmd implements Runnable, ICmd {

	private Process m_Proc;
	private BufferedReader m_Output;
	private BufferedReader m_Error;
	private BufferedWriter m_Input;
	private StringBuffer m_ErrorLog = new StringBuffer();
	
	public Cmd() throws CmdException
	{
		try
		{
			m_Proc = Runtime.getRuntime().exec("cmd.exe");
			m_Output = new BufferedReader(new InputStreamReader(m_Proc.getInputStream()));
			m_Error = new BufferedReader(new InputStreamReader(m_Proc.getErrorStream()));
			m_Input = new BufferedWriter(new OutputStreamWriter(m_Proc.getOutputStream()));
			for (int i = 0 ; i < 3 ; ++i)
				m_Output.readLine();
			Thread t = new Thread(this);
			t.setDaemon(true);
			t.start();
		}
		catch (IOException any)
		{
			throw new CmdException(any.getMessage());
		}
	}
	
	private String processCommand(String sCommand) throws CmdException
	{
		try
		{
			m_ErrorLog.delete(0, m_ErrorLog.length());
			StringBuffer sbResult = new StringBuffer();
			m_Input.write(sCommand);
			m_Input.newLine();
			m_Input.newLine();
			m_Input.flush();
			String sLine;
			while(!(sLine = m_Output.readLine()).matches("^[A-Z]:\\\\.*>$"))
				sbResult.append(sLine).append("\n");
			if (m_ErrorLog.length() > 0)
				throw new CmdException(m_ErrorLog.toString());
			return sbResult.toString();
		}
		catch (IOException e)
		{
			throw new CmdException(e.getMessage());
		}
	}
	
	public String dir(String sDirectory) throws CmdException
	{
		return processCommand("dir " + sDirectory);
	}
	
	public String tree(String sDirectory) throws CmdException
	{
		return processCommand("tree " + sDirectory);
	}
	
	public String tree() throws CmdException
	{
		return processCommand("tree");
	}
	
	public String dir() throws CmdException
	{
		return processCommand("dir");
	}
	
	public String cd(String sNewDirectory) throws CmdException
	{
		return processCommand("cd " + sNewDirectory);
	}

	public String copy(String sSourceFile, String sDestFile) throws CmdException
	{
		return processCommand("copy \"" + sSourceFile + "\" \"" + sDestFile + "\"");
	}
	
	public String setActiveDrive(char cDrive) throws CmdException
	{
		return processCommand("" + cDrive + ":");
	}
	
	public void close() throws CmdException
	{
		try {
			m_Proc.destroy();
			m_Error.close();
		}
		catch(IOException e)
		{
			throw new CmdException(e.getMessage());
		}
	}
	
	public void run() {
		try {
			while(true)
				m_ErrorLog.append(m_Error.readLine()).append("\n");
		}
		catch(IOException e)
		{
			//Assume process ended - exit
		}
	}
	
	

}
