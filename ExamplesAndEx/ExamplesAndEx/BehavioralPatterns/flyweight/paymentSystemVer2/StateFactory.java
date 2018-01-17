package flyweight.paymentSystemVer2;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;
class StateFactory
{
	private StateFactory() {}
	private static StateFactory m_me = new StateFactory();
	public static StateFactory instance() { return m_me;}
	private static ArrayList m_States = new ArrayList();
	static {
		initStates();
	}

	public  State getFirstState()
	{
		return (State)m_States.get(0);
	}
	private static void initStates()
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("flyweight//paymentSystemVer2//config.log"));
			String sClassName;
			int i = 0;
			while((sClassName=reader.readLine()) != null)
			{
				Class cState = Class.forName(sClassName);
				Constructor ctor =cState.getDeclaredConstructor(new Class[] {int.class});
				Object o = ctor.newInstance(new Object[] {new Integer(++i)});
				m_States.add(o);
			}
			reader.close();
		}
		catch (Exception error)
		{
			error.printStackTrace();
			System.exit(1);
		}
	}

	public  State getNextState(int nNextState)
	{
		System.out.println(nNextState);
		// the ID of a state is 1 when the position is 0
		return (State)m_States.get(nNextState );
	}
	
	static State sError = new ErrorState(0);
	public  State getErrorState()
	{
		return sError;
	}
	
	
};