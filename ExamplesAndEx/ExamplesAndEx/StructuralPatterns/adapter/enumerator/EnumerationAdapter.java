package adapter.enumerator;
import java.util.*;

class Client {
	String m_name;
	
	Client(String name) {
		m_name=name;
	}
	
	public String toString() {
		return m_name;
	}
}


class BillingMain {
	public static void main (String args[]) {
		LinkedList ll = new LinkedList();
		ll.add(new Client("shraga"));
		ll.add(new Client("shula"));
		
		Iterator it = ll.iterator();
		printClientList(it);
		
		
		Vector v = new Vector();
		v.add(new Client("old shraga"));
		v.add(new Client("old shula"));
		Enumeration en = v.elements();
		printClientList(new EnumerationAdapter(en));
		
	}
	
	
	public static void printClientList(Iterator itr) {
		while (itr.hasNext()) {
			Client c = (Client)itr.next();
			System.out.println(c);
		}
	}
}



// An adapter
class EnumerationAdapter implements Iterator{
	Enumeration m_enum;
	
	public EnumerationAdapter(Enumeration en) {
		m_enum=en;
	}
	
	public Object next() {
		return m_enum.nextElement();
	}

	public boolean hasNext() {
		return m_enum.hasMoreElements();
	}

	public void remove() {
		System.out.println("Enumeration doesn't have a remove() funcionality");
		throw new UnsupportedOperationException();
	}
}
