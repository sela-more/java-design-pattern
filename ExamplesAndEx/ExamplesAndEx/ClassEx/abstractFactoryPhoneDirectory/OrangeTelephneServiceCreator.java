package abstractFactoryPhoneDirectory;
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
public class OrangeTelephneServiceCreator implements ITelephoneServices {

	/* (non-Javadoc)
	 * @see ITelephoneServices#createPhoneCall(java.lang.String)
	 */
	static {
		
			(TelephoneServiceCreator.instance()).registerCreator("054",new OrangeTelephneServiceCreator());
			(TelephoneServiceCreator.instance()).registerCreator("056",new OrangeTelephneServiceCreator());
			(TelephoneServiceCreator.instance()).registerCreator("058",new OrangeTelephneServiceCreator());

	}
	public PhoneCall createPhoneCall(String number) {
		// TODO Auto-generated method stub
		return new OrangePhoneCall(number);
	}
	/* (non-Javadoc)
	 * @see ITelephoneServices#createSMSMessage(java.lang.String)
	 */
	public SMSMessage createSMSMessage(String number,String message) {
		// TODO Auto-generated method stub
		return new OrangeSMS(number,message); 
	}
	/**
	 * 
	 */
	

}
