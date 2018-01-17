package ObserverClock;

public class ClockViewer extends Thread implements ClockObserver  {

	//private String m_id;
	
	public ClockViewer(String name) {super(name);}
	public void OnClockNotify(String msg) {
		System.out.println("My name: " + this.getName() + " , Got a message from clock, message is: " + msg);

	}
	public void run() {
		while (true) {
			try {
				sleep (500);
			}
			catch (Exception any) {
				
			}
		}
	}

}
