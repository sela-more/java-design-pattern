package abstractFactoryPhoneDirectoryStarter;

public class BezeqSMSMessage extends SMSMessage {


	public BezeqSMSMessage(String number,String message) {
		super( number, message);
		
	}

	
	public void makeSMS() {
		
		System.out.println("In Bezeq SMS, " + super.toString());

	}

}
