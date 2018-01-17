/*
 * Created on 19/12/2005
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
public interface ICallCreator {
	
	public PhoneCall createCall(String sNumber) throws PhoneCallNotRegisteredException;


}
