package state.paymentSystem;
class CreditDateState extends State
{
	CreditDateState(UserSession Session)
	{
		super(Session);
	}
	String getMessage()
	{
		return "Please enter your credit card due date";
	}
	void setUserParams(String sParam) throws PaymentException
	{
		m_Session.setCreditCardDate(sParam);
		m_Session.setNewState(new ConfirmationState(m_Session));
	}

};