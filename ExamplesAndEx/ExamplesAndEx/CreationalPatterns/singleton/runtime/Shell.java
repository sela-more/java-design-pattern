package singleton.runtime;
class Shell
{
	public static void main(String args[])
	{
		try
		{
			for (int i = 0 ; i < args.length ; ++i)
			{
				System.out.println("Starting " + args[i]);
				Process p = Runtime.getRuntime().exec(args[i]);
				p.waitFor();
			}
		}
		catch (Exception any)
		{
			any.printStackTrace();
		}
	}
};