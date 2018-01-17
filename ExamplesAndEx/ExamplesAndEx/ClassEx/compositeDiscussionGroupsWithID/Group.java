package compositeDiscussionGroupsWithID;
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
public class Group extends CompoundGroupElement {

	/**
	 * 
	 */
		public Group(String name) {
		super(name,3);
		// TODO Auto-generated constructor stub
	}
	
		protected void readExcludeList() {
			m_excludeList.add(new Integer(2)); // Message
			
		}
						// assume read from file
	
	

}
