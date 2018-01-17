package state.paymentSystem;
class VerificationState extends State
{
	VerificationState(UserSession Session)
	{
		super(Session);
	}
	String getMessage()
	{
		return "According to our records, your have to pay " + m_Session.getSum() + "$\nPress y to continue or any other key to terminate.";
	}
	void setUserParams(String sParam) throws PaymentException
	{
		if (!(sParam.equalsIgnoreCase("y")))
			throw new PaymentException("Please contact our customers service department for more details");
		m_Session.setNewState(new CreditNumState(m_Session));
	}

};