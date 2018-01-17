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

abstract public class AbstractGroupElement implements IDisplayable{

	/**
	 * 
	 */
	
	private Integer m_id;
	public Integer getID() {return m_id;} // for type checking
	
	
	private String m_groupName;
	public AbstractGroupElement(String name, int ID){
		this.m_groupName = name;
		m_id = new Integer(ID);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return m_groupName;
	}
	public String getName() {
		return m_groupName;
	}
	abstract public void display() ;
	abstract public void display(String identLevel) ;
	
	
	public boolean mayAdd(AbstractGroupElement elem) {
		return false; // default for leaf
	
	}
	
//	 default for leaf
	public void add(AbstractGroupElement elem) {System.out.println("Operation not supported");}
		


}
