/*
 * Created on 24/12/2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package factoryMethod.avoidingReflectionPhoneDirectory;

/**
 * @author unknown
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class OrangePhoneCallCreator implements ICallCreator {

	static
	{
		PhoneDirectory.instance().registerPhoneCall("054", new OrangePhoneCallCreator());
	}
	
	public PhoneCall createCall(String sPhoneNumber)
	{
		return new OrangePhoneCall(sPhoneNumber);
	}


}
