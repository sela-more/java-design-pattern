package flyweight.paymentSystemVer2;
class PaymentException extends Exception 
{
	/** 
	/* Base class for all excpetion in system (Practically, the only one
	**/

	PaymentException(String sMessage)
	{
		super(sMessage);
	}
};