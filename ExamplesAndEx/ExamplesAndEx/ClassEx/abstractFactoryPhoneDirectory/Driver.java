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
public class Driver {

	/**
	 * 
	 */
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}
	static {
		try {
			Class.forName("abstractFactoryPhoneDirectory.BezeqTelephonyServiceCreator");
			Class.forName("abstractFactoryPhoneDirectory.OrangeTelephneServiceCreator");
	 		
		}
		catch (Exception e) {
			System.out.println("Error in initialization");
		}
	}

	public static void main(String[] args) {
		
		PhoneCall pc = TelephoneServiceCreator.instance().createPhoneCall("03-1234");
		System.out.println(pc);
		pc.dial();
		
		PhoneCall pc2 = TelephoneServiceCreator.instance().createPhoneCall("054-1234");
		System.out.println(pc2);
		pc2.dial();
		
		PhoneCall pc3 = TelephoneServiceCreator.instance().createPhoneCall("02-1234");
		System.out.println(pc3);
		pc3.dial();
		
		SMSMessage sms1 = TelephoneServiceCreator.instance().createSMSMessage("03-1234","This is my First Messsage");
		System.out.println(sms1);
		sms1.makeSMS();
		
		SMSMessage sms2 = TelephoneServiceCreator.instance().createSMSMessage("054-1234","This is my Second Messsage");
		System.out.println(sms2);
		sms2.makeSMS();
	
		
	}
}
