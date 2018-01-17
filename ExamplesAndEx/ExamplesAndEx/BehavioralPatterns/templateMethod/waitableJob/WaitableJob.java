package templateMethod.waitableJob;
abstract class WaitableJob implements AbstractJob
{
	private boolean isDone;
	public abstract void performTask();
	public synchronized void waitForCompletion()
	{
		if (isDone)
			return;
		try	{ wait(); }
		catch (InterruptedException e) { waitForCompletion(); }
	}
	private synchronized void markDone()
	{
		notify();
	}
	public final void work()
	{
		performTask();	
		markDone();
	}
};