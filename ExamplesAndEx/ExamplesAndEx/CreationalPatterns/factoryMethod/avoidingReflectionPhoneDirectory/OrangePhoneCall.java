package factoryMethod.avoidingReflectionPhoneDirectory;
class OrangePhoneCall extends PhoneCall
{
	
	private OrangePhoneCall() {}
	OrangePhoneCall(String sPhoneNumber)
	{
		super(sPhoneNumber);
		System.out.println("Orange Phone Call Was Instantiated");
	}

	public void dial()
	{
		super.dial();
		System.out.println("Dialing to orange, Phone Nubmer = " + m_sNumber);
	}

	public void hangup()
	{
		super.hangup();
		System.out.println("Orange Phone Number was terminated, duration = " + (m_lEndTime - m_lStartTime));
	}
};