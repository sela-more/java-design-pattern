package state.paymentSystem;
class CreditNumState extends State
{
	CreditNumState(UserSession Session)
	{
		super(Session);
	}
	String getMessage()
	{
		return "Please enter your credit card number";
	}
	void setUserParams(String sParam) throws PaymentException
	{
		m_Session.setCreditCardNumber(sParam);
		m_Session.setNewState(new CreditDateState(m_Session));
	}

};