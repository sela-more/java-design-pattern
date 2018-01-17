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
public class BezeqTelephonyServiceCreator implements ITelephoneServices {

	/* (non-Javadoc)
	 * @see ITelephoneServices#createPhoneCall(java.lang.String)
	 */
	static {
		(TelephoneServiceCreator.instance()).registerCreator("02",new BezeqTelephonyServiceCreator());
		(TelephoneServiceCreator.instance()).registerCreator("03",new BezeqTelephonyServiceCreator());
		(TelephoneServiceCreator.instance()).registerCreator("04",new BezeqTelephonyServiceCreator());
		(TelephoneServiceCreator.instance()).registerCreator("05",new BezeqTelephonyServiceCreator());
		(TelephoneServiceCreator.instance()).registerCreator("06",new BezeqTelephonyServiceCreator());

	}
	public PhoneCall createPhoneCall(String number) {
		// TODO Auto-generated method stub
		
		return new BezeqPhoneCall(number);
	}
	/* (non-Javadoc)
	 * @see ITelephoneServices#createSMSMessage(java.lang.String)
	 */
	public SMSMessage createSMSMessage(String number,String message) {
		// TODO Auto-generated method stub
		return new BezeqSMSMessage(number,message);
	}
}
