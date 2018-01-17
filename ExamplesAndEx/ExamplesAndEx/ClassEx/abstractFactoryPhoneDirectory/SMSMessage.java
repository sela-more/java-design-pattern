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
abstract public class SMSMessage {

	/**
	 * 
	 */
	
	private String m_number;
	private String m_message;

	public SMSMessage(String number,String message) {
		
		
		m_number = number;	
		m_message = message;
	}
	abstract public void makeSMS();
	public String toString() {
			// TODO Auto-generated method stub
			return "Number: " + m_number + " Message: " + m_message;
		}

	

}
