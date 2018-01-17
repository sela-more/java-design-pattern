package factoryMethod.avoidingReflectionPhoneDirectory;
abstract class PhoneCall 
{
	protected String m_sNumber;
	protected long m_lStartTime;
	protected long m_lEndTime;

	protected PhoneCall() {}
	protected PhoneCall(String sNumber)
	{
		m_sNumber = sNumber;
		m_lStartTime = System.currentTimeMillis();

	}

	public void dial()
	{
		m_lStartTime = System.currentTimeMillis();
	}
	public void hangup()
	{
		m_lEndTime = System.currentTimeMillis();
	}
};