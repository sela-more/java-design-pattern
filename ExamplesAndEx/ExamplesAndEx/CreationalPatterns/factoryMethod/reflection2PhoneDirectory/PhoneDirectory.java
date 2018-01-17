package factoryMethod.reflection2PhoneDirectory;
import java.util.*;
import java.lang.reflect.*;
class PhoneDirectory
{
	private static final PhoneDirectory m_This = new PhoneDirectory();
	private PhoneDirectory(){};
	
	public static PhoneDirectory instance()
	{
		return m_This;
	}
	
	private HashMap m_PhoneCallClasses = new HashMap();

	public void registerPhoneCall(String sPrefix, Class cClass)
	{
		m_PhoneCallClasses.put(sPrefix, cClass);
	}

	// returns an instance of a specific call obj
	public PhoneCall createCall(String sNumber) throws PhoneCallNotRegisteredException
	{
		try {
			String sPrefix = sNumber.substring(0, sNumber.indexOf("-"));
			Class cClass = (Class)m_PhoneCallClasses.get(sPrefix);
			Constructor ctor = cClass.getDeclaredConstructor(new Class[] { String.class });
			return (PhoneCall)ctor.newInstance(new Object[] { sNumber });
		}
		catch(Exception any)
		{
			throw new PhoneCallNotRegisteredException(sNumber);
		}
	}
};