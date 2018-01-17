
package compositeDiscussionGroups;
import java.util.*;
public class CompoundGroupElement extends AbstractGroupElement {

	
	private ArrayList m_groupElements;
	public CompoundGroupElement(String m_name) {
		super(m_name);
		
		this.m_groupElements = new ArrayList();
	}
	

	
	public void display() {
		
		display("");

	}
	public void display(String identLevel) {
		StringBuffer ident = new StringBuffer(identLevel);
		
		System.out.println(ident+ "Displaying group Information: Name: " + super.getName());
		Iterator iter = this.m_groupElements.iterator();
		ident.append("\t");
		while (iter.hasNext()) {
			
			AbstractGroupElement gElem = (AbstractGroupElement)iter.next();
			gElem.display(ident.toString());
		}
	
	}

	public boolean mayAdd(AbstractGroupElement elem) {
		return true; // default for compound
	
	}
	public void add(AbstractGroupElement elem)  {
		m_groupElements.add(elem);
	}
}
