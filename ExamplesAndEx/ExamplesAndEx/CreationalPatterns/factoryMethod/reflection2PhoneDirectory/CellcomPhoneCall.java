package factoryMethod.reflection2PhoneDirectory;
class CellcomPhoneCall extends PhoneCall
{
	static {
		PhoneDirectory.instance().registerPhoneCall("052", CellcomPhoneCall.class);
		PhoneDirectory.instance().registerPhoneCall("053", CellcomPhoneCall.class);
	}
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