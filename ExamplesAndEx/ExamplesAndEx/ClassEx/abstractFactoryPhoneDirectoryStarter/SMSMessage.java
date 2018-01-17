package abstractFactoryPhoneDirectoryStarter;

abstract public class SMSMessage {

	
	
	private String m_number;
	private String m_message;

	public SMSMessage(String number,String message) {
		
		
		m_number = number;	
		m_message = message;
	}
	abstract public void makeSMS();
	public String toString() {
			
			return "Number: " + m_number + " Message: " + m_message;
		}

	

}
