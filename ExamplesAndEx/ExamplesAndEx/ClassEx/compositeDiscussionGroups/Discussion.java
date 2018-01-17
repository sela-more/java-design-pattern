
package compositeDiscussionGroups;
import java.util.*;
public class Discussion extends AbstractGroupElement {

	
	private ArrayList m_messages;
	public Discussion(String name) {
		super(name);
		m_messages = new ArrayList();
	}
	
	

	
	public void display() {
		display("");
	}
	public void display(String ident) {
		
		System.out.println(ident+ "Displaying Discussion Messages: Name: " + super.getName());
		ident = ident + "\t";
		Iterator iter = this.m_messages.iterator();
		while (iter.hasNext()) {
			
			Message msg = (Message)iter.next();
			msg.display(ident);
		}
	}
	public void addMessage(Message msg){
		this.m_messages.add(msg);
	
	}
	
	public void add(AbstractGroupElement elem)  {
		// do nothing
		System.out.println("Discussion does not support add of AGE");
	
	}
		
}
