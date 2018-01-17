package abstractFactoryPhoneDirectoryStarter;

abstract public class PhoneCall {

	
	private String m_number;
	public PhoneCall(String number) {
	
	
		m_number = number;
	}
	abstract public void  dial();
	

	
	public String toString() {
		
		return "Number: " + m_number;
	}

}
