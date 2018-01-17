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
public class BezeqPhoneCall extends PhoneCall {

	/* (non-Javadoc)
	 * @see PhoneCall#dial(java.lang.String)
	 */
	public BezeqPhoneCall(String number){
		super(number);
	}
	public void dial() {
		// TODO Auto-generated method stub
		System.out.println("Dialing a Bezeq Call " + super.toString());

	}
	/**
	 * 
	 */
	

}
