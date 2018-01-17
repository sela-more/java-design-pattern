package nullObject.logManager;
class NullLogger extends LogManager
{
	NullLogger()
	{
		System.out.println("NullLogger was instantiated");
	}
	protected void writeLine(String sPrefix, String sLine)
	{
		//Do Nothing
	}
};