package factoryMethod.reflection2PhoneDirectory;
class Main
{
	static 
	{
		try
		{
			Class.forName("factoryMethod.reflection2PhoneDirectory.CellcomPhoneCall");
			Class.forName("factoryMethod.reflection2PhoneDirectory.OrangePhoneCall");
			Class.forName("factoryMethod.reflection2PhoneDirectory.BezeqPhoneCall");
		}
		catch (ClassNotFoundException any)
		{
			any.printStackTrace();
		}
	}
	public static void main(String args[]) throws PhoneCallNotRegisteredException
	{
		for (int i = 0 ; i < args.length ; ++i)
		{
			PhoneCall pc = PhoneDirectory.instance().createCall(args[i]);
			pc.dial();
			try { Thread.sleep((int)(Math.random() * 1000)); } catch(Exception any){}
			pc.hangup();
		}
	}
};