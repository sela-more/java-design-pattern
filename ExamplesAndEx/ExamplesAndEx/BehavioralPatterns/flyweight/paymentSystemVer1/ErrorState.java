package flyweight.paymentSystemVer1;
class ErrorState extends State
{
	ErrorState (int nID)
	{
		super(nID);
	}
	String getMessage(UserSession Session)
	{
		return "Some error occured.\nError description:\n " + Session.getErrorMessage() + "\nPress anter to terminate";
	}
	void setUserParams(String sParam, UserSession Session) 
	{
		Session.terminateSession();
	}

};