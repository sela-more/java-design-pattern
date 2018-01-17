/*
 * Created on 28/09/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author clsd1
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package compositeDiscussionGroupsWithID;
import java.util.*;
public class CompoundGroupElement extends AbstractGroupElement {

	/**
	 * 
	 */
	private ArrayList m_groupElements;
	public CompoundGroupElement(String name, int ID) {
		super(name,ID);
		// TODO Auto-generated constructor stub
		this.m_groupElements = new ArrayList();
		readExcludeList();
		//readOKList();
	}
	

	/* (non-Javadoc)
	 * @see AbstractGroupElement#display()
	 */
	public void display() {
		// TODO Auto-generated method stub
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

	protected Set m_excludeList = new HashSet();
	protected void readExcludeList() {}
//	protected Set m_OKList = new HashSet();
//	protected void readOKList() {}
	public boolean mayAdd(AbstractGroupElement elem) {
		if (m_excludeList.contains(elem.getID())) return false;
		return true; // default for compound
	
	}
	public void add(AbstractGroupElement elem)  {
		if ( mayAdd(elem)) m_groupElements.add(elem);
	}
}
