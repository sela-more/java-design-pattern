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
public class OrangeSMS extends SMSMessage {

	/**
	 * 
	 */
	public OrangeSMS(String number,String message) {
		super(number, message);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see SMSMessage#makeSMS(java.lang.String)
	 */
	public void makeSMS() {
		// TODO Auto-generated method stub
		System.out.println("In ORANGE SMS, " + super.toString());


	}

}
