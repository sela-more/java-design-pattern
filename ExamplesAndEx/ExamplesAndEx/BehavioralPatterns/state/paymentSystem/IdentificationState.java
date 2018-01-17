package state.paymentSystem;
class IdentificationState extends State
{
	IdentificationState(UserSession Session)
	{
		super(Session);
	}
	String getMessage()
	{
		return "Welcome!\nPlease enter the phone number to which you want to pay a bill";
	}
	void setUserParams(String sParam) throws PaymentException
	{
		m_Session.setPhoneNumber(sParam);
		m_Session.setNewState(new VerificationState(m_Session));
	}

};