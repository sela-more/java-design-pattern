package compositeDiscussionGroups;

abstract public class AbstractGroupElement implements IDisplayable{

	private String m_groupName;
	public AbstractGroupElement(String name){
		this.m_groupName = name;
	}
	
	public String toString() {
		
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
	abstract public void add(AbstractGroupElement elem) ;
		


}
