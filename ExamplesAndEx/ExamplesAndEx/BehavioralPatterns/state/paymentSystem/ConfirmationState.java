package state.paymentSystem;
class ConfirmationState extends State
{
	ConfirmationState(UserSession Session)
	{
		super(Session);
	}
	String getMessage()
	{
		String sMessage = "Transaction Details:\nPhone Number: ";
		sMessage += m_Session.getPhoneNumber();
		sMessage += "\nTotal (in USD): ";
		sMessage += m_Session.getSum();
		sMessage += "\nCredit Card Number: ";
		sMessage += m_Session.getCreditCardNumber();
		sMessage += "\nCredit Card Due Date: ";
		sMessage += m_Session.getCreditCardDueDate();
		sMessage += "\nEnter 'y' if details match. Press any other key to cancel transaction";
		return sMessage;
	}
	void setUserParams(String sParam) throws PaymentException
	{
		if (!(sParam.equalsIgnoreCase("y")))
			throw new PaymentException("What is the problem with you?");
		m_Session.doTransaction();
		m_Session.setNewState(new ThankYouState(m_Session));
	}

};