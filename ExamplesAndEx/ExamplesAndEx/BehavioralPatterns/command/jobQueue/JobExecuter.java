package command.jobQueue;
class JobExecuter extends Thread
{
	private JobQueue m_Queue;

	JobExecuter(JobQueue queue, String sName)
	{
		super(sName);
		m_Queue = queue;

		start();
	}

	public void run()
	{
		try {
			while (true)
				m_Queue.getJob().work();
		}
		catch(Exception e)
		{
			return;
		}
	}
};