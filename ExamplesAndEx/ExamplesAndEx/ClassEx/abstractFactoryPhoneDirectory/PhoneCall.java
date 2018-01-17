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
abstract public class PhoneCall {

	/**
	 * 
	 */
	private String m_number;
	public PhoneCall(String number) {
	
	
		m_number = number;
	}
	abstract public void  dial();
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return "Number: " + m_number;
	}

}
