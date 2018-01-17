package abstractFactoryPhoneDirectoryStarter;

public class OrangePhoneCall extends PhoneCall {

	
	public OrangePhoneCall(String number){
		super(number);
		
	}

	
	public void dial() {
		
		System.out.println("Dialing an Orange Call," + super.toString());

	}

}
