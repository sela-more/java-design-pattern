package flyweight.paymentSystemVer1;
class StateFactory
{
	private StateFactory() {}
	private static StateFactory m_me = new StateFactory();
	public static StateFactory instance() { return m_me;}
	private static final State STATES[] = 
	{
		new IdentificationState(1),
		new VerificationState(2),
		new CreditDateState(3),
		new CreditNumState(4),
		new ConfirmationState(5),
		new ThankYouState(6),
		new ErrorState(7)
	};

	public  State getNextState(int nID)
	{
		return STATES[nID];
	}
	
	public  State getErrorState()
	{
		return STATES[6];
	}

	public  State getIdentificationState()
	{
		return STATES[0];
	}
	
};