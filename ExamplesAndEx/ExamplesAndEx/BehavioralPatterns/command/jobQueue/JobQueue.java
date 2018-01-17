package command.jobQueue;
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

	public void addJob(AbstractJob job)
	{
		synchronized(m_Jobs)
		{
			m_Jobs.addFirst(job);
			m_Jobs.notify();
		}
	}

	public AbstractJob getJob()
	{
		synchronized (m_Jobs)
		{
			if (m_Jobs.size() == 0)
			{
				try { m_Jobs.wait(); } catch (InterruptedException e) {}
				return getJob();
			}
			return m_Jobs.removeLast();
		}
	}

	public void shutdown()
	{
		for (int i = 0 ; i < m_Executers.length ; ++i)
			addJob(new Shutdown());
	}
	static class ShutdownException extends RuntimeException
	{
	};
	private static class Shutdown implements AbstractJob
	{
		public void work()
		{
			throw new ShutdownException()  ;
		}
	};

};