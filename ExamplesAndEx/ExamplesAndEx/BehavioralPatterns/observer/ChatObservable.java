package observer;
import java.util.*;

public class ChatObservable extends Observable{
	ArrayList m_allUsers = new ArrayList();

	public void addUser(ChatObserver newUser) {
		m_allUsers.add(newUser);
		addObserver(newUser);
		setChanged();
		System.out.println("\n" + newUser.m_userName + " Added. Notifying............");
		notifyObservers(m_allUsers);
	}


	public static void main (String args[]) {
		ChatObservable chatManager = new ChatObservable();

		ChatObserver bart = new ChatObserver("Bart");
		chatManager.addUser(bart);
		ChatObserver homer = new ChatObserver("Homer");
		chatManager.addUser(homer);
		ChatObserver lisa = new ChatObserver("Lisa");
		chatManager.addUser(lisa);
	}
}