package flyweight.paymentSystemVer1;
class VerificationState extends State
{
	VerificationState(int nID)
	{
		super(nID);
	}

	String getMessage(UserSession Session)
	{
		return "According to our records, your have to pay " 
			+ Session.getSum() + "$\nPress y to continue or any other key to terminate.";
	}
	void setUserParams(String sParam, UserSession Session) throws PaymentException
	{
		if (!(sParam.equalsIgnoreCase("y")))
			throw new PaymentException("Please contact our customers service department for more details");
		Session.setNewState(StateFactory.instance().getNextState(m_nID));
	}

};