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
public class BezeqPhoneCallCreator implements ICallCreator {

	/* (non-Javadoc)
	 * @see factoryMethod.avoidingReflectionPhoneDirectory.ICallCreator#createCall(java.lang.String)
	 */
	static {
		PhoneDirectory.instance().registerPhoneCall("03", new BezeqPhoneCallCreator());
	}
	

	public PhoneCall createCall(String sPhoneNumber)
	{
		return new BezeqPhoneCall(sPhoneNumber);
	}

}
