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
public class OrangePhoneCall extends PhoneCall {

	/**
	 * 
	 */
	public OrangePhoneCall(String number){
		super(number);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see PhoneCall#dial(java.lang.String)
	 */
	public void dial() {
		// TODO Auto-generated method stub
		System.out.println("Dialing an Orange Call," + super.toString());

	}

}
