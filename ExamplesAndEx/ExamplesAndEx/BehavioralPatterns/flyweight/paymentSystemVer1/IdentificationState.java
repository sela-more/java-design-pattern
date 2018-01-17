package flyweight.paymentSystemVer1;
class IdentificationState extends State
{
	IdentificationState (int nID)
	{
		super(nID);
	}
	String getMessage(UserSession Session)
	{
		return "Welcome!\nPlease enter the phone number to which you want to pay a bill";
	}
	void setUserParams(String sParam, UserSession Session) throws PaymentException
	{
		Session.setPhoneNumber(sParam);
		Session.setNewState(StateFactory.instance().getNextState(m_nID));
	}

};