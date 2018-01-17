package ObserverClock;

public class ClockDriver {

	
	public static void main(String[] args) {
		Clock clock = new Clock();
		clock.start();
		
		ClockViewer v1 = new ClockViewer("first");
		ClockViewer v2 = new ClockViewer("Second");
		v1.start();
		v2.start();
		
		clock.registerViewer(v1);
		clock.registerViewer(v2);
		

	}

}
