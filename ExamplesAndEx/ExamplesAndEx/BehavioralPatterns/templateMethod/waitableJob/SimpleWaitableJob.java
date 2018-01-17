package templateMethod.waitableJob;
class SimpleWaitableJob extends WaitableJob
{
	private int m_nTo;
	private int m_nSleepTime;
	private String m_sJobName;

	SimpleWaitableJob(String sJobName, int nTo, int nSleepTime)
	{
		m_sJobName = sJobName;
		m_nTo = nTo;
		m_nSleepTime = nSleepTime;
		System.out.println("job '" +  m_sJobName + "' was created");
	}

	public void performTask()
	{
		System.out.println("Job '" + m_sJobName + "' was started by " + Thread.currentThread().getName());
		for (int i = 0 ; i < m_nTo ; ++i)
		{
			System.out.println(m_sJobName + " counts. Value = " + i + "/" + m_nTo);
			try
			{
				Thread.sleep(m_nSleepTime);
			}
			catch (InterruptedException e)
			{
				//Do nothing
			}
		}
	}

};