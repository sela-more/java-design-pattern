package templateMethod.waitableJob;
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
		while (true)
			m_Queue.getJob().work();
	}
};