package flyweight.paymentSystemVer2;
abstract class State
{
	protected int  m_nID;
	protected State(int nID)
	{
		System.out.println("An instance of class state was created, ID: " + nID);
		m_nID = nID;
	}
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