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
public interface ITelephoneServices {
	public PhoneCall createPhoneCall(String number);
	public SMSMessage createSMSMessage(String number,String message);

}
