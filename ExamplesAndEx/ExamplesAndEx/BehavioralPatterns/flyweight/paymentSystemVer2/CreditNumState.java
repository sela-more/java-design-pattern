package flyweight.paymentSystemVer2;
class CreditNumState extends State
{
	public CreditNumState  (int nID)
	{
		super(nID);
	}
	String getMessage(UserSession Session)
	{
		return "Please enter your credit card number";
	}
	void setUserParams(String sParam, UserSession Session) throws PaymentException
	{
		Session.setCreditCardNumber(sParam);
		Session.setNewState(StateFactory.instance().getNextState(m_nID));
	}
};