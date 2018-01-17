package decoratorBugRep;
import java.util.LinkedList;
import java.util.Iterator;
interface IBug
{
	public void history();
	public int getID();
	public String getDesc();
	public int getLevel();
	public void store();
	public IBug rollBack();
}
class Bug implements IBug
{
	private static int m_nCounter;
	private int m_nID;
	private String m_sDesc;
	private String m_sCreator;
	public int getLevel() { return 0; }
	Bug(String sDesc, String sCreator)
	{
		m_nID = ++m_nCounter;
		m_sDesc = sDesc;
		m_sCreator = sCreator;
	}
	public void store()
	{
		System.out.println("INSERT INTO BUGS ID = " + getID() + " LEVEL = " + getLevel());
	}
	
	public void history()
	{
		System.out.println("Created by " + m_sCreator + " Description: " + m_sDesc);
	}
	public int getID() { return m_nID; }
	public String getDesc() { return m_sDesc; }
	
	public IBug rollBack() {
		return this;
	}
};
abstract class BugRole implements IBug
{
	private IBug m_Bug;
	protected BugRole(IBug bug) {m_Bug = bug;}
	public void history() {m_Bug.history();}
	public final int getID() {return m_Bug.getID();}
	public String getDesc()	{return m_Bug.getDesc();}
	public int getLevel() { return m_Bug.getLevel() + 1; }
	public void store()
	{
		m_Bug.store();
	}
	
	public IBug rollBack() {
		return m_Bug;
	}
};
class OpenedBug extends BugRole
{
	private String m_sOpenedBy;
	private LinkedList<String> m_Remarks = new LinkedList<String>();
	public static OpenedBug open(IBug bug, String sName)
	{
		if (bug instanceof OpenedBug)
			return (OpenedBug)bug;
		return new OpenedBug(bug, sName);
	}
	
	private OpenedBug(IBug bug, String sOpenedBy)
	{
		super(bug);
		m_sOpenedBy = sOpenedBy;
	}
	public void addRemark(String sProgrammersName, String sRemark)
	{
		m_Remarks.add("Remark by " + sProgrammersName + ": " + sRemark);
	}
	public void history()
	{
		super.history();
		System.out.println("Opened By " + m_sOpenedBy);
		Iterator<String> iter = m_Remarks.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}
	public void store()
	{
		super.store();
		System.out.println("INSERT INTO OPENED_BUGS ID = " + getID() + " LEVEL = " + getLevel());
	}
};

class ClosedBug extends BugRole
{
	private String m_sClosedBy;
	public static ClosedBug close(IBug bug, String sManager)
	{
		if (bug instanceof ClosedBug)
			return (ClosedBug)bug;
		return new ClosedBug(bug, sManager);
	}
	private ClosedBug(IBug bug, String sClosedBy) 
	{
		super(bug);
		m_sClosedBy = sClosedBy;
	}
	public String getManagerName()
	{
		return m_sClosedBy;
	}
	public void history()
	{
		super.history();
		System.out.println("Closed By " + m_sClosedBy);
	}
	public void store()
	{
		super.store();
		System.out.println("INSERT INTO CLOSED_BUGS ID = " + getID() + " LEVEL = " + getLevel());
	}
};
class Main
{
	public static void main(String args[]) throws Exception
	{
		  IBug bug = new Bug("Not working", "Didi");
		  OpenedBug ob = OpenedBug.open(bug, "Shaul");
		  ob.addRemark("Programmer #1", "fixed");
		  bug = ClosedBug.close(ob, "Manager #1");
		  ob = OpenedBug.open(bug, "Manager #2");
		  bug = ClosedBug.close(ob, "Manager #2");
		  ob = OpenedBug.open(bug, "Manager #3");
		  ob.addRemark("Programmer #2", "fixed");
		  bug = ClosedBug.close(ob,"Manager #3");
		  bug.history();
		  
		  IBug rolledBackBug = bug.rollBack();
		  System.out.println("Type of rolled back bug is: " + rolledBackBug.getClass().getName());
		  
		  rolledBackBug = rolledBackBug.rollBack();
		  System.out.println("Type of rolled back bug is: " + rolledBackBug.getClass().getName());
		
		  //bug.store();
	}
};







