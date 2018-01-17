package abstractFactoryPhoneDirectoryStarter;


public class BezeqPhoneCall extends PhoneCall {

	
	public BezeqPhoneCall(String number){
		super(number);
	}
	public void dial() {
		// TODO Auto-generated method stub
		System.out.println("Dialing a Bezeq Call " + super.toString());

	}
	
	

}
