package flyweight.paymentSystemVer1;

class UserSession
{
	private int m_nID;
	private float m_fSum;
	private boolean m_bDone;
	private String m_sPhoneNumberBill;
	private String m_sCreditCardNumber;
	private String m_sCreditCardDate;
	private String m_sErrorMessage;
	private State m_CurrentState;
	private CreditCardSystem m_PaymentManager;
	private BillingSystem m_BillingManager;

	public UserSession(CreditCardSystem PaymentManager, BillingSystem BillingManager)
	{
		m_PaymentManager = PaymentManager;
		m_BillingManager = BillingManager;
		m_nID = (int)(Math.random() * 1000);
		m_CurrentState = StateFactory.instance().getIdentificationState();
	}

	public float getSum()
	{
		return m_fSum;
	}

	public String getPhoneNumber()
	{
		return m_sPhoneNumberBill;
	}

	public String getCreditCardNumber()
	{
		return m_sCreditCardNumber;
	}

	public String getCreditCardDueDate()
	{
		return m_sCreditCardDate;
	}

	public int getID()
	{
		return m_nID;
	}

	public void setNewState(State NewState)
	{
		m_CurrentState = NewState;
	}
	public void setPhoneNumber(String sPhoneNumber) throws PaymentException
	{
		m_sPhoneNumberBill = sPhoneNumber;
		m_fSum = m_BillingManager.getAmountForPhoneNumber(sPhoneNumber);
	}

	public void setCreditCardNumber(String sCreditCardNumber) throws PaymentException
	{
		m_sCreditCardNumber = sCreditCardNumber;
		m_PaymentManager.checkCreditCardNumber(sCreditCardNumber);
	}
	public void setCreditCardDate(String sCreditCardDate) throws PaymentException
	{
		m_sCreditCardDate = sCreditCardDate;
		m_PaymentManager.checkCreditCardDate(m_sCreditCardNumber, m_sCreditCardDate);
	}
	public void doTransaction() throws PaymentException
	{
		m_PaymentManager.pay(m_sCreditCardNumber, m_sCreditCardDate, m_fSum);
	}

	public boolean isDone()
	{
		return m_bDone;
	}

	public void terminateSession()
	{
		m_bDone = true;
	}

	public void setErrorMessage(String sMessage)
	{
		m_sErrorMessage = sMessage;
	}

	public String getErrorMessage()
	{
		return m_sErrorMessage;
	}
	
	public String getMessage()
	{
		return m_CurrentState.getMessage(this);
	}

	public void setParam(String sUserParam)
	{
		m_CurrentState.setParams(sUserParam, this);
	}
};