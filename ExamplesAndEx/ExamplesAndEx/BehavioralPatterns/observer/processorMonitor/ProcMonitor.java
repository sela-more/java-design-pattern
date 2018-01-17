package observer.processorMonitor;
import javax.swing.*;
import java.awt.BorderLayout;
class ProcMonitor extends JFrame
{
	ProcMonitor(int NumOfProcessors)
	{
		super("Processors Monitor");
		setSize(600, 400);
		ProcessorsMonitor Monitor = new ProcessorsMonitor(NumOfProcessors);
		getContentPane().add(new PnlGraph(Monitor));
		getContentPane().add(new PnlLabels(Monitor), BorderLayout.WEST);
		Monitor.registerObserver(new MyProcObserver());
		setVisible(true);
	}
	static class MyProcObserver implements ProcessorObserver
	{
		public void dataChanged()
		{
			System.out.println("In Data Changed");
		}
	};

	public static void main(String args[])
	{
		if (args.length != 1)
		{
			System.out.println("You must supply the number of processors to monitor!");
			return;
		}
		new ProcMonitor(Integer.parseInt(args[0]));
	}
};