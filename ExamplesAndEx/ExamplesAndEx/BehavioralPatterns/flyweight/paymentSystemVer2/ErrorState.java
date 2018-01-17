package flyweight.paymentSystemVer2;
class ErrorState extends State
{
	public ErrorState (int nID)
	{
		super(nID);
	}
	String getMessage(UserSession Session)
	{
		return "Some error occured.\nError description:\n " + Session.getErrorMessage() + "\nPress enter to terminate";
	}
	void setUserParams(String sParam, UserSession Session) 
	{
		Session.terminateSession();
	}

};