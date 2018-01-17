package observer.processorMonitor;
import java.util.ArrayList;
import java.util.Iterator;

class ProcessorsMonitor extends Thread implements ProcessorInterest
{
	private ArrayList m_Observers;
	private int m_Processors[];
	private static final int MAX_VALUE = 100;

	public ProcessorsMonitor(int nNumOfProcessors)
	{
		m_Processors = new int[nNumOfProcessors];
		m_Observers = new ArrayList();
		setValues();
		start();
	}

	private synchronized void setValues()
	{
		for (int i = 0 ; i < m_Processors.length ; ++i )
		{
			m_Processors[i] = (int)(Math.random() * MAX_VALUE);
		}
	}

	private synchronized void notifyAllObserver()
	{
		Iterator iter = m_Observers.iterator();
		while (iter.hasNext())
		{
			((ProcessorObserver)iter.next()).dataChanged();
		}
	}



	public void run()
	{
		while(true)
		{
			try
			{
				sleep(500);
			}
			catch (InterruptedException e)
			{
				//
			}
			setValues();
			notifyAllObserver();
		}
	}
	public synchronized void registerObserver(ProcessorObserver PO)
	{
		m_Observers.add(PO);
	}

	public synchronized int getSize()
	{
		return m_Processors.length;
	}

	public synchronized int getValueAt(int index)
	{
		return m_Processors[index];
	}

	public int getMaxValue()
	{
		return MAX_VALUE;
	}


};