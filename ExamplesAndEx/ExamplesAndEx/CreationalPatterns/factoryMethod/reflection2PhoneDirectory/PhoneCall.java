package factoryMethod.reflection2PhoneDirectory;
abstract class PhoneCall
{
	protected String m_sNumber;
	protected long m_lStartTime;
	protected long m_lEndTime;

	public PhoneCall(String sNumber)
	{
		m_sNumber = sNumber;
		
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