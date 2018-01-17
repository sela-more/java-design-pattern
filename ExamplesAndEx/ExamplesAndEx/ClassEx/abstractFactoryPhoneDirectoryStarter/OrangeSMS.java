package abstractFactoryPhoneDirectoryStarter;

public class OrangeSMS extends SMSMessage {

	
	public OrangeSMS(String number,String message) {
		super(number, message);
		
	}

	
	public void makeSMS() {
		
		System.out.println("In ORANGE SMS, " + super.toString());


	}

}
