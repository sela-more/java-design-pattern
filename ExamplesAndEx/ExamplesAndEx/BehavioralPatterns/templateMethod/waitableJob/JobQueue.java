package templateMethod.waitableJob;
import java.util.LinkedList;

class JobQueue
{
	private LinkedList<AbstractJob>	m_Jobs = new LinkedList<AbstractJob>();
	private JobExecuter m_Executers[];

	JobQueue(int nNumOfExecuters)
	{
		m_Executers = new JobExecuter[nNumOfExecuters];
		for (int i = 0 ; i < nNumOfExecuters ; ++i)
		{
			m_Executers[i] = new JobExecuter(this, "Worker #" + (i + 1));
		}
	}

	public synchronized void addJob(AbstractJob job)
	{
		m_Jobs.addFirst(job);
		notify();
	}

	public synchronized AbstractJob getJob()
	{
		if (m_Jobs.size() == 0)
		{
			try { wait(); } catch (InterruptedException e) {}
			return getJob();
		}
		return (AbstractJob)m_Jobs.removeLast();
	}
};