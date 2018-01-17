package ObserverClock;
import java.util.*;
public class Clock extends Thread {
	
	public void registerViewer(ClockObserver obs) {m_viewers.add(obs);}
	protected void notifyViewers(String msg) {
		for (int i=0; i< m_viewers.size(); i++){
			ClockObserver obs = m_viewers.get(i);
			obs.OnClockNotify(msg);
		}
	}
	
	private List<ClockObserver> m_viewers = new ArrayList<ClockObserver>();
	private int m_counter = 0;

	public void run() {
		while (true) {
		try {
			sleep(1000);
			m_counter ++;
			this.notifyViewers("Another second passed, counter: " + m_counter );
		}
		catch (Exception any) {
			
		}
		}
	}

}
