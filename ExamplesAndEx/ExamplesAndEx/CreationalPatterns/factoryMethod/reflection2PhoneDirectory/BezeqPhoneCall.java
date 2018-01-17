package factoryMethod.reflection2PhoneDirectory;
class BezeqPhoneCall extends PhoneCall
{
	static {
		PhoneDirectory.instance().registerPhoneCall("03", BezeqPhoneCall.class);
		PhoneDirectory.instance().registerPhoneCall("02", BezeqPhoneCall.class);
		PhoneDirectory.instance().registerPhoneCall("04", BezeqPhoneCall.class);
		PhoneDirectory.instance().registerPhoneCall("09", BezeqPhoneCall.class);
	}
	public BezeqPhoneCall(String sPhoneNumber)
	{
		super(sPhoneNumber);
		System.out.println("Bezeq Phone Call Was Instantiacted");
	}
	public void dial()
	{
		super.dial();
		System.out.println("Dialing to bezeq, Phone Nubmer = " + m_sNumber);
	}

	public void hangup()
	{
		super.hangup();
		System.out.println("Bezeq Phone Number was terminated, duration = " + (m_lEndTime - m_lStartTime));
	}
};