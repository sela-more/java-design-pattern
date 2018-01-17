package flyweight.paymentSystemVer1;
class CreditDateState extends State
{
	CreditDateState (int nID) {
		super(nID);
	}
	String getMessage(UserSession Session)
	{
		return "Please enter your credit card due date";
	}
	void setUserParams(String sParam, UserSession Session) throws PaymentException
	{
		Session.setCreditCardDate(sParam);
		Session.setNewState(StateFactory.instance().getNextState(m_nID));
	}
};