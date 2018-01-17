package flyweight.paymentSystemVer1;
class ConfirmationState extends State
{
	ConfirmationState(int nID)
	{
		super(nID);
	}
	
	String getMessage(UserSession Session)
	{
		String sMessage = "Transaction Details:\nPhone Number: ";
		sMessage += Session.getPhoneNumber();
		sMessage += "\nTotal (in USD): ";
		sMessage += Session.getSum();
		sMessage += "\nCredit Card Number: ";
		sMessage += Session.getCreditCardNumber();
		sMessage += "\nCredit Card Due Date: ";
		sMessage += Session.getCreditCardDueDate();
		sMessage += "\nEnter 'y' if details match. Press any other key to cancel transaction";
		return sMessage;
	}
	void setUserParams(String sParam, UserSession Session) throws PaymentException
	{
		if (!(sParam.equalsIgnoreCase("y")))
			throw new PaymentException("What is the problem with you?");
		Session.doTransaction();
		Session.setNewState(StateFactory.instance().getNextState(m_nID));
	}

};