package templateMethod.waitableJob;
class Main
{
	public static void main(String args[])
	{
		JobQueue queue = new JobQueue(2);
		System.out.println("### Adding First Waitable ###");
		WaitableJob WJ = new SimpleWaitableJob("First Waitable", 10, 1000);
		queue.addJob(WJ);
		System.out.println("### Adding First Non Waitable ###");
		queue.addJob(new CountToJob("First Non Waitable", 5, 500));
		System.out.println("### Waiting for the waitable job to complete.........................");
		WJ.waitForCompletion();
		System.out.println("### Waitable job was completed. continue ###");
		System.out.println("### Adding Second Non Waitable ###");
		queue.addJob(new CountToJob("Second Non Waitable", 10, 300));
		System.out.println("### Adding Third Non Waitable ###");
		queue.addJob(new CountToJob("Third Non Waitable", 3, 100));
	}
};