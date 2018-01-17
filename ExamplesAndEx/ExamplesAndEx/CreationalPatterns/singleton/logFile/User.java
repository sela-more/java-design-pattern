package singleton.logFile;
import java.io.IOException;
class User extends Thread
{
	User(String sName) { m_sName = sName; }
	private String m_sName;

	public void run()
	{
		for (int i = 0 ; i < 5 ; ++i )
		{
			try
			{
				LogFile.getInstance().writeLine("User " + m_sName + " value = " + i);
				sleep(100);
			}
			catch (IOException error)
			{
				error.printStackTrace();
			}
			catch (InterruptedException e) {} //Do nothing
		}
	}
	public static void main(String args[])
	{
		for (int i = 0 ; i < args.length ; ++i)
		{
			new User(args[i]).start();
		}
	}
};