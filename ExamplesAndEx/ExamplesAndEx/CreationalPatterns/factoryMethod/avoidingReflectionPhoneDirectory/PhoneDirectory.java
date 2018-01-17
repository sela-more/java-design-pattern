package factoryMethod.avoidingReflectionPhoneDirectory;
import java.util.*;
//import java.lang.reflect.*;
class PhoneDirectory
{
	private static final PhoneDirectory m_This = new PhoneDirectory();
	private HashMap m_PhoneCallClasses = new HashMap();
	private PhoneDirectory(){};
	public static PhoneDirectory instance() {
		return m_This;
	}
	public void registerPhoneCall(String sPrefix, ICallCreator pc)	{
		m_PhoneCallClasses.put(sPrefix, pc);
	}
	public PhoneCall createCall(String sNumber) throws PhoneCallNotRegisteredException
	{
		try {
			String sPrefix = sNumber.substring(0, sNumber.indexOf("-"));
			return ((ICallCreator)m_PhoneCallClasses.get(sPrefix)).createCall(sNumber);
		}
		catch(Exception any)
		{
			throw new PhoneCallNotRegisteredException(sNumber);
		}
	}
};