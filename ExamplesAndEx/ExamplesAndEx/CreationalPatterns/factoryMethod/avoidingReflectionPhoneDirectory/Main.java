package factoryMethod.avoidingReflectionPhoneDirectory;
class Main
{
	static
	{
		try {
		//Before program starts, register phone call
		Class.forName("factoryMethod.avoidingReflectionPhoneDirectory.CellcomPhoneCallCreator");
		Class.forName("factoryMethod.avoidingReflectionPhoneDirectory.OrangePhoneCallCreator");
		Class.forName("factoryMethod.avoidingReflectionPhoneDirectory.BezeqPhoneCallCreator");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
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