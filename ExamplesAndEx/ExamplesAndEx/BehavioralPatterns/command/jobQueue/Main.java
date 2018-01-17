package command.jobQueue;
class Main
{
	public static void main(String args[]) throws Exception
	{
		JobQueue queue = new JobQueue(2);
		queue.addJob(new CountToJob("First", 5, 1000));
		queue.addJob(new CountToJob("Second", 10, 300));
		queue.addJob(new CountToJob("Third", 3, 100));

		queue.shutdown();

	}
};