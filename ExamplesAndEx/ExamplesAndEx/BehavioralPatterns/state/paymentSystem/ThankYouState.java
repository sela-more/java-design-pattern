package state.paymentSystem;
class ThankYouState extends State
{
	ThankYouState(UserSession Session)
	{
		super(Session);
	}
	String getMessage()
	{
		String sMessage = "Thank you for paying you bills.\nYour confirmation number is ";
		sMessage += m_Session.getID();
		sMessage += "\nPress any key to finish.";

		return sMessage;
	}
	void setUserParams(String sParam) 
	{
		m_Session.terminateSession();
	}

};