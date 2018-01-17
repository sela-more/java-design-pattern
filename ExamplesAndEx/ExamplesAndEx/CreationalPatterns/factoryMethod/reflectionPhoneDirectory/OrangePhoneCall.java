package factoryMethod.reflectionPhoneDirectory;
class OrangePhoneCall extends PhoneCall
{

	public OrangePhoneCall(String sPhoneNumber)
	{
		super(sPhoneNumber);
		System.out.println("Orange Phone Call Was Instantiacted");
	}
	public void dial()
	{
		super.dial();
		System.out.println("Dialing to orange, Phone Nubmer = " + m_sNumber);
	}

	public void hangup()
	{
		super.hangup();
		System.out.println("Oellcom Phone Number was terminated, duration = " + (m_lEndTime - m_lStartTime));
	}
};