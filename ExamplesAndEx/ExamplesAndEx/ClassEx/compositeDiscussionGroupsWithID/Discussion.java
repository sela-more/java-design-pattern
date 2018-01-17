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
public class Discussion extends CompoundGroupElement {

	
	public Discussion(String name) {
		super(name,1);
		
	}
	
	

	public void display() {
		display("");
	}
	
	
	
	protected void readExcludeList() {
		m_excludeList.add(new Integer(3)); // group
		m_excludeList.add(new Integer(1)); // discussion
	}
					// assume read from file
					 
	
		
}
