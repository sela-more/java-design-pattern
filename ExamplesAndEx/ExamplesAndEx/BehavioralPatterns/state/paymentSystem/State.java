package state.paymentSystem;
abstract class State
{
	protected UserSession m_Session;

	State(UserSession Session)
	{
		m_Session = Session;
	}

	abstract String getMessage();
	abstract void setUserParams(String sParam) throws PaymentException;

	final void setParams(String sParam)
	{
		try
		{
			setUserParams(sParam);
		}
		catch (PaymentException e)
		{
			m_Session.setNewState(new ErrorState(m_Session, e.getMessage()));
		}
	}
};