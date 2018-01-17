package factoryMethod.reflectionPhoneDirectory;
class BezeqPhoneCall extends PhoneCall
{

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