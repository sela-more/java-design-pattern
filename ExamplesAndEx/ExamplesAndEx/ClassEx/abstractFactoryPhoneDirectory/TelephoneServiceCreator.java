/*
 * Created on 27/09/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author clsd1
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package abstractFactoryPhoneDirectory;
import java.util.*;
public class TelephoneServiceCreator implements ITelephoneServices {

	/**
	 * 
	 */
	// make this a singleton
	private static TelephoneServiceCreator m_me;
	public static  synchronized TelephoneServiceCreator instance() {
		if (m_me == null)
			m_me = new TelephoneServiceCreator();
		return m_me;
	}
	
	// manage the extensions to support
	private HashMap<String,ITelephoneServices> m_creators = new HashMap<String,ITelephoneServices>();
	public void registerCreator(String ext,ITelephoneServices creator) {
		m_creators.put(ext,creator);
	}
	public ITelephoneServices getCreator(String number) {
		// Analyze the number, and based on the string return
		// the appropriate creator.
		String prefix = number.substring(0, number.indexOf("-"));
		ITelephoneServices creator = (ITelephoneServices) m_creators.get(prefix);
		return creator;
	}
	
	private  TelephoneServiceCreator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see ITelephoneServices#createPhoneCall(java.lang.String)
	 */
	
	public PhoneCall createPhoneCall(String number) {
		// TODO Auto-generated method stub
		return getCreator(number).createPhoneCall(number);
	}

	/* (non-Javadoc)
	 * @see ITelephoneServices#createSMSMessage(java.lang.String)
	 */
	public SMSMessage createSMSMessage(String number,String message) {
		// TODO Auto-generated method stub
		return getCreator(number).createSMSMessage(number,message);

	}

}
