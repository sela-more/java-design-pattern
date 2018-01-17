package flyweight.paymentSystemVer1;
class ThankYouState extends State
{
	ThankYouState(int nID)
	{
		super(nID);
	}
	String getMessage(UserSession Session)
	{
		String sMessage = "Thank you for paying you bills.\nYour confirmation number is ";
		sMessage += Session.getID();
		sMessage += "\nPress any key to finish.";

		return sMessage;
	}
	void setUserParams(String sParam, UserSession Session) 
	{
		Session.terminateSession();
	}

};