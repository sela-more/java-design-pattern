package state.paymentSystem;
class BillingSystem
{
	public float getAmountForPhoneNumber(String sPhoneNumber) throws PaymentException
	{
		if (sPhoneNumber.length() != 9)
			throw new PaymentException("Ilegal Phone Number");
		//Fetch data from database
		return (float)Math.random() * 1000;
	}

	public void setPayment(String sPhoneNumber, float fSum)
	{
		//Register transaction in dabase
	}
}