package factoryMethod.reflectionPhoneDirectory;
class CellcomPhoneCall extends PhoneCall
{

	public CellcomPhoneCall(String sPhoneNumber)
	{
		super(sPhoneNumber);
		System.out.println("Cellcom Phone Call Was Instantiacted");
	}
	public void dial()
	{
		super.dial();
		System.out.println("Dialing to cellcom, Phone Nubmer = " + m_sNumber);
	}

	public void hangup()
	{
		super.hangup();
		System.out.println("Cellcom Phone Number was terminated, duration = " + (m_lEndTime - m_lStartTime));
	}
};