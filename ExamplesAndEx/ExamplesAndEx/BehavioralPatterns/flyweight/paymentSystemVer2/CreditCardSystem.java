package flyweight.paymentSystemVer2;
class CreditCardSystem
{
	public void checkCreditCardNumber(String sCreditCardNumber) throws PaymentException
	{
		if (sCreditCardNumber.length() != 16)
			throw new PaymentException("Ilegal Credit Card Number");
	}

	public void checkCreditCardDate(String sCreditCardNumber, String sDate) throws PaymentException
	{
		if (sDate.length() != 4)
			throw new PaymentException("Ilegal Expiration Date!");
	}

	public void pay(String sCreditCardNumber, String sDate, float fAmount) throws PaymentException
	{
		if (sCreditCardNumber.length() != 16)
			throw new PaymentException("Ilegal Credit Card Number");

		if (sDate.length() != 4)
			throw new PaymentException("Ilegal Expiration Date!");
	}
};