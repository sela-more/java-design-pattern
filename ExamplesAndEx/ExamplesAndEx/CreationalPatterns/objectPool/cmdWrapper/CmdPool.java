/*
 * Created on 23/02/2004
 * Examples for Java Design Patterns course
 * (c) Sela-YouNiversity
 */
package objectPool.cmdWrapper;
import java.util.LinkedList;
/**
 * @author didi
 */
public class CmdPool {
	private LinkedList m_Cmds = new LinkedList();
	private CmdPool() {}
	private static CmdPool m_instance = new CmdPool();
	private static final int MAX_ALLOWED = 1;
	private int m_nCreationCount = MAX_ALLOWED;
	public static CmdPool getInstance() { return m_instance; }
	
	public ICmd aquireCmd() throws CmdException
	{
		try {
			synchronized(m_Cmds)
			{
				if (m_Cmds.size() > 0)
				{
					return (ICmd)m_Cmds.removeLast();
				}
				if (m_nCreationCount > 0)
				{
					--m_nCreationCount;
					return new Cmd();
				}
				
				try { m_Cmds.wait(); } catch(InterruptedException e){}
				return aquireCmd();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;	
		}
	}
	
	public void  releaseCmd(ICmd cmd)
	{
		synchronized(m_Cmds)
		{
			m_Cmds.addLast(cmd);
			m_Cmds.notify();
		}
	}
}
