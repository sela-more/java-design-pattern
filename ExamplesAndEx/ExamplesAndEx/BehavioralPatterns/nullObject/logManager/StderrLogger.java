package nullObject.logManager;
class StderrLogger extends LogManager
{
	StderrLogger()
	{
		System.out.println("StderrLogger was instantiated");
	}
	protected void writeLine(String sPrefix, String sLine)
	{
		System.err.print(sPrefix);
		System.err.println(sLine);
	}
};