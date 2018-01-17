package factoryMethod.reflectionPhoneDirectory;
class Main
{
	static 
	{
		//Before program starts, register phone call
		PhoneDirectory.instance().registerPhoneCall("052", CellcomPhoneCall.class);
		PhoneDirectory.instance().registerPhoneCall("054", OrangePhoneCall.class);
		PhoneDirectory.instance().registerPhoneCall("03", BezeqPhoneCall.class);
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