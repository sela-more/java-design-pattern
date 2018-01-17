package flyweight.paymentSystemVer1;
abstract class State
{
	protected State(int nID)
	{
		m_nID = nID;
		System.out.println("An instance of class state was created");
	}

	protected int m_nID;
	abstract String getMessage(UserSession m_Session);
	abstract void setUserParams(String sParam, UserSession Session) throws PaymentException;

	final void setParams(String sParam, UserSession Session)
	{
		try
		{
			setUserParams(sParam, Session);
		}
		catch (PaymentException e)
		{
			Session.setErrorMessage(e.getMessage());
			Session.setNewState(StateFactory.instance().getErrorState());
		}
	}
};