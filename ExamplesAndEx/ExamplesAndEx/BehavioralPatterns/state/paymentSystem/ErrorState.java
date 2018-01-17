package state.paymentSystem;
class ErrorState extends State
{
	private String m_sErrorMessage;

	ErrorState(UserSession Session, String sErrorMessage)
	{
		super(Session);
		m_sErrorMessage = sErrorMessage;
	}
	String getMessage()
	{
		return "Some error occured.\nError description:\n " + m_sErrorMessage + "\nPress anter to terminate";
	}
	void setUserParams(String sParam) 
	{
		m_Session.terminateSession();
	}

};