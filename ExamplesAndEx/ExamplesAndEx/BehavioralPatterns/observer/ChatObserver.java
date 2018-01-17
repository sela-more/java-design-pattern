package observer;
import java.util.*;

public class ChatObserver implements Observer{
	String m_userName;

	public ChatObserver(String userName) {
		m_userName = userName;
	}

	public void update(Observable o, Object arg) {
			ArrayList existingUsers = (ArrayList)arg;
			String allUsers="";
			for (int i=0; i<existingUsers.size(); i++)
				allUsers+=((ChatObserver)existingUsers.get(i)).m_userName+", ";
			System.out.println(m_userName+" was nofitied by observer. Users: " + allUsers);
	}
}